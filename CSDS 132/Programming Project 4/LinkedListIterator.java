/**
 * @author Bhoomika Khatri
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

/** An iterator for our linked list.  The iterator loops over the data in the list from
  * the first node to the last.
  */
public class LinkedListIterator<T> implements Iterator<T> {
  
  // keeps track of which node will store the next value of the iteration
  private LLNode<T> nodeptr;
  
  private LLNode<T> firstNodeSave;
  
  /**
   * Create an iterator that loops over the data in the list starting at the given first node
   * @param firstNode the node to start this loop over the data in the list
   */
  public LinkedListIterator(LLNode<T> firstNode) {
    nodeptr = firstNode;
    nodeptr = firstNodeSave;
  }
  
  /**
   * Returns true if there is more data we can loop over and false if the loop reached the end of the list.
   * @return true if there is more data to loop ov;r
   */
  public boolean hasNext() {
    return nodeptr != null;
  }
  
  /**
   * Returns the next value from the linked list in this iterator that loops over the list data.
   * @return the next value in this loop over the linked list data
   * @throws NoSuchElementException if next() is called after the loop reaches the end of the list
   */
  public T next() {
    if (nodeptr == null)
      throw new NoSuchElementException();
    
    T save = nodeptr.getElement();
    nodeptr = nodeptr.getNext();
    return save;
  }
  
  /* This code is not working. Thus, I commented it out
  public void remove(){
    if (nodeptr == firstNodeSave.getNext()) {
      this.setNext(firstNodeSave.getNext().getNext());
    }
    else {
      firstNodeSave = firstNodeSave.getNext();
    }
  }
  */
}