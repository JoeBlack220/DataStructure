import java.util.*;
import java.io.*;
public class Queue<AnyType> {
	private int maxSize;
	private Object[] data = null;
	private int front;
	private int rear;
	private int currentSize = 0;
	
	public Queue(){
		this(10);
	}
	
	public Queue(int initialSize){
		if(initialSize > 0){
			this.maxSize = initialSize;
			data = new Object[initialSize];
			front = rear = 0;
		}
		else{
			throw new RuntimeException("The initial size must be bigger than zero. "+ initialSize);
		}
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public boolean enque(AnyType x){
		if(currentSize == maxSize){
			throw new RuntimeException("The queue is full and the new element cannot be added to the queue!");
		}
		else{
			data[rear] = x;
			rear = ( rear + 1 )% maxSize;
			currentSize ++;
			return true;
		}
	}
	public AnyType peek(){
		if(isEmpty()){
			throw new RuntimeException("The queue is empty!");
		}
		else{
			return(AnyType) data[front];
		}
	}
	public AnyType dequeue(){
		if(isEmpty()){
			throw new RuntimeException("The queue is empty!");
		}
		else{
			AnyType value = (AnyType) data[front];
			data[front] = null;
			front = ( front + 1 )% maxSize; 
			currentSize --;
			return value;
		}
	}
	public int length(){
		return currentSize;
	}
	
	public void clear(){
		currentSize = 0;
		front = 0;
		rear = 0;
	}
	public static void main( String[] args ) throws IOException{
		try(Scanner in = new Scanner(new FileInputStream("C://Users//Joe//Desktop//Test//test3.dat"),"UTF-8")){
			int n = in.nextInt();
			Queue myQueue = new Queue<Integer>(15);
			for(int i = 0; i < n; i++){
				myQueue.enque(in.nextInt());
			}
			System.out.println(myQueue.peek());
			myQueue.dequeue();
			System.out.println(myQueue.peek());
			myQueue.dequeue();
			System.out.println(myQueue.peek());
			myQueue.dequeue();
			System.out.println(myQueue.peek());
		}
	}
	
}
