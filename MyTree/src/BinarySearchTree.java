import java.io.*;
import java.util.*;
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

	private BinaryNode<AnyType> root;
	
	public BinarySearchTree(){
		root = null;
	}
	
	public void makeEmpty(){
		root = null;
	}
	public boolean isEmpty(){
		return root == null;
	}
	public boolean cotains( AnyType x ){
		return contains( x, root );
	}
	public AnyType findMin(){
		if(isEmpty()){
			throw new RuntimeException("The tree is empty!");
		}
		return findMin( root ).element;
	}
	public AnyType findMax(){
		if(isEmpty()){
			throw new RuntimeException("The tree is empty!");
		}
		return findMax( root ).element;
	}
	public void insert( AnyType x ){
		root = insert( x, root );
	}
	public void remove( AnyType x ){
		root = remove( x, root );
	}
	public void printTree(){
		if( isEmpty() ){
			System.out.println("The tree is empty");
		}
		else{
			printTree(root);
		}
	}
	
	private boolean contains( AnyType x, BinaryNode<AnyType> theNode ){
		if(theNode == null){
			return false;
		}
		int compareResult = x.compareTo( theNode.element );
		if(compareResult < 0){
			return contains( x, theNode.left );
		}
		else  if(compareResult > 0){
			return contains( x, theNode.right );
		}
		else
			return true;
	}
	private BinaryNode<AnyType> findMin( BinaryNode<AnyType> theNode ){
		if(theNode == null){
			return null;
		}
		if( theNode.left == null ){
			return theNode;         
		}	else{
		return findMin( theNode.left );
		}
	}
	private BinaryNode<AnyType> findMax( BinaryNode<AnyType> theNode ){
		if(theNode == null){
			return null;
		}
		if( theNode.right == null ){
			return theNode;
		}	else{
		return findMax( theNode.right );
		}
	}
	private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> theNode ){
		if( theNode == null){
			return new BinaryNode<AnyType>( x, null, null );
		}
		int compareResult = x.compareTo(theNode.element );
		if(compareResult > 0){
			theNode.right = insert( x, theNode.right );
		}
		else if(compareResult < 0){
			theNode.left = insert( x, theNode.left );
		}
		return theNode;
	}
	private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> theNode ){
		if(theNode == null){
			return theNode;
		}
		
		int compareResult = x.compareTo(theNode.element);
		if(compareResult < 0){
			theNode.left = remove( x, theNode.left );
		}
		else if(compareResult > 0){
			theNode.right = remove( x, theNode.right );
		}
		else if( theNode.left != null && theNode.right != null){
			theNode.element = findMin( theNode.right ).element;
			theNode.right = remove ( theNode.element, theNode.right );
		}
		else{
			theNode = ( theNode.left != null )? theNode.left : theNode.right;
		}
		return theNode;
	}
	private void printTree( BinaryNode<AnyType> theNode ){
		if(theNode != null){
			printTree( theNode.left );
			System.out.println(theNode.element);
			printTree( theNode.right );
		}
	}
	
}
