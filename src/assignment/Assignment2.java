package assignment;

import java.util.*;

class Account {
	String name;
	int id;
	int balance;
	private static int numUser = 0;

	Account(String name, int balance) {
		this.name = name;
		this.balance = balance;
		this.id = ++numUser;
	}

	@Override
	public String toString() {
		return "Id: " + id + " Name: " + name + " Balance: " + balance;
	}
}

class Bank {
	Map<Integer, Integer> notes;
	float loadBalancer = 0.5f;

	Bank(Map<Integer, Integer> notes) {
		this.notes = notes;
	}

	void withdraw(Account ac, int amount) {
		if (amount > ac.balance) {
			System.out.println("Insufficient balance.");
			return;
		}
		int temp = amount;
		boolean b = false;
		float tempLoadBalancer=loadBalancer;
		Map<Integer, Integer> m = new TreeMap<>(notes);

		while (!b) {
			b = true;
			for (int note : notes.keySet()) {
				int cnt = notes.get(note);
				int req = amount / note;
				if (req <= cnt * loadBalancer) {
					if (note * req != 0)
						b = false;
					amount -= note * req;
					notes.put(note, cnt - req);
				} else {
					if ((int) (cnt * loadBalancer) * note != 0)
						b = false;
					amount -= (int) (cnt * loadBalancer) * note;
					notes.put(note, cnt - (int) (cnt * loadBalancer));
				}
			}
			loadBalancer=1;
		}
		if (amount != 0) {
			System.out.println("Error: "+amount);
			System.out.println("Amount can't be provided");
			notes.putAll(m);
		} else
			ac.balance -= temp;
		loadBalancer=tempLoadBalancer;
	}
}

public class Assignment2 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Map<Integer, Integer> notes = new TreeMap<Integer, Integer>((n1, n2) -> {
			return n2 - n1;
		});
		Bank b = new Bank(notes);
		int numAccount = 5;
		ArrayList<Account> ac = new ArrayList();
//		Account ac[]=new Account[numAccount];
		Random rand = new Random();
		for (int i = 0; i < numAccount; i++) {
			ac.add(new Account("User" + (i + 1), rand.nextInt(500) + 50));
		}
		notes.put(50, 5);
		notes.put(20, 5);
		notes.put(10, 5);
		notes.put(5, 5);
		ac.forEach(a -> System.out.println(a));
//		ac.forEach(a->System.out.println);
//		System.out.println(ac);
		System.out.println(notes);
		char c = 'Y';
		while (c == 'Y') {
			System.out.println("Enter Account ID:");
			int id = sc.nextInt();
			System.out.println("Enter Amount: ");
			int am = sc.nextInt();
			ac.stream().filter(a -> a.id == id).forEach(a -> b.withdraw(a, am));
			ac.forEach(a -> System.out.println(a));
			System.out.println(notes);
			System.out.println("Press Y to continue");
			c=sc.next().charAt(0);
		}
	}
}
