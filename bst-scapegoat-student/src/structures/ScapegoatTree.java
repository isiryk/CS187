package structures;

public class ScapegoatTree<T extends Comparable<T>> extends
  BinarySearchTree<T> {

 private int upperBound = 0;
 private BSTNode<T> tempNode;
 
 
 public ScapegoatTree(){
	 tempNode = null;
 }
 
 public ScapegoatTree(BSTNode<T> tempNode){
	 this.root = tempNode;
 }
 /**
  * Adds an element to the tree.
  * 
  * The modified tree must still obey the BST rule, though it might not be
  * balanced.
  * 
  * In addition to obeying the BST rule, the resulting tree must also obey
  * the scapegoat rule. 
  * 
  * This method must only perform rebalancing of subtrees when indicated
  * by the scapegoat rule; do not unconditionally call balance() 
  * after adding, or you will receive no credit. 
  * See the project writeup for details.
  * 
  * @param element
  * @throws NullPointerException if element is null
  */
@Override
 public void add(T element) {
  // TODO
  if(element == null){
	  throw new NullPointerException();
  }
  upperBound++;
  super.add(element);
  double value = Math.log((double)upperBound)/Math.log(3.0/2.0);
  if((double)height() <= value){
	  return;
  }
  else{
	 BSTNode<T> addMe = getNodeFromTree(element, root);
	 double value2 = (double)subtreeSize(addMe)/(double)subtreeSize(addMe.getParent());
	 while(value2 <= (double)2.0/3.0){
		 addMe = addMe.getParent();
		 value2 = (double)subtreeSize(addMe)/(double)subtreeSize(addMe.getParent());
	 }
	 BSTNode<T> parentAddMe = addMe.getParent();
	 ScapegoatTree<T> cool = new ScapegoatTree<T>(addMe);
	 cool.balance();
	 if(parentAddMe.getRight() == addMe){
		 parentAddMe.setRight(cool.getRoot());
	 }
	 else{
		 parentAddMe.setLeft(cool.getRoot());
	 }
  }
 }
 
 /**
  * Attempts to remove one copy of an element from the tree, returning true
  * if and only if such a copy was found and removed.
  * 
  * The modified tree must still obey the BST rule, though it might not be
  * balanced.
  * 
  * In addition to obeying the BST rule, the resulting tree must also obey
  * the scapegoat rule.
  * 
  * This method must only perform rebalancing of subtrees when indicated
  * by the scapegoat rule; do not unconditionally call balance() 
  * after removing, or you will receive no credit. 
  * See the project writeup for details.

  * @param element
  * @return true if and only if an element removed
  * @throws NullPointerException if element is null
  */
 @Override
 public boolean remove(T element) {
  // TODO
  if(element == null){
   throw new NullPointerException();
  }
  if (super.remove(element)) {
            if (2*size() < upperBound) {
                balance();
                upperBound = size();
            }
            return true;
        }
        return false;
 }

}