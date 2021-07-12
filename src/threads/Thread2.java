package threads;

import java.util.*;

public class Thread2 {
	public static void main(String[] args) throws Exception {

		EmpService empService = new EmpService();

		Thread empThread1 = new Thread(empService);

		Thread empThread2 = new Thread(empService);

		// start the thread
		empThread1.start();
		empThread2.start();

		// obj1 -> t1
		// list
		// obj2 -> t3
		// list
		// obj3 -> t2
		// list
		empThread1.join();
		empThread1.join();
		empService.getIntegers().forEach(in -> System.out.println("INT " + in));
	}
}

class EmpService implements Runnable {

	private List<Integer> integers = Collections.emptyList();

	@Override
	public void run() {
		integers = new ArrayList<>();

		for (int i = 10; i > 0; i--) {
			synchronized (integers)
			{
				if(integers.indexOf(i)==-1)
				integers.add(i);
			}
//			try {
//				Thread.sleep(000);
//			} catch (InterruptedException inEx) {
//				System.err.println(inEx);
//			}

			System.out.println(Thread.currentThread().getName() + " ---- " + i);
		}
	}

	public List<Integer> getIntegers() {
		return integers;
	}
}