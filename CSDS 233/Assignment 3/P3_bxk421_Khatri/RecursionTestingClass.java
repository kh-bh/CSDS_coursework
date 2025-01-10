import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RecursionTestingClass {

    @Test
    public void testSumDigits() {
        Recursion testRecursive = new Recursion();
        assertEquals(2, testRecursive.sumDigits(11));
        assertEquals(2, testRecursive.sumDigits(-11));
        assertEquals(24, testRecursive.sumDigits(81249));
    }

    @Test
    public void testGCD() {
        Recursion testRecursive = new Recursion();
        assertEquals(6,testRecursive.gcd(48,6));
        assertEquals(1,testRecursive.gcd(17,6));
        assertEquals(1,testRecursive.gcd(299792458,97));
        assertEquals(6,testRecursive.gcd(6,48));
    }
    
    @Test
    public void testIsPalidrome() {
        Recursion testRecursive = new Recursion();
        assertEquals(true, testRecursive.isPalidrome("a"));
        assertEquals(true, testRecursive.isPalidrome("bab"));
        assertEquals(true, testRecursive.isPalidrome("racecar"));
        assertEquals(false, testRecursive.isPalidrome("palidrome"));
    }

    @Test
    public void testReverseNode() {
        Recursion testRecursive = new Recursion();
        

        Node headOriginal1 = new Node(1, null);
        headOriginal1.setNext(new Node(2,null));
        headOriginal1.getNext().setNext(new Node(3,null));
        headOriginal1.getNext().getNext().setNext(new Node(4,null));
        headOriginal1.getNext().getNext().getNext().setNext(new Node(5,null));
        assertEquals(headOriginal1.getNext(), testRecursive.swapNodesInPairs(headOriginal1));

        Node headOriginal2 = new Node(5, null);
        headOriginal2.setNext(new Node(6,null));
        headOriginal2.getNext().setNext(new Node(9,null));
        headOriginal2.getNext().getNext().setNext(new Node(10,null));
        headOriginal2.getNext().getNext().getNext().setNext(new Node(12,null));
        headOriginal2.getNext().getNext().getNext().getNext().setNext(new Node(82,null));
        assertEquals(headOriginal2.getNext(), testRecursive.swapNodesInPairs(headOriginal2));

        Node headOriginal3 = new Node(5, null);
        headOriginal3.setNext(new Node(6,null));
        headOriginal3.getNext().setNext(new Node(9,null));
        assertEquals(headOriginal3.getNext(), testRecursive.swapNodesInPairs(headOriginal3));
    }

    @Test
    public void testBinomial() {
        Recursion testRecursive = new Recursion();
        
        try {
            testRecursive.binomial(10,0);
        } catch (Exception e) {
            final String expected = "Nuh uh!";
            assertEquals(expected, e.getMessage());
        }

        try {
            testRecursive.binomial(-1,12);
        } catch (Exception e) {
            final String expected = "Nuh uh!";
            assertEquals(expected, e.getMessage());
        }

        try {
            testRecursive.binomial(12,-1);
        } catch (Exception e) {
            final String expected = "Nuh uh!";
            assertEquals(expected, e.getMessage());
        }
        
        assertEquals(45,testRecursive.binomial(10,2));
    }
}