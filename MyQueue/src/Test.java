import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test {
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
