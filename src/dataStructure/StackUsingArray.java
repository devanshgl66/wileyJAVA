package dataStructure;

public class StackUsingArray {
	private static int stack[]=new int[10];
	private static int top=-1;
	public static void push(int val) {
		if(top==stack.length-1) {
			System.out.println("Stack is full");
			return ;
		}
		stack[++top]=val;
	}
	public static int pop() {
		if(top==-1) {
			System.out.println("Stack is empty");
			return -1;
		}
		return stack[top--];
	}
	public static int peek() {
		if(top==-1) {
			System.out.println("Stack is empty");
		}
		return stack[top];
	}
	public static void main(String[] args) {
		stack=new int[10];
		pop();
		push(2);
		push(5);
		push(7);
		push(8);
		System.out.println(peek());
		pop();
		System.out.println(peek());
	}
}
