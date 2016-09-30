package sets;

import java.util.Iterator;
import java.util.NoSuchElementException;

class LinkedNodeIterator<E> implements Iterator<E> {
  // TODO (1) choose appropriate attributes
  private LinkedNode<E> head;	

  // Constructors
  public LinkedNodeIterator(LinkedNode<E> head) {
    // TODO (2) choose appropriate parameters and do the initialization
	  this.head = head;
  }

  @Override
  public boolean hasNext() {
    // TODO (3)
	  if(head != null){
		  return true;
	  }
      return false;
  }

  @Override
  public E next() {
    // TODO (4)
	LinkedNode<E> temp = head;
	if(head != null){
		head = head.getNext();
		return temp.getData();
	}
    throw new NoSuchElementException();
  }

  // Leave this one alone.
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}