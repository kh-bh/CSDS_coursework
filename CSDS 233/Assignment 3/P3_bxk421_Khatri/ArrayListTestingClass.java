import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ArrayListTestingClass {

    @Test
    public void testAdd() {
        ArrayList testAL = new ArrayList();
        assertEquals("[]", testAL.toString());
        testAL.add(1);
        testAL.add(2);
        assertEquals("[1 2 ]", testAL.toString());
        testAL.add(3);
        testAL.add(4);
        assertEquals("[1 2 3 4 ]", testAL.toString());
    }

    @Test
    public void testAddv2() {
        ArrayList testAL = new ArrayList();
        assertEquals("[]", testAL.toString());
        testAL.add(1);
        testAL.add(2,1);
        assertEquals("[1 2 ]", testAL.toString());
        testAL.add(3,1);
        testAL.add(4,8);
        assertEquals("[1 3 4 ]", testAL.toString());

        try {
            testAL.add(10,-2);
        } catch (Exception e) {
            final String expected = "Negative Index Value!";
            assertEquals(expected, e.getMessage());
        }
    }

    @Test
    public void testIndexOf() {
        ArrayList testAL = new ArrayList();
        testAL.add(1);
        testAL.add(2);
        testAL.add(3);
        testAL.add(4);

        assertEquals(0, testAL.indexof(1));
        assertEquals(1, testAL.indexof(2));
        assertEquals(2, testAL.indexof(3));
        assertEquals(3, testAL.indexof(4));
        assertEquals(-1, testAL.indexof(10));

        testAL.add(2,0);
        assertEquals(0, testAL.indexof(2));
    }

    @Test
    public void testRemove() {
        ArrayList testAL = new ArrayList();
        testAL.add(0);
        testAL.add(1);
        testAL.add(2);
        testAL.add(3);
        try {
            testAL.remove(-2);
        } catch (Exception e) {
            final String expected = "Negative Index Value!";
            assertEquals(expected, e.getMessage());
        }
        
        assertEquals(0,testAL.remove(0));
        assertEquals("[1 2 3 ]", testAL.toString());
        assertEquals(3,testAL.remove(10));
        assertEquals("[1 2 ]",testAL.toString());
        testAL.remove(1);
        assertEquals("[1 ]",testAL.toString());
    }

    @Test
    public void testRemoveValue() {
        ArrayList testAL = new ArrayList();
        testAL.add(0);
        testAL.add(1);
        testAL.add(2);
        testAL.add(3);
        testAL.add(4);
        testAL.add(5);
        testAL.add(6);
        assertEquals("[0 1 2 3 4 5 6 ]", testAL.toString());
        testAL.removeValue(0);
        assertEquals("[1 2 3 4 5 6 ]", testAL.toString());
        testAL.removeValue(6);
        assertEquals("[1 2 3 4 5 ]", testAL.toString());
        testAL.removeValue(3);
        assertEquals("[1 2 4 5 ]", testAL.toString());
        testAL.removeValue(2);
        assertEquals("[1 4 5 ]", testAL.toString());
        testAL.removeValue(9);
        assertEquals("[1 4 5 ]", testAL.toString());
        testAL.removeValue(4);
        assertEquals("[1 5 ]", testAL.toString());
        testAL.removeValue(5);
        assertEquals("[1 ]", testAL.toString());
        testAL.removeValue(1);
        assertEquals("[]", testAL.toString());
         
    }

    @Test
    public void testMean() {
        ArrayList testAL = new ArrayList();
        assertEquals(0,testAL.mean(),.001); //edge case
        testAL.add(5);
        assertEquals(5.0,testAL.mean(),.001); // simple case
        testAL.add(10);
        testAL.add(15);
        testAL.add(20);
        assertEquals(12.5,testAL.mean(),.001); //complicated case
    }

    @Test
    public void testVariance() {
        ArrayList testAL = new ArrayList();
        assertEquals(0,testAL.variance(),.001);
        testAL.add(5);
        assertEquals(0.0,testAL.variance(),.001);
        testAL.add(6);
        testAL.add(7);
        testAL.add(8);
        assertEquals(1.666,testAL.variance(),.001);
        testAL.add(6);
        testAL.add(7);
        testAL.add(8);
        assertEquals(1.238,testAL.variance(),.001);
    }

    @Test
    public void testSubList() {
        ArrayList testAL = new ArrayList();
        ArrayList emptyList = testAL.sublist(0, 10);
        assertEquals("[]", emptyList.toString()); 
        testAL.add(1);
        testAL.add(2);
        testAL.add(3);
        testAL.add(4);
        testAL.add(5);
        testAL.add(6);
        testAL.add(7);
        testAL.add(8);
        ArrayList l3h8 = testAL.sublist(3, 8); //format for name is low(l)#high(h)#
        assertEquals("[4 5 6 7 ]", l3h8.toString()); 
        ArrayList l8h9 = testAL.sublist(9, 10);
        assertEquals("[]", l8h9.toString());
        ArrayList l0h20 = testAL.sublist(0, 20);
        assertEquals("[1 2 3 4 5 6 7 8 ]", l0h20.toString()); 
    }

    @Test
    public void testRemoveNoise() {
        ArrayList testAL = new ArrayList();
        assertEquals(0,testAL.stddev(),.001);
        testAL.add(2);
        testAL.add(3);
        testAL.add(8);
        testAL.add(9);
        testAL.add(10);
        testAL.add(13);
        testAL.add(12);
        testAL.add(9);
        testAL.add(15);
        assertEquals(9.0,testAL.mean(),.001);
        assertEquals(4.055,testAL.stddev(),.001);
        ArrayList removeNoiseAL = testAL.removeNoise();
        assertEquals("[2 3 8 9 10 13 12 9 15 ]",removeNoiseAL.toString());
    }


}