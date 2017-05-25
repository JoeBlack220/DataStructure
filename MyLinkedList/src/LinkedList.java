import java.util.*;
import java.io.*;
public class LinkedList<AnyType> implements Iterable < AnyType > {
	private static class Node <AnyType>{
		public Node (AnyType d, Node<AnyType> p, Node<AnyType> n){
			data = d; prev = p; next = n;
		}
		public AnyType data;
		public Node<AnyType> prev;
		public Node<AnyType> next;
	}
	private static final String AnyType = null;
	public LinkedList()
	{
		clear();
	}
	public void clear(){
		beginMarker = new Node(null , null , null);
		endMarker = new Node(null, beginMarker, null);
		beginMarker.next = endMarker;
		theSize = 0;
		modCount ++ ;
	
	}
	public int size(){
		return theSize;
	}
	public boolean isEmpty(){
		return size() == 0;	
	}
	
	public boolean add( AnyType x ){
		add( size(), x); return true;
	}
	public void add( int idx, AnyType x){
		addBefore(getNode(idx), x);
	}
	public AnyType get( int idx ){
		return getNode( idx ).data;
	}
	public AnyType set(int idx, AnyType newVal){
		Node<AnyType> p = getNode( idx );
		AnyType oldVal = p.data;
		p.data = newVal;
		return oldVal;
	}
	public AnyType remove( int idx ){
		return remove(getNode( idx ));
	}
	private void addBefore(Node<AnyType> p, AnyType x){
		Node <AnyType> newNode = new Node <AnyType>(x, p.prev, p);
		newNode.prev.next = newNode ;
		p.prev = newNode;
		theSize ++;
		modCount ++;
	}
	private AnyType remove( Node<AnyType> p){
		p.prev.next = p.next;
		theSize --;
		modCount ++;
		return p.data;
	}
	private Node<AnyType> getNode(int idx){
		Node <AnyType> p;
		if(idx < 0 || idx>size()){
			throw new IndexOutOfBoundsException();
		}
		if(idx > size()/2){
			p = beginMarker.next;
			for(int i = 0; i < idx; i ++){
				p = p.next;
			}
		}
		else{
			p = endMarker;
			for(int i = size(); i > idx; i--){
				p = p.prev;
			}
		}
		return p;
	}
	
	public java.util.Iterator<AnyType> iterator(){
		return new LinkedListIterator();
	}
	private class LinkedListIterator implements java.util.Iterator<AnyType>{
		private Node<AnyType> current = beginMarker.next;
		private int expectedModCount = modCount;
		private boolean okToRemove = false;
		public boolean hasNext(){
			return current != endMarker;
		}
		public AnyType next(){
			if(modCount != expectedModCount){
				throw new java.util.ConcurrentModificationException();
			}
			if(!hasNext()){
				throw new java.util.NoSuchElementException();
			}
			AnyType nextItem = current.data;
			current = current.next;
			okToRemove = true;
			return nextItem;
		}
		public void remove(){
			if(modCount != expectedModCount){
				throw new java.util.ConcurrentModificationException();
			}
			if(!okToRemove){
				throw new IllegalStateException();
			}
			LinkedList.this.remove(current.prev);
			okToRemove = false;
			expectedModCount ++;
		}
	}
	private int theSize;
	private int modCount = 0;
	private Node<AnyType> beginMarker;
	private Node<AnyType> endMarker;
	
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
