package sets;

import java.util.Iterator;

public class LinkedSet<E> implements Set<E> {
  private LinkedNode<E> head = null;

  // Constructors
  public LinkedSet() {
  }

  public LinkedSet(E e) {
    this.head = new LinkedNode<E>(e, null);
  }

  private LinkedSet(LinkedNode<E> head) {
    this.head = head;
  }

  @Override
  public int size() {
	 // TODO (1)
     int size = 0;  
     Iterator<E> itr = this.iterator();
     while(itr.hasNext()){
		size++;
		itr.next();
     }
	 return size;
  }

  @Override
  public boolean isEmpty() {
    // TODO (2)
	if(head == null){
		return true;
	}
    return false;
  }

  @Override
  public Iterator<E> iterator() {
    return new LinkedNodeIterator<E>(this.head);
  }

  @Override
  public boolean contains(Object o) {
    // TODO (3)
	LinkedNode<E> temp = head;
	while(temp != null){
		if(temp.getData().equals(o)){
			return true;
		}
		temp = temp.getNext();
	}
	
    return false;
  }

  @Override
  public boolean isSubset(Set<E> that) {
    // TODO (4)
	for(E e : this){
		if(that.contains(e) != true){
			return false;
		}
	}
    return true;
  }

  @Override
  public boolean isSuperset(Set<E> that) {
    // TODO (5)
	if(that.isSubset(this) != true){
		return false;
	}
    return true;
  }

  @Override
  public Set<E> adjoin(E e) {
	// TODO (6)
	if(contains(e)){
		return this;
	}
	LinkedNode<E> temp = new LinkedNode<E>(e, head);
	LinkedSet<E> set = new LinkedSet<E>(temp);
	return set;
  }


  @Override
  public Set<E> union(Set<E> that) {
    // TODO (7)
	LinkedSet<E> temp = new LinkedSet<E>();
	for(E temp1 : this){
		temp = (LinkedSet<E>) temp.adjoin(temp1);
	}
	for(E temp2 : that){
		temp = (LinkedSet<E>) temp.adjoin(temp2);
	}
    return temp;
  }

  @Override
  public Set<E> intersect(Set<E> that) {
    // TODO (8)
	LinkedSet<E> temp = new LinkedSet<E>();
      for(E temp1 : this){
		if(that.contains(temp1)){
		   temp = (LinkedSet<E>) temp.adjoin(temp1);
		}
	  }
	return temp;
  }

  @Override
  public Set<E> subtract(Set<E> that) {
    // TODO (9)
	LinkedSet<E> temp = new LinkedSet<E>();
	for(E temp1 : this){
		if(that.contains(temp1)){
		}
		else{
			temp = (LinkedSet<E>) temp.adjoin(temp1);
		}
	}
    return temp;
  }

  @Override
  public Set<E> remove(E e) {
    // TODO (10)
	LinkedSet<E> temp = new LinkedSet<E>();
	for(E temp1 : this){
		if(temp1 == e){
		}
		else{
			temp = (LinkedSet<E>) temp.adjoin(temp1);
		}
	}
    return temp;
  }

  @Override
  @SuppressWarnings("unchecked")
  public boolean equals(Object o) {
    if (! (o instanceof Set)) {
      return false;
    }
    Set<E> that = (Set<E>)o;
    return this.isSubset(that) && that.isSubset(this);
  }

  @Override
    public int hashCode() {
    int result = 0;
    for (E e : this) {
      result += e.hashCode();
    }
    return result;
  }
}
