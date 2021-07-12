package MiniBank;

import java.util.ArrayList;

public class UserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		BaseUsage obj=new BaseUsage("Devansh",500,0);
//		obj.display();
//		obj.credit(500);
//		obj.display();
//		obj.debit(600);
//		obj.display();
//		obj.debit(600);
//		obj.display();
//		ArrayList<BaseUsage>arr=new ArrayList<BaseUsage>();
//		arr.add(new BaseUsage("User1",25000,0));
//		arr.add(new BaseUsage("User2",30000,0));
//		arr.add(new BaseUsage("User3",20000,0));
//		arr.add(new BaseUsage("User4",15000,0));
//		arr.stream().filter((BaseUsage ac)->ac.getBalance()>=25000)
//		.forEach(ac->ac.display());
		ArrayList<String> str = new ArrayList<String>();
		str.add("asdf");
		str.add("qwe");
		str.add("dev");
		str.stream().sorted(String::compareTo).forEach(s -> System.out.println(s));
		str.stream().filter(s->s.startsWith("q"))
		.forEach(s->System.out.println(s));
	}

}
