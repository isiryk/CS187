package structures;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class RecursiveList<T> implements ListInterface<T> {
	
	private Node<T> head;
	private Node<T> tail;
	private int size = 0;
	
	public RecursiveList(){
		head = null;
		tail = null;
	}
	
	public int size(){
		return size;
	}
	
	public Iterator<T> iterator(){
		NodeIterator<T> iterator = new NodeIterator<T>(head);
		return iterator;
	}
	
	public ListInterface<T> insertFirst(T elem){
		if(elem == null){
			throw new NullPointerException();
		}
		Node<T> nodeInsert = new Node<T>(elem, null);
		if(head == null){
			head = nodeInsert;
			tail = nodeInsert;
			size++;
		}
		else{
			nodeInsert.setNext(head);
			head = nodeInsert;
			size++;
		}
		return this;
	}
	
	public ListInterface<T> insertLast(T elem){
		if(elem == null){
			throw new NullPointerException();
		}
		Node<T> nodeInsert = new Node<T>(elem, null);
		if(head == null){
			head = nodeInsert;
			tail = nodeInsert;
			size++;
			return this;
		}
		else{
			tail.setNext(nodeInsert);
			tail = nodeInsert;
			size++;
			return this;
		}
	}
	
	private Node<T> indexOf(Node<T> lookFor, int currentIndex, int index){
		if(currentIndex != index - 1){
			return indexOf(lookFor.getNext(), currentIndex + 1, index);
		}
		else{
			return lookFor;
		}
	}

	public ListInterface<T> insertAt(int index, T elem){
		if(elem == null){
			throw new NullPointerException();
		}
		if(index >= size() || index < 0){
			throw new IndexOutOfBoundsException();
		}
		Node<T> insert = new Node<T>(elem, null);
		Node<T> temp = head;
		if(index == 0){
			insert.setNext(temp);
			head.setNext(insert);
			size++;
		}
		else{
			Node<T> before = indexOf(temp, 0, index);
			Node<T> skip2 = before.getNext();
			before.setNext(insert);
			insert.setNext(skip2);
			size++;
		}
		return this;
	}
	//check this one
	public T removeFirst(){
		if(head == null){
			throw new IllegalStateException();
		}
		T elem = head.getData();
		head = head.getNext();
		size--;
		if(head == null){
			tail = null;
		}
		return elem;
	}
	//check this one.

	public T removeLast(){
		if(head == null){
			throw new IllegalStateException();
		}
		int index = size();
		Node<T> temp = head;
		Node<T> beforeNode = indexOf(temp, 1, index);
		T elem = beforeNode.getData();
		beforeNode.setNext(null);
		size--;
		return elem;
	}
	//check this one
	public T removeAt(int i){
		if(head == null){
			throw new IllegalStateException();
		}
		int index = i;
		Node<T> temp = head;
		if(index == 0){
			T elem = temp.getData();
			temp.setNext(temp.getNext());
			size--;
			return elem;
		}
		else{
			Node<T> beforeNode = indexOf(temp, 0, index);
			T elem = beforeNode.getNext().getData();
			beforeNode.setNext(beforeNode.getNext().getNext());
			size--;
			return elem;
		}
	}
	// check this one
	public T getFirst(){
		if(head == null){
			throw new IllegalStateException();
		}
		T elem = head.getData();
		return elem;
	}
	
	// check this one
	public T getLast(){
		if(head == null){
			throw new IllegalStateException();
		}
		int index = size();
		Node<T> temp = head;
		Node<T> beforeNode = indexOf(temp, 1, index);
		T elem = beforeNode.getData();
		return elem;
	}
	// check this one
	public T get(int i){
		if(head == null){
			throw new IllegalStateException();
		}
		if(i < 0 || i >= size()){
			throw new IndexOutOfBoundsException();
		}
		Node<T> temp = head;
		if(i == 0){
			T elem = temp.getData();
			return elem;
		}
		else{
			Node<T> beforeNode = indexOf(temp, 0, i);
			T elem = beforeNode.getNext().getData();
			return elem;
		}
	}
	
	private Node<T> removeElement(T lookFor, Node<T> currentNode, int index){
		if(lookFor != currentNode.getNext().getData()){
			return removeElement(lookFor, currentNode.getNext(), index + 1);
		}
		else{
			return currentNode;
		}
	}
	

	public boolean remove(T elem){
		if(elem == null){
			throw new NullPointerException();
		}
		Node<T> temp = head;
		Node<T> elementBefore = removeElement(elem, temp, 0);
		T element = elementBefore.getNext().getData();
		if(element == null){
			return false;
		}
		if(elementBefore.getNext().getNext() == null){
			elementBefore.setNext(null);
		}
		else{
			Node<T> skip = elementBefore;
			skip = skip.getNext().getNext();
			elementBefore.setNext(skip);
		}
		return true;
	}

	public int indexOf(T elem){
		int index = 1;
		if(elem == null){
			throw new NullPointerException();
		}
		Node<T> temp = head;
		removeElement(elem, temp, index);
		return index;
	}

	public boolean isEmpty(){
		if(size == 0){
			return true;
		}
		return false;
	}

}