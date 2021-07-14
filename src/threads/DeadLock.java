package threads;

public class DeadLock {
	public static void main(String[] args) {
		A a = new A();
		A b = new A();
		Runnable r1 = () -> {
			synchronized (a) {
				System.out.println("R1 => a");
				synchronized (b) {
					System.out.println("R2 => b");
				}
			}
		};
		Runnable r2 = () -> {
			synchronized (b) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("R1 => b");
				synchronized (a) {
					System.out.println("R2 => a");
				}
			}
		};
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t2.start();
		t1.start();

	}
}

class A {
	int i = 10;
}
