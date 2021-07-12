package MiniBank;

public class Accounts implements Bank {
	public String name;
	private float balance;
	public int type;
	private static int count = 0;
	public int accountNo;

	public float getBalance() {
		return balance;
	}

	// Need to change it
	public void setBalance(float balance) {
		this.balance = balance;
	}

	public void display() {
		System.out.println("Basic Account Details:");
		System.out.println("Account Number: " + accountNo);
		System.out.println("Name: " + name);
		System.out.println("Balance: " + balance);
		showType();
		displayBankDetails();
	}

	private void showType() {
		System.out.print("Account Type: ");
		switch (type) {
		case 0:
			System.out.println("Saving Account");
			break;
		case 1:
			System.out.println("Current Account");
		}

	}

	// constructors
	Accounts(String name, float balance, int type) {
		this.name = name;
		this.balance = balance;
		this.type = type;
		count++;
		accountNo = count;
	}
}
