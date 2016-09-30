package sorters;

import java.util.Comparator;

import structures.SwapList;

public class InsertionSorter<T> extends AbstractSorter<T> {

	public InsertionSorter(SwapList<T> list, Comparator<T> comparator) {
		super(list, comparator);
	}

	@Override
	public SwapList<T> sort() {
		for (int i = 1; i < list.size(); i++) {
			swappedSort(i);
		}
		return list;
	}

	public void swappedSort(int desiredIndex) {
		int i = desiredIndex - 1;
		while(i >= 0 && list.compare(i, desiredIndex, comparator) > 0){
			list.swap(i, desiredIndex);
			desiredIndex = i;
			i = i - 1;
		}
	}
}
