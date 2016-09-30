package sorters;

import java.util.Comparator;

import structures.SwapList;

public class QuickSorter<T> extends AbstractSorter<T> {

	public QuickSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		// TODO
		
		/*
		 * Note: When choosing a pivot, choose the element in the middle of
		 * the sub-array. That is,
		 * 
		 * pivotIndex = (firstIndex + lastIndex) / 2;
		 */
		int firstIndex = list.size() - list.size();
		int lastIndex = list.size() - 1;
		int pivotIndex = (firstIndex + lastIndex)/2;
		sorter(pivotIndex, firstIndex, lastIndex);
		return list;
	}
	
	private void sorter(int pivotIndex, int firstIndex, int lastIndex) {
		if(firstIndex >= lastIndex){
			return;
		}
		int index = firstIndex;
		list.swap(pivotIndex, lastIndex);
		for(int j = index; j < lastIndex; j++){
			if(list.compare(j, lastIndex ,comparator) <= 0){
				list.swap(index, j);
				index++;
			}
		}
		list.swap(lastIndex, index);
		pivotIndex = index;
		sorter((firstIndex + pivotIndex - 1)/ 2, firstIndex, pivotIndex - 1);
		sorter((lastIndex + pivotIndex + 1)/ 2, pivotIndex + 1, lastIndex);
	}
}