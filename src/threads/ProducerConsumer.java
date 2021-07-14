package threads;

import java.util.*;

public class ProducerConsumer {
	public static void main(String[] args) {
		List<Integer> li = new ArrayList<Integer>();
		Producer p = new Producer(li);
		Consumer c = new Consumer(li);
		Thread producer[]= new Thread[10];
		Thread consumer[]= new Thread[10];
		for(int i=0;i<10;i++) {
			producer[i] = new Thread(p, "Producer"+(i+1));
			consumer[i] = new Thread(c, "Consumer"+(i+1));
			producer[i].start();
			consumer[i].start();
		}
	}
}

class Producer implements Runnable {
	private List<Integer> arr;
	private int i = 0;
	private int CAPACITY = 7;

	Producer(List<Integer> li) {
		arr = li;
	}

	void producer() throws Exception {
		synchronized (arr) {
			while (arr.size() >= CAPACITY) {
				System.out.println(
						"Producer::" + Thread.currentThread().getName() + " .List is full, size:" + arr.size());
				arr.wait();
			}
			Thread.sleep(250);
			System.out.println(Thread.currentThread().getName()+" : "+i);
			arr.add(i++);
			arr.notify();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (i < 500)
			try {
				producer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

class Consumer implements Runnable {
	private List<Integer> arr;

	Consumer(List<Integer> li) {
		arr = li;
	}

	void consume() throws InterruptedException {
		synchronized (arr) {
			while (arr.isEmpty()) {
				System.out.println("Consumer::" + Thread.currentThread().getName() + " ,size:" + arr.size());
				arr.wait();
			}
			Thread.sleep(250);
			int rem = arr.remove(0);
			System.out.println(Thread.currentThread().getName() + "::" + rem);
			arr.notify();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true)
			try {
				consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

}
