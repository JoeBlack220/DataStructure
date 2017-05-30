import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Test {
	public static void main( String[] args ) throws IOException{
		try(Scanner in = new Scanner(new FileInputStream("C://Users//Joe//Desktop//Test//test2.dat"),"UTF-8")){
			BinarySearchTree myTree = new BinarySearchTree<Integer>();
			int n = in.nextInt();
			for( int i = 0; i < n; i++){
				myTree.insert(in.nextInt());
			}
			System.out.println( myTree.findMax() );
			System.out.println( myTree.findMin() );
			myTree.printTree();
			myTree.remove( myTree.findMin() );
			myTree.remove( 44 );
			myTree.printTree();
		}
	}
}
