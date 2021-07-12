package threads;
import java.util.*;
public class FibonaciiAndThreads {
	static int n;
	static ArrayList<Integer>fib=new ArrayList<Integer>();
	static class Creator extends Thread{
		@Override
		public void run() {
			int cnt=1;
			while(fib.size()-1<n) {
				fib.add(fib.get(fib.size()-1)+fib.get(fib.size()-2));
			}
		}
	}
	static class Adder extends Thread{
		private int cnt=0;
		private int sum=0;
		@Override
		public void run() {
			while(cnt!=n) {
				if(cnt<fib.size()-1) {
					System.out.println(sum+" + "+fib.get(cnt)+" = "+(sum+fib.get(cnt)));
					sum+=fib.get(cnt);
					cnt++;
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
		n=10;
		//added the first two element
		fib.add(0);
		fib.add(1);
		Adder a=new Adder();
		Creator c=new Creator();
		a.start();
		c.start();
		c.join();
		System.out.println("Fibonacii Series: ");
		System.out.println(fib);
	}
}
