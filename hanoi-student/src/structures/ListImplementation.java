package structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListImplementation<T> implements ListInterface<T> {
	
	private int size;
	private Node<T> head;
	private Node<T> pointer;
	
	public ListImplementation(){
		size = 0;
		head = null;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		return false;
	}
	
	public T get(int n) throws NoSuchElementException{
		if(n >= size || n < 0){
			throw new NoSuchElementException();
		}
		Node<T> temp = head;
		for(int j = 0; j < n; j++){
			temp = temp.getNext();
		}	
		return temp.getData();
	}
	
	public ListInterface<T> append(T elem){
		Node<T> temp = new Node<T>(elem, null);
		size++;
		if(elem == null){
			throw new NullPointerException();
		}
		if(head == null){
			head = temp;
			pointer = head;
			return this;
		}
		else{
			pointer.setNext(temp);
			pointer = pointer.getNext();
			return this;
		}
		
	}
	public Iterator<T> iterator(){
		NodeIterator<T> temp = new NodeIterator<T>(this.head);
		return temp;
	}

}
