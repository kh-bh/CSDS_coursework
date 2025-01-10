import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Lab5Tester {
  
  @Test
  public void testCountSpaces() {
    assertEquals(0, Lab5.countSpaces("abcd"));
    assertEquals(5, Lab5.countSpaces("a  b c d e"));
  }
  
}