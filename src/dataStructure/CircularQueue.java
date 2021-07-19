package dataStructure;
class CircularQueueUsingArray{
	private int cqueue[];
	private int rear=-1,front=-1;
	public CircularQueueUsingArray(int size) {
		cqueue=new int[size];
		rear=-1;
		front=-1;
	}
	public void enque(int data) {
		System.out.println("Enque operation performed");
		//add data to rear
		if(rear==-1) {
			rear=0;
			front=0;
			cqueue[front]=data;
		}
		else if(rear<front) {
			if(front-rear==1)
				System.out.println("Queue is full");
			else {
				cqueue[++rear]=data;
			}
		}
		else if(rear<cqueue.length-1)
			cqueue[++rear]=data;
		else if(rear==cqueue.length-1) {
			if(front==0)
				System.out.println("Queue is full");
			else {
				rear=0;
				cqueue[rear]=data;
			}
		}
	}
	public int dequeue() {
		System.out.println("Deque operation performed");
		//remove element from front
		if(front==-1) {
			System.out.println("Empty queue");
			return -1;
		}
		if(front==rear) {
			int x=cqueue[front];
			front=-1;
			rear=-1;
			return x;
		}
		if(front<rear) {
			if(rear-front==0) {
				int x=cqueue[front];
				front=-1;
				rear=-1;
				return x;
			}
			else
				return cqueue[front++];
		}
		if(front==cqueue.length-1) {
			if(rear==0) {
				int x=cqueue[front];
				front=0;
				return x;
			}
			else {
				int x=cqueue[front];
				front=0;
				return x;
			}
		}
//		if(front>rear) {
			return cqueue[front++];
//		}
	}
	public void traverse() {
	    if(front == -1)
	    {
	        System.out.print("Queue is Empty");
	        return;
	    }
	    System.out.print("Elements in the circular queue are: ");
	    if(rear >= front)
	    {   for(int i = front; i <= rear; i++)	        
	            System.out.print(cqueue[i]+" ");	        
	        System.out.println();
	    }
	    else
	    {
	        for(int i = front; i < cqueue.length; i++)   
	            System.out.print(cqueue[i]+" ");	 
	        for(int i = 0; i <= rear; i++)        
	            System.out.print(cqueue[i]+" ");	        
	        System.out.println();
	    }
	}
}
public class CircularQueue<T> {
	public static void main(String[] args) {
		CircularQueueUsingArray cq=new CircularQueueUsingArray(5);
		cq.enque(1);
		cq.enque(2);
		cq.enque(3);
		cq.enque(4);
		cq.enque(5);
		cq.enque(6);
		cq.traverse();
		cq.dequeue();
		cq.enque(6);
		cq.traverse();
		cq.dequeue();
		cq.traverse();
		cq.dequeue();
		cq.traverse();
//		cq.dequeue();
//		cq.traverse();
//		cq.dequeue();
//		cq.traverse();
//		cq.dequeue();
//		cq.traverse();
//		cq.traverse();
		cq.enque(7);
		cq.traverse();
		cq.dequeue();
		cq.traverse();
		cq.enque(8);
		cq.traverse();
		cq.dequeue();
		cq.traverse();
		cq.dequeue();
		cq.traverse();
		cq.dequeue();
		cq.traverse();
		cq.dequeue();
		cq.traverse();
	}
}
