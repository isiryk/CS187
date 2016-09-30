package stack;

public class ResizingArrayStack<T> implements Stack<T> {
    private T[] stack;
    private int size;
    private int sizeNow = -1;
    
    
    /**
     * Creates a new ResizingArrayStack.
     * @param initialCapacity the initial length of the backing array for the
     *        stack
     */
    public ResizingArrayStack(int initialCapacity) {
    	// TODO 1
    	size = initialCapacity;
    	stack = (T[]) new Object[size];  		
    }

    @Override
    public T pop() throws StackUnderflowException {
    	// TODO 2
    	if(!isEmpty()){
    		T temp = stack[sizeNow];
    		stack[sizeNow] = null;
    		sizeNow--;
    		int tempSize = size / 4;
    		if(tempSize >= sizeNow + 1 && size > 1){
    			size = size / 2;
    			T[] tempStack = (T[]) new Object[size];
    			for(int j = 0; j < tempStack.length; j++){
    				tempStack[j] = stack[j];
    			}
    			stack = tempStack;			
    		}
    			
    	    return temp;
    	}
    	throw new StackUnderflowException("nothing to pop");
    }

    @Override
    public T peek() throws StackUnderflowException {
    	// TODO 3
    	if(!isEmpty()){
    	   return stack[sizeNow];
    	}
    	throw new StackUnderflowException("nothing to peek");
    }

    @Override
    public void push(T element) {
    	// TODO 4
    	if(size - 1 == sizeNow){
    		size = size * 2;
    		T[] tempStack = (T[]) new Object[size];
    		for(int j = 0; j < stack.length; j++){
    			tempStack[j] = stack[j];
    		}
    	    stack = tempStack;	
    	}
    	sizeNow++;
    	stack[sizeNow] = element;
    	
    }

    @Override
    public boolean isEmpty() {
    	if(sizeNow == -1){
    	  return true;
    	}
    	return false;
    }

    @Override
    public int size() {
    	return sizeNow + 1;
    }

    @Override
    public int capacity() {
    	// TODO 5
    	return size;
    }
}