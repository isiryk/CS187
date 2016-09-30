package structures;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class NodeIterator<T> implements Iterator<T> {
	
	private Node<T> head;
	
	public NodeIterator(Node<T> head){	
		this.head = head;
	}
	
	public boolean hasNext(){
		if(head != null){
			return true;
		}
		return false;		
	}
	
	public T next(){
		Node<T> temp = head;
		if(head != null){
			head = head.getNext();
			return temp.getData();
		}
		throw new NoSuchElementException();
	}
	
	public void remove(){
		throw new UnsupportedOperationException();
	}
}
