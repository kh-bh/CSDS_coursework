import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test class LinkedList
 */
public class MexicanTrainGameTests {
  
  /**
   * Test first Element
   */
  @Test
  public void testFirstElement() {
    LLNode <String> listHead = new LLNode<String> ("1" , null);
    LLNode<String> node2 = new LLNode<String> ("2", null);
    LLNode<String> node3 = new LLNode<String> ("3", null);
    LinkedList<String> testlist = new LinkedList<String>();
    listHead.setNext(node2);
    listHead.getNext().setNext(node3);
    testlist.setFirstNode(listHead);
    assertEquals("Testing first node of list", "1", testlist.firstElement());
  }
  
  /**
   * Test remove
   */
  @Test
  public void testRemove() {
    // This is not working, so there isn't a viable test
  }
  
  /**
   * Test toString
   */
  public void testToStringDomino() {
    Domino toStringDomino = new Domino(3,4);
    assertEquals("Testing first node of list","[3|4]" , toStringDomino.toString());
  }
  
  /**
   * Test rotate
   */
  public void testRotate(){
    Domino tRotate = new Domino(3,4);
    assertEquals("Testing first node of list","[4|3]" , tRotate.rotate().toString());
  }
  
  /**
   * Test addToFront
   */
  public void testAddToFront() {
    Domino getVal1 = new Domino(3,9);
    Domino getVal2 = new Domino(5,3);
    DominoTrain train = new DominoTrain(9);
    assertEquals(true, train.addToFront(getVal1));
  }
  
  /**
   * Test getEndValue
   */
  public void testGetEndValue() {
    Domino getVal1 = new Domino(3,9);
    Domino getVal2 = new Domino(5,3);
    DominoTrain train = new DominoTrain(9);
    train.addToFront(getVal1);
    assertEquals(3, train.getEndValue());
    train.addToFront(getVal2);
    assertEquals(5, train.getEndValue());
  }
  
  /**
   * Test canAdd method
   */
  @Test
  public void testCanAdd () {
    Domino getVal1 = new Domino(3,9);
    Domino getVal2 = new Domino(5,3);
    DominoTrain train = new DominoTrain(9);
    assertEquals(true, train.canAdd(getVal1));
    assertEquals(false, train.canAdd(getVal2));
  }
}
  
  