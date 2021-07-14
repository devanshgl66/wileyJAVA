package threads;

import java.util.*;

public class ThreadsAndSync {
	public static void main(String[] args) throws Exception{
		List<Integer>li=new ArrayList<Integer>();
		Process p=new Process(li);
		Thread t1=new Thread(p,"Thread1");
		Thread t2=new Thread(p,"Thread2");
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(li);
	}
}

class Process implements Runnable {
	private volatile List<Integer> arr;

	Process(List<Integer> li) {
		arr = li;
	}
	volatile int i = 0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		synchronized (arr) 
		{
			while (i < 10) {
				System.out.println(Thread.currentThread().getName()+": "+i);
				arr.add(i++);
				try {
					arr.wait(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}