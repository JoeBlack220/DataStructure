import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) throws IOException{
		try(Scanner in = new Scanner(new FileInputStream("C://Users//Joe//Desktop//Test//test.dat"),"UTF-8")){
			int n = in.nextInt();
			LinkedList<Integer> myLinkedList = new LinkedList();
			for(int i = 0; i < n; i++){
				int m = in.nextInt();
				myLinkedList.add(m);
			}
		Iterator itr = myLinkedList.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next()+" ");
		}
		System.out.println();
		myLinkedList.remove(3);
		Iterator itr2 = myLinkedList.iterator();
		while(itr2.hasNext()){
			System.out.print(itr2.next()+" ");
		}
		}
	}

}
