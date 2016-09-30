package structures;

/**
 * A node in a BST.
 * 
 * Note that BSTNode MUST implement BSTNodeInterface; removing this will result
 * in your program failing to compile for the autograder.
 * 
 * You may need to modify this file when implementing ScapegoatTree.
 * 
 * @author liberato
 *
 * @param <T>
 */
public class BSTNode<T extends Comparable<T>> implements BSTNodeInterface<T> {
	private T data;
	private BSTNode<T> left;
	private BSTNode<T> right;
	private BSTNode<T> parent;

	public BSTNode(T data, BSTNode<T> left, BSTNode<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public BSTNode(T data, BSTNode<T> left, BSTNode<T> right, BSTNode<T> parent) {
		this.data = data;
		this.left = left;
		this.right = right;
		this.parent = parent;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public BSTNode<T> getLeft() {
		return left;
	}

	public void setLeft(BSTNode<T> left) {
		//left.setParent(this);
		this.left = left;
	}

	public BSTNode<T> getRight() {
		return right;
	}
    
	public boolean equals(BSTNode<T> obj){
		if(obj == null){
			throw new NullPointerException();
		}
		if(getData().equals(obj.getData())){
			return true;
		}
		return false;
	}
	
	public void setRight(BSTNode<T> right) {
		//right.setParent(this);
		this.right = right;
	}
	
	public void setParent(BSTNode<T> parent) {
		this.parent = parent;
		//parent.getLeft().setLeft(parent.getLeft());
		//parent.getRight().setLeft(parent.getLeft());
	}
	
	public BSTNode<T> getParent() {
		return parent;
	}
}