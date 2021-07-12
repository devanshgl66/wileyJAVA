package MiniBank;
public class BaseUsage extends Accounts{
	BaseUsage(String name,float balance,int type){
		super(name,balance,type);
	}
	public void credit(float amount) {
		float bal=getBalance();
		bal+=amount;
		setBalance(bal);
	}
	public void debit(float amount) {
		float bal=getBalance();
		bal-=amount;
		if(bal>=0)
			setBalance(bal);
		else
			System.out.println("Insufficient balance.Try again");
	}
}
