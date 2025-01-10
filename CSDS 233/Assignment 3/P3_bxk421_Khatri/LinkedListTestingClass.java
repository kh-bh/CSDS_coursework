import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LinkedListTestingClass {
    
    @Test
    public void testAdd() {
        LinkedList testLL = new LinkedList();
        assertEquals("[]", testLL.toString());
        testLL.add(1);
        assertEquals("[1 ]", testLL.toString());
        testLL.add(2);
        assertEquals("[1 2 ]", testLL.toString());
        testLL.add(3);
        assertEquals("[1 2 3 ]", testLL.toString());
    }

    @Test
    public void testAddv2() {
        LinkedList testLL = new LinkedList();
        assertEquals("[]", testLL.toString());
        testLL.add(0);
        testLL.add(1);
        testLL.add(2);
        testLL.add(3);
        testLL.add(4);
        testLL.add(5);
        testLL.add(6);
        assertEquals("[0 1 2 3 4 5 6 ]", testLL.toString());
        testLL.add(7, 10);
        assertEquals("[0 1 2 3 4 5 6 7 ]", testLL.toString());
        testLL.add(10, 4);
        assertEquals("[0 1 2 3 10 5 6 7 ]", testLL.toString());

        try {
            testLL.add(10,-2);
        } catch (Exception e) {
            final String expected = "Negative Index Value!";
            assertEquals(expected, e.getMessage());
        }

    }

    @Test
    public void testIndexOf() {
        LinkedList testLL = new LinkedList();
        testLL.add(1);
        testLL.add(2);
        testLL.add(3);
        testLL.add(4);

        assertEquals(0, testLL.indexof(1));
        assertEquals(1, testLL.indexof(2));
        assertEquals(2, testLL.indexof(3));
        assertEquals(3, testLL.indexof(4));
        assertEquals(-1, testLL.indexof(10));
    }

    @Test
    public void testRemove() {
        LinkedList testLL = new LinkedList();
        testLL.add(0);
        testLL.add(1);
        testLL.add(2);
        testLL.add(3);
        testLL.add(4);
        try {
            testLL.remove(-2);
        } catch (Exception e) {
            final String expected = "Negative Index Value!";
            assertEquals(expected, e.getMessage());
        }

        assertEquals("[0 1 2 3 4 ]", testLL.toString());
        assertEquals(4, testLL.remove(4));
        assertEquals("[0 1 2 3 ]", testLL.toString());
        assertEquals(3, testLL.remove(10));
        assertEquals("[0 1 2 ]",testLL.toString());
        assertEquals(1, testLL.remove(1));
        assertEquals("[0 2 ]",testLL.toString());
        assertEquals(0, testLL.remove(0));
        assertEquals("[2 ]",testLL.toString());
        assertEquals(2, testLL.remove(10));
    }

    @Test
    public void testRemoveValue() {
        LinkedList testLL = new LinkedList();
        testLL.add(0);
        testLL.add(1);
        testLL.add(2);
        testLL.add(3);
        testLL.add(4);
        testLL.add(5);
        testLL.add(6);
        assertEquals("[0 1 2 3 4 5 6 ]", testLL.toString());
        testLL.removeValue(0);
        assertEquals("[1 2 3 4 5 6 ]", testLL.toString());
        testLL.removeValue(3);
        assertEquals("[1 2 4 5 6 ]", testLL.toString());
        testLL.removeValue(6);
        assertEquals("[1 2 4 5 ]", testLL.toString());
        testLL.removeValue(2);
        assertEquals("[1 4 5 ]", testLL.toString());
        testLL.removeValue(9);
        assertEquals("[1 4 5 ]", testLL.toString());
        testLL.removeValue(4);
        assertEquals("[1 5 ]", testLL.toString());
        testLL.removeValue(5);
        assertEquals("[1 ]", testLL.toString());
        testLL.removeValue(1);
        assertEquals("[]", testLL.toString());
    }

    @Test
    public void testRemoveAll() {
        LinkedList testLL = new LinkedList();
        testLL.add(6);
        testLL.add(2);
        testLL.add(1);
        testLL.add(1);
        testLL.add(2);
        testLL.add(6);
        assertEquals("[6 2 1 1 2 6 ]", testLL.toString());
        testLL.removeValue(2);
        assertEquals("[6 1 1 6 ]", testLL.toString());
    }

    @Test
    public void testMean() {
        LinkedList testLL = new LinkedList();
        assertEquals(0,testLL.mean(),.001); //edge case
        testLL.add(5);
        assertEquals(5.0,testLL.mean(),.001); // simple case
        testLL.add(10);
        testLL.add(15);
        testLL.add(20);
        assertEquals(12.5,testLL.mean(),.001); //complicated case
    }

    @Test
    public void testVariance() {
        LinkedList testLL = new LinkedList();
        assertEquals(0,testLL.variance(),.001);
        testLL.add(5);
        assertEquals(0.0,testLL.variance(),.001);
        testLL.add(6);
        testLL.add(7);
        testLL.add(8);
        assertEquals(1.666,testLL.variance(),.001);
        testLL.add(6);
        testLL.add(7);
        testLL.add(8);
        assertEquals(1.238,testLL.variance(),.001);
    }

    @Test
    public void testSubList() {
        LinkedList testLL = new LinkedList();
        LinkedList emptyList = testLL.sublist(0, 10);
        assertEquals("[]", emptyList.toString()); 
        testLL.add(1);
        testLL.add(2);
        testLL.add(3);
        testLL.add(4);
        testLL.add(5);
        testLL.add(6);
        testLL.add(7);
        testLL.add(8);
        LinkedList l3h8 = testLL.sublist(3, 8); //format for name is low(l)#high(h)#
        assertEquals("[4 5 6 7 ]", l3h8.toString()); 
        LinkedList l8h9 = testLL.sublist(9, 10);
        assertEquals("[]", l8h9.toString());
        LinkedList l0h20 = testLL.sublist(0, 20);
        assertEquals("[1 2 3 4 5 6 7 8 ]", l0h20.toString()); 
    }
    
    @Test
    public void testRemoveNoise() {
        LinkedList testLL = new LinkedList();
        testLL.add(2);
        testLL.add(3);
        testLL.add(8);
        testLL.add(9);
        testLL.add(10);
        testLL.add(13);
        testLL.add(12);
        testLL.add(9);
        testLL.add(15);
        assertEquals(9.0,testLL.mean(),.001);
        LinkedList removeNoiseLL = testLL.removeNoise();
        assertEquals("[2 3 8 9 10 13 12 9 15 ]",removeNoiseLL.toString());
    }

    /*
    @Test
    public void testReverseLinkedListInSections(){
        LinkedList testLL = new LinkedList();
        testLL.add(12);
        testLL.add(15);
        testLL.add(24);
        testLL.add(10);
        testLL.add(19);
        assertEquals("[12 15 19 10 24 ]",(testLL.ReverseLinkedListInSections(testLL,3,5)).toString());
        testLL.add(22);
        assertEquals("[12 15 24 10 19 22 ]",(testLL.ReverseLinkedListInSections(testLL,3,5)).toString());
        assertEquals("[12 10 24 15 19 22 ]",(testLL.ReverseLinkedListInSections(testLL,2,4)).toString());
        assertEquals("[12 10 24 15 19 22 ]",(testLL.ReverseLinkedListInSections(testLL,2,4)).toString());
    }
    */
}
