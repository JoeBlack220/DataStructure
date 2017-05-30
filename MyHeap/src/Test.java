import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test {
	public static void main( String[] args ) throws IOException{
		try(Scanner in = new Scanner(new FileInputStream("C://Users//Joe//Desktop//Test//test4.dat"),"UTF-8")){
			int n = in.nextInt();
			BinaryHeap myHeap = new BinaryHeap<Integer>();
			for(int i = 0; i < n; i++ ){
				myHeap.insert(in.nextInt());
			}
			for(int i = 1; i <= myHeap.currentSize; i++){
				System.out.println(myHeap.array[i]);
			}
			myHeap.deleteMin();
			myHeap.insert(66);
			System.out.println(myHeap.array[1]);
			
		}
	}
}
