import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test class LinkedList
 */
public class ArrayLabTester {
  
  /**
   * Test the contains method
   */
  @Test
  public void testContains() {    
    int[] a = new int[] {11, 12, 13};
        
    assertTrue("Incorrectly claims 11 is not in a[0..2]", ArrayLab.contains(a, 0, 2, 11)); // Test many, first
    assertTrue("Incorrectly claims 12 is not in a[0..2]", ArrayLab.contains(a, 0, 2, 12)); // Test many, middle
    assertTrue("Incorrectly claims 13 is not in a[0..2]", ArrayLab.contains(a, 0, 2, 13)); // Test many, last
    assertTrue("Incorrectly claims 11 is not in a[0..0]", ArrayLab.contains(a, 0, 0, 11)); // Test one, element in
    assertFalse("Incorrectly claims 11 is in a[1..1]", ArrayLab.contains(a, 1, 1, 11));    // Test one, element not in
    assertFalse("Incorrectly claims 11 is in a[2..1]", ArrayLab.contains(a, 2, 1, 11));    // Test zero
  }
  
  
  /**
   * Test the arrayToString method.
   */
  @Test
  public void testArrayToString() {
    int[] a = {11, 13};
    int[] b = {11, 13, 15, 17, 19};

    assertEquals("Printing no elements", "{}", ArrayLab.arrayToString(a, 0));                              // Test zero
    assertEquals("Printing only the first element", "{11}", ArrayLab.arrayToString(a, 1));                 // Test one
    assertEquals("Printing both elements of an array of two", "{11 13}", ArrayLab.arrayToString(a, 2));    // Test two
    assertEquals("Printing the first four elements of an array of five","{11 13 15 17}", ArrayLab.arrayToString(b, 4));
  }

  /**
   * Test the remove method
   */
  @Test
  public void testRemove() {
    int[] a = {0, 1, 2, 3, 5, 7};          // Test remove last
    ArrayLab.remove(a, 6, 7);
    int[] b = {0, 1, 2, 3, 5};
    verifyPrefixOf(b, a);
    
    ArrayLab.remove(a, 5, 0);              // Test remove first
    b = new int[]{1, 2, 3, 5};
    verifyPrefixOf(b, a);

    ArrayLab.remove(a, 4, 2);              // Test remove middle
    b = new int[]{1, 3, 5};
    verifyPrefixOf(b, a);
  }
    
  /**
   * Calls JUnit test on each element to verify that the first array is a prefix of
   * the second array
   * @param expected  the expected prefix of the given array
   * @param given     the expected array should be the prefix of the given array
   */
  private void verifyPrefixOf(int[] expected, int[] given) {
    for (int i = 0; i < expected.length; i++)
      assertEquals("On index " + i, expected[i], given[i]);
  }

  /**
   * Test the insert method
   */
  @Test
  public void testInsert() {    
    int[] a = {0, 0, 0, 0, 0, 0};
    ArrayLab.insert(a, 0, 1);
    assertArrayEquals("Inserting an element into an empty array", new int[]{1, 0, 0, 0, 0, 0}, a);      // Test zero

    a[1]= 3;
    a[2]= 5;
    ArrayLab.insert(a, 3, 2);
    assertArrayEquals("Inserting an element that goes in the middle", new int[]{1, 2, 3, 5, 0, 0}, a);  // Test insert middle
    ArrayLab.insert(a, 4, 0);
    assertArrayEquals("Inserting an element that goes in the front", new int[]{0, 1, 2, 3, 5, 0}, a);   // Test insert first
    ArrayLab.insert(a, 5, 7);
    assertArrayEquals("Inserting an element that goes at the end", new int[]{0, 1, 2, 3, 5, 7}, a);     // Test insert last
  }
 
}
