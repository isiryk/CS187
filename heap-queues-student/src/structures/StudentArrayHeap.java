package structures;

import java.util.Comparator;

public class StudentArrayHeap<P, V> extends AbstractArrayHeap<P, V> {
	
	
	protected StudentArrayHeap(Comparator<P> comparator) {
		super(comparator);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected int getLeftChildOf(int index) {
		// TODO Auto-generated method stub
		if(index < 0){
			throw new IndexOutOfBoundsException();
		}
		return (index * 2) + 1;
	}

	@Override
	protected int getRightChildOf(int index) {
		// TODO Auto-generated method stub
		if(index < 0){
			throw new IndexOutOfBoundsException();
		}
		return (index * 2) + 2;
	}

	@Override
	protected int getParentOf(int index) {
		// TODO Auto-generated method stub
		if(index < 1){
			throw new IndexOutOfBoundsException();
		}
		return (index - 1) / 2;
	}

	@Override
	protected void bubbleUp(int index) {
		// TODO Auto-generated method stub
		if((index) <= 0 ){
			return;
		}
		else if(comparator.compare(heap.get(index).getPriority() ,
								 heap.get(getParentOf(index)).getPriority()) > 0){
			
			swap(index, getParentOf(index));
			if(getParentOf(index) >= 0){
				bubbleUp(getParentOf(index));
			}
		}
		else{
			return;
		}
		
	}

	@Override
	protected void bubbleDown(int index) {
		// TODO Auto-generated method stub
		if(getLeftChildOf(index) >= size() || index < 0){
			return;
		}
		int left = getLeftChildOf(index);
		if(getRightChildOf(index) >= size()){
			if(comparator.compare(heap.get(left).getPriority(), 
					heap.get(index).getPriority()) > 0){
				swap(left, index);
				bubbleDown(left);
				return;
			}
		}
		else{
			int right = getRightChildOf(index);
			if(comparator.compare(heap.get(left).getPriority(), 
					heap.get(right).getPriority()) > 0){
				if(comparator.compare(heap.get(left).getPriority(), 
						heap.get(index).getPriority()) > 0){
					swap(left, index);
					bubbleDown(left);
				}
				
			}
			if(comparator.compare(heap.get(right).getPriority(), 
					heap.get(left).getPriority()) > 0){
				if(comparator.compare(heap.get(right).getPriority(), 
						heap.get(index).getPriority()) > 0){
					swap(right, index);
					bubbleDown(right);
				}
			}
		}
		
	}
}
