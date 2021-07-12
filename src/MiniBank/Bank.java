package MiniBank;

public interface Bank {
	String bname="Bank name";
	String IFSCcode="IFSC code";
	default void displayBankDetails() {
		System.out.println("Bank Name: "+bname);
		System.out.println("IFSC code: "+IFSCcode);
	}
}
