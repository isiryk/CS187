package structures;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> implements
		BSTInterface<T> {
	protected BSTNode<T> root;

	public boolean isEmpty() {
		return root == null;
	}

	public int size() {
		return subtreeSize(root);
	}

	protected int subtreeSize(BSTNode<T> node) {
		if (node == null) {
			return 0;
		} else {
			return 1 + subtreeSize(node.getLeft())
					+ subtreeSize(node.getRight());
		}
	}

	public boolean contains(T t) {
		// TODO
		if(t == null){
			throw new NullPointerException();
		}
		if(get(t) == null){
			return false;
		}
		return true;
	}

	public boolean remove(T t) {
		if(t == null){
			throw new NullPointerException();
		}
		boolean result = contains(t);
		if (result) {
			root = removeFromSubtree(root, t);
		}
		return result;
	}

	protected BSTNode<T> removeFromSubtree(BSTNode<T> node, T t) {
		// node must not be null
		int result = t.compareTo(node.getData());
		if (result < 0) {
			node.setLeft(removeFromSubtree(node.getLeft(), t));
			return node;
		} else if (result > 0) {
			node.setRight(removeFromSubtree(node.getRight(), t));
			return node;
		} else { // result == 0
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else { // neither child is null
				T predecessorValue = getHighestValue(node.getLeft());
				node.setLeft(removeRightmost(node.getLeft()));
				node.setData(predecessorValue);
				return node;
			}
		}
	}

	private T getHighestValue(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getData();
		} else {
			return getHighestValue(node.getRight());
		}
	}

	private BSTNode<T> removeRightmost(BSTNode<T> node) {
		// node must not be null
		if (node.getRight() == null) {
			return node.getLeft();
		} else {
			node.setRight(removeRightmost(node.getRight()));
			return node;
		}
	}

	public T getFromTree(T t, BSTNode<T> node){
		if(node == null){
			return null;
		}
		if(t.compareTo(node.getData()) < 0){
			return getFromTree(t, node.getLeft());
		}
		if(t.compareTo(node.getData()) == 0){
			return node.getData();
		}
		return getFromTree(t, node.getRight());
	}
	
	
	public BSTNode<T> getNodeFromTree(T t, BSTNode<T> node){
		if(node == null){
			return null;
		}
		if(t.compareTo(node.getData()) < 0){
			return getNodeFromTree(t, node.getLeft());
		}
		if(t.compareTo(node.getData()) == 0){
			return node;
		}
		return getNodeFromTree(t, node.getRight());
	}
	
	public T get(T t) {
		// TODO
		if(t == null){
			throw new NullPointerException();
		}
		return getFromTree(t, root);
	}

	public void add(T t) {
		if(t == null){
			throw new NullPointerException();
		}
		root = addToSubtree(t, root);
	}

	protected BSTNode<T> addToSubtree(T t, BSTNode<T> node) {
		if (node == null) {
			return new BSTNode<T>(t, null, null);
		}
		if (t.compareTo(node.getData()) <= 0) {
			node.setLeft(addToSubtree(t, node.getLeft()));
			node.getLeft().setParent(node);
		} else {
			node.setRight(addToSubtree(t, node.getRight()));
			node.getRight().setParent(node);
		}
		return node;
	}

	@Override
	public T getMinimum() {
		// TODO
		if(size() == 0){
			return null;
		}
		BSTNode<T> copy = root;
		BSTNode<T> prev = root;
		while(copy != null){
			prev = copy;
			copy = copy.getLeft();
		}
		return prev.getData();
	}

	@Override
	public T getMaximum() {
		// TODO
		if(size() == 0){
			return null;
		}
		BSTNode<T> copy = root;
		BSTNode<T> prev = root;
		while(copy != null){
			prev = copy;
			copy = copy.getRight();
		}
		return prev.getData();
	}

	public int heightHelper(BSTNode<T> node, int counter) {
		if (node == null) {
			return 0;
		}
	    if(node.getLeft() == null && node.getRight() == null){
	    	return counter;
	    }
	    else {
			int highest = Math.max(heightHelper(node.getLeft(), counter + 1), heightHelper(node.getRight(), counter + 1));
			return highest;
		}
	}
	
	@Override
	public int height() {
		// TODO
		if(root == null){
			return -1;
		}
		BSTNode<T> node = root;
		return heightHelper(node, 0);
	}

	@Override
	public Iterator<T> preorderIterator() {
		// TODO
		Queue<T> queue = new LinkedList<T>();
		preorderTraverse(queue, root);
		return queue.iterator();
	}
	
	private void preorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			queue.add(node.getData());
			preorderTraverse(queue, node.getLeft());
			preorderTraverse(queue, node.getRight());
		}
	}

	@Override
	public Iterator<T> inorderIterator() {
		Queue<T> queue = new LinkedList<T>();
		inorderTraverse(queue, root);
		return queue.iterator();
	}
	
	private void inorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			inorderTraverse(queue, node.getLeft());
			queue.add(node.getData());
			inorderTraverse(queue, node.getRight());
		}
	}

	@Override
	public Iterator<T> postorderIterator() {
		// TODO
		Queue<T> queue = new LinkedList<T>();
		postorderTraverse(queue, root);
		return queue.iterator();
	}
	
	private void postorderTraverse(Queue<T> queue, BSTNode<T> node) {
		if (node != null) {
			postorderTraverse(queue, node.getLeft());
			postorderTraverse(queue, node.getRight());
			queue.add(node.getData());
		}
	}
	
	public boolean equalsHelper(BSTNode<T> original,BSTNode<T> compare){
		if(original == null && compare == null){
			return true;
		}
		if(original == null || compare == null){
			return false;
		}
		if(!original.equals(compare)){
			return false;
		}
		if(!equalsHelper(original.getLeft(), compare.getLeft())){
			return false;
		}
		if(!equalsHelper(original.getRight(), compare.getRight())){
			return false;
		}
		return true;
		
	}
	
	@Override
	public boolean equals(BSTInterface<T> other) {
		// TODO
		if(other == null){
			throw new NullPointerException();
		}
		BSTNode<T> original = this.getRoot();
		BSTNode<T> compare = other.getRoot();
		return equalsHelper(original, compare);
	}

	@Override
	public boolean sameValues(BSTInterface<T> other) {
		// TODO
		if(other == null){
			throw new NullPointerException();
		}
		Iterator<T> treeIterator = this.preorderIterator();
		while (treeIterator.hasNext()) {	
			T data = treeIterator.next();
			if(!other.contains(data)){
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isBalanced() {
		// TODO
		if(size() == 0){
			return true;
		}
		if(Math.pow(2, height()) <= size() && size() < Math.pow(2, height() + 1)){
			return true;
		}
		return false;
	}
	
	 public void InsertTree(T[] treeInfo, int low, int high){
         if(low == high){
        	  add(treeInfo[low]);
         }
         else if((low + 1) == high){
	          add(treeInfo[low]);
	          add(treeInfo[high]);
         }
         else{
	         int mid = (low + high)/2;
	         add(treeInfo[mid]);
	         InsertTree(treeInfo, low,  mid - 1);
	         InsertTree(treeInfo, mid + 1, high);
         }
        }
        
	 	@Override
    public void balance() {
                // TODO
	   if(isEmpty()){
		   return;
	   }
       Iterator<T> treeIterator = this.inorderIterator();
       int index = 0;
       T[] treeInfo = (T[]) new Comparable[size()];
       while(treeIterator.hasNext()){
    	  T data = treeIterator.next();
      	  treeInfo[index] = data;
      	  index++;
      	  remove(data);	  
       }
       InsertTree(treeInfo, 0, index - 1);      
    }

	@Override
	public BSTNode<T> getRoot() {
		// DO NOT MODIFY
		return root;
	}

	public static <T extends Comparable<T>> String toDotFormat(BSTNode<T> root) {
		// DO NOT MODIFY
		// see project description for explanation

		// header
		int count = 0;
		String dot = "digraph G { \n";
		dot += "graph [ordering=\"out\"]; \n";
		// iterative traversal
		Queue<BSTNode<T>> queue = new LinkedList<BSTNode<T>>();
		queue.add(root);
		BSTNode<T> cursor;
		while (!queue.isEmpty()) {
			cursor = queue.remove();
			if (cursor.getLeft() != null) {
				// add edge from cursor to left child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getLeft().getData().toString() + ";\n";
				queue.add(cursor.getLeft());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}
			if (cursor.getRight() != null) {
				// add edge from cursor to right child
				dot += cursor.getData().toString() + " -> "
						+ cursor.getRight().getData().toString() + ";\n";
				queue.add(cursor.getRight());
			} else {
				// add dummy node
				dot += "node" + count + " [shape=point];\n";
				dot += cursor.getData().toString() + " -> " + "node" + count
						+ ";\n";
				count++;
			}

		}
		dot += "};";
		return dot;
	}
}