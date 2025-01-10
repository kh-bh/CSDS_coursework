/**
 * @author Bhoomika Khatri
 */

/**
 * A class to represent a domino and the function to rotate dominoes
 */
public class DominoTrain extends LinkedList<Domino> {
  
  /**
   * The first domino for the train
   */
  private int mexicanDominoValue;
  
  /**
   * The value that needs to be compared for the train
   */
  private int dominoValue;
  
  private LLNode<Domino> nodeptr;
  
  /**
   * the constructor
   * @param mexicanDominoValue  the mexican train element
   */
  public DominoTrain(int mexicanDominoValue) {
    this.mexicanDominoValue = mexicanDominoValue;
    this.dominoValue = mexicanDominoValue;
  }
  
  @Override
  public void addToFront(Domino dElement) {
    if (canAdd(dElement) == true) {
      if (dominoValue == dElement.getDomino1()) {
        if (isEmpty())
          setFirstNode(new LLNode<Domino>(dElement, getFirstNode()));
        else {
          LLNode<Domino> nodeptr = this.getFirstNode();
          while (nodeptr.getNext() != null)
            nodeptr = nodeptr.getNext();
          nodeptr.setNext(new LLNode<Domino>(dElement, null));
        }
        dominoValue = dElement.getDomino2();
      }
      else {
        if (isEmpty())
          setFirstNode(new LLNode<Domino>(dElement.rotate(), getFirstNode()));
        else {
          LLNode<Domino> nodeptr = this.getFirstNode();
          while (nodeptr.getNext() != null)
            nodeptr = nodeptr.getNext();
          nodeptr.setNext(new LLNode<Domino>(dElement.rotate(), null));
        }
        dominoValue = dElement.rotate().getDomino2();
      }
    }
  }
  
  public int getEndValue(){
    nodeptr = this.getFirstNode();
    int lastDominoNumber = 0;
    if (nodeptr != null) {
      lastDominoNumber = nodeptr.getElement().getDomino2();
      nodeptr = nodeptr.getNext();
      System.out.println(lastDominoNumber);
    }
    else {
      return lastDominoNumber;
    }
    lastDominoNumber = dominoValue;
    return lastDominoNumber;
  }
  
  public boolean canAdd(Domino dElement) {
    if (dominoValue == dElement.getDomino1() || dominoValue == dElement.getDomino2())
      return true;
    else
      return false;
  }
}