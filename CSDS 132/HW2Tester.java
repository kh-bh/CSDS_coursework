// Bhoomika Khatri

// These are the imported things to be able to test
import org.junit.Test;
import static org.junit.Assert.assertEquals;

//This is a class that tests the methods from HW2
public class HW2Tester {
  
  // This is a method that tests onlyEnglishLetters
  @Test
  public void testOnlyEnglishLetters () {
    assertEquals (false, HW2.onlyEnglishLetters("")); // Test none
    assertEquals (true, HW2.onlyEnglishLetters("a")); // Test one
    assertEquals (false, HW2.onlyEnglishLetters("1!")); // Test two?
    assertEquals (true, HW2.onlyEnglishLetters("abDkfdoFRs")); // Test many
    assertEquals (false, HW2.onlyEnglishLetters("lFKe5aaa"));
  }
  
  @Test
  // This is a method that tests if the method being tested will replace the correct index 
  public void testReplaceKth () {
    assertEquals ("", HW2.replaceKth('a', 'x', 3, "")); // Test none
    assertEquals ("abcaxa", HW2.replaceKth('a', 'x', 3, "abcaaa")); // Test middle
    assertEquals ("aaaaa",HW2.replaceKth('a', 'x', 6, "aaaaa")); // Test last (/ none)
  }
  
  @Test
  // This is a method that tests if the method being tested with intertwine the two strings correctly
  public void testInterleave () {
    assertEquals ("AaBbCcde", HW2.interleave("ABC", "abcde")); // Test first
    assertEquals ("aAbBcCde", HW2.interleave("abcde", "ABC")); // Test second
  }
  
  @Test
  // This is a method that tests if the blank words method will successfully create blank words
  public void testBlankWords () {
    assertEquals ("", HW2.blankWords("")); // Test none
    assertEquals ("T", HW2.blankWords("T")); // Test one
    assertEquals ("T__s is a T__t.", HW2.blankWords("This is a Test.")); //Test many
  }
  
  @Test
  // This is a method that tests if the nth words of a string sequence will become a new sequence
  public void testNthWord () {
    assertEquals("", HW2.nthWord(1, "")); // Test none
    assertEquals("zero ", HW2.nthWord(10, "zero one    two  three four five six seven")); // Test one
    assertEquals("zero three six " ,HW2.nthWord(3, "zero one    two  three four five six seven")); // Test many 
  }
  
  @Test
  // This is a method that tests if a string will truncate at a given "truncation" spot at/after the index
  public void testTruncateAfter () {
    assertEquals("La-", HW2.truncateAfter(1,"La-te-ly the-re.")); // Test first
    assertEquals("Late-", HW2.truncateAfter(5, "La-te-ly the-re.")); // Test middle
    assertEquals("Lately the-", HW2.truncateAfter(7, "La-te-ly the-re.")); // Test middle -- fail
    assertEquals("Lately", HW2.truncateAfter(6, "La-te-ly the-re.")); // Test middle
    assertEquals("Lately there.", HW2.truncateAfter(20,"La-te-ly the-re.")); // Test last
  }
  
}