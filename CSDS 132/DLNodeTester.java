import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test classes DLNode
 */
public class DLNodeTester {
  
  /**
   * Test get Previous
   */
  @Test
  public void testGetPrevious() {
    DLNode test = new DLNode(1,null,null);
    DLNode test1 = new DLNode(2,test,null);
    DLNode test2 = new DLNode(3,test1,null);
    assertEquals("Checking the first node from the back", null, test.getPrevious());
    assertEquals("Checking the second node from the back", 1, test.getNext().getPrevious().getElement());
    assertEquals("Checking the third node from the back", 2, test.getNext().getNext().getPrevious().getElement());
  }
  
  /**
   * Test get Next
   */
  @Test
  public void testGetNext() {
    DLNode list = new DLNode(1,null,null);
    DLNode list1 = new DLNode(2,list,null);
    DLNode list2 = new DLNode(3,list1,null);
    assertEquals("Checking the first node from the back", 1, list.getElement());
    assertEquals("Checking the second node from the back", 2, list.getNext().getElement());
    assertEquals("Checking the third node from the back", 3, list.getNext().getNext().getElement());
    assertEquals("Checking the third node from the back", null, list.getNext().getNext().getNext());
  }
}
