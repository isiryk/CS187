package stack;

/**
 * A {@link LinkedStack} is a stack that is implemented using a Linked List structure
 * to allow for unbounded size.
 *
 * @param <T> the elements stored in the stack
 */
public class LinkedStack<T> implements StackInterface<T> {
	LLNode<T> head;
	int size = 0;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T pop() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(!isEmpty()){
			T data = head.getData();
			head = head.getNext();
			size--;
			return data;
		}
		throw new StackUnderflowException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(!isEmpty()){
			return head.getData();
		}
		throw new StackUnderflowException();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size == 0){
			return true;
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub		
		return size;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void push(T elem) {
		// TODO Auto-generated method stub
		LLNode<T> temp = head;
		LLNode<T> temp2 = new LLNode(elem);
	    temp2.setNext(temp);
	    head = temp2;	
	    size++;
	}

}
