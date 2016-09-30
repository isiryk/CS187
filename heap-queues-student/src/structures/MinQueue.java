package structures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import comparators.ReverseIntegerComparator;

public class MinQueue<V> implements PriorityQueue<Integer, V> {
	int size = 0;
	StudentArrayHeap<Integer,V> heap;
	ReverseIntegerComparator compare = new ReverseIntegerComparator();
	Iterator<Entry<Integer, V>> iterate; 
	
	public MinQueue(){
		heap = new StudentArrayHeap<Integer, V>(compare);
	}
	
	@Override
	public PriorityQueue<Integer, V> enqueue(Integer priority, V value) {
		// TODO Auto-generated method stub
		if(priority == null || value == null){
			throw new NullPointerException();
		}
		heap.add(priority, value);
		size++;
		return this;
	}

	@Override
	public V dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new IllegalStateException();
		}
		size--;
		V value = heap.remove();
		return value;
	}

	@Override
	public V peek() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			throw new IllegalStateException();
		}	
		return heap.peek();
	}

	@Override
	public Iterator<Entry<Integer, V>> iterator() {
		// TODO Auto-generated method stub
		List<Entry<Integer, V>> iterator = heap.asList();
		return iterator.iterator();
	}

	@Override
	public Comparator<Integer> getComparator() {
		// TODO Auto-generated method stub
		return compare;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size == 0){
			return true;
		}
		return false;
	}
}

