package dataStructure;

class Node<T>{
	T data;
	Node<T> next;
	Node(T data,Node<T>link){
		this.data=data;
		this.next=link;
	}
}
class linkedlist{
	Node<Integer> head=null;
	void insertInBeg(int data) {
		if(head==null)
			head=new Node<Integer>(data,null);
		else {
			Node<Integer>newHead=new Node<Integer>(data,head);
			head=newHead;
		}
	}
	int removeFromHead() {
		if(head==null) {
			System.out.println("List already empty");
			return -1;
		}
		int d=head.data;
		head=head.next;
		return d;		
	}
	void traverse() {
		Node<Integer>temp=head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
}
public class linkedListBasic {
	public static void main(String[] args) {
//		ll<Integer>head=new ll<Integer>(0,null);
		linkedlist li=new linkedlist();
		li.insertInBeg( 5);
		li.insertInBeg(6);
		li.insertInBeg( 7);
		System.out.println("First traversal");
		li.traverse();
		li.removeFromHead();
		System.out.println("Traverse after removal of element from head");
		li.traverse();
	}
}
