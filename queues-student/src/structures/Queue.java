package structures;

import java.util.NoSuchElementException;

public class Queue<T> implements UnboundedQueueInterface<T> {
	
	private Node<T> head;
	private int size;
	
	public Queue() {
		// TODO 1
        head = null;	
        size = 0;
		
	}
	
	public Queue(Queue<T> other) {
		// TODO 2
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
		head = null;
		size = 0;
		for(int j = 0; j < other.size(); j++){
			T element = other.dequeue();
			other.enqueue(element);
			enqueue(element);
		}
	}
	
	@Override
	public boolean isEmpty() {
		// TODO 3
		if(size == 0){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO 4
		return size;
	}

	@Override
	public void enqueue(T element) {
		// TODO 5;
		if(head == null){
			head = new Node<T>(element,null);
			size++;
		}
		else{
			Node<T> add = new Node<T>(element,null);
			Node<T> temp = head;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(add);
			size++;
		}
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// TODO 6;
		if(!isEmpty()){
			T element = head.getData();
			head = head.getNext();	
			size--;
			return element;
		}
		throw new NoSuchElementException();
	}

	@Override
	public T peek() throws NoSuchElementException {
		// TODO 7
		if(!isEmpty()){
			return head.getData();
		}
		throw new NoSuchElementException();
	}

	@Override
	public UnboundedQueueInterface<T> reversed() {
		// TODO 8
		// Hint: Maybe save this one until after you finish enqueue()/dequeue()
		Queue<T> copy = new Queue<T>(this);
		Queue<T> reverse = new Queue<T>();
		LinkedStack<T> temp = new LinkedStack<T>();
		while(copy.isEmpty() != true){
			T element = copy.dequeue();
			temp.push(element);
		}
		while(temp.isEmpty() != true){
			T element = temp.pop();
			reverse.enqueue(element);
		}	
		return reverse;
	}
}
