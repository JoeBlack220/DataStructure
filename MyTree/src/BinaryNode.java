
public class BinaryNode<AnyType> {
	BinaryNode(){
		this( null );
	}
	BinaryNode(AnyType theElement){
		this( theElement, null, null );
	}
	BinaryNode( AnyType theElement, BinaryNode<AnyType> left, BinaryNode<AnyType> right ){
		element = theElement; this.left = left; this.right = right;
	}
	
	AnyType element;
	BinaryNode<AnyType> left;
	BinaryNode<AnyType> right;
}
