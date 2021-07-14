package threads;

import java.util.*;

public class FibonaciiAndSync {
	public static void main(String[] args) {
		List<Integer> fib = new ArrayList<Integer>();
		fib.add(0);
		fib.add(1);
		FibCreater fcre = new FibCreater(fib);
		FibConsumer fcon = new FibConsumer(fib);
		Thread t1 = new Thread(fcre);
		Thread t2 = new Thread(fcon);
		t1.start();
		t2.start();
	}
}

class FibCreater implements Runnable {
	private List<Integer> fib;

	public FibCreater(List<Integer> fib) {
		// TODO Auto-generated constructor stub
		this.fib = fib;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (fib.size() < 50) {
			create();
		}
	}

	void create() {
		synchronized (fib) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			;

			fib.add(fib.get(fib.size() - 1) + fib.get(fib.size() - 2));
			System.out.println("Element Created: " + fib.get(fib.size() - 1));
		}
	}
}

class FibConsumer implements Runnable {
	private List<Integer> fib;

	public FibConsumer(List<Integer> fib) {
		// TODO Auto-generated constructor stub
		this.fib = fib;
	}

	private int n = 45;
	int sum = 0;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (fib) {
			while (n > 0) {
				while (fib.size() <= 2) {
					System.out.println("Fib empty");
					try {
						fib.wait();
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println(sum + " + " + fib.get(0) + " = " + (sum + fib.get(0)) + " ,n=" + n);
				sum += fib.remove(0);
				n--;
			}
		}
	}
}