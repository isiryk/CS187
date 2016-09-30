package sorters;

import java.util.Comparator;

import structures.SwapList;

public class HeapSorter<T> extends AbstractSorter<T> {

	public HeapSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO
		int index = list.size();
		for(int j = index / 2 - 1; j >= 0; j--){
			bubbleDown(j, index);
		}
		for(int j = index - 1; j > 0; j--){
			list.swap(0, j);
			bubbleDown(0, j);
		}
		return list;
	}
	
	public void bubbleDown(int start, int portionSize){
		int leftChild = 2*start + 1;
		int rightChild = 2*start + 2;
		if(leftChild >= portionSize){
			return;
		}
		int big = leftChild;
		if(rightChild < portionSize && list.compare(rightChild, leftChild, comparator) > 0){
			big = rightChild;
		}
		if(list.compare(start, big, comparator) < 0){
			list.swap(big, start);
			bubbleDown(big, portionSize);
		}
	}
}
