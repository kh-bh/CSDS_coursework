import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class DemoBagTestingClass {

    /**
     * Tests the Remove All method for an instance of a given
     */
    @Test
    public void testRemoveAll() {
        DualImplementationBag<String> testLinkedList = new DualImplementationBag<String>(false);
        testLinkedList.add("Value One");
        testLinkedList.add("Value Two");
        testLinkedList.add("Value One");
        testLinkedList.add("Value One");
        testLinkedList.add("Value Three");
        testLinkedList.add("Value One");
        testLinkedList.add("Value One");

        DemoBag<String> testLL = new DemoBag<String>();
        testLL.removeAll(testLinkedList, "Value One");
        assertEquals("What is the first Node of LL", "Value Two", testLinkedList.get(0));
        assertEquals("What is the second Node of LL", "Value Three", testLinkedList.get(1));
        System.out.println(testLinkedList.size());
    }

    /**
     * Tests the Retain all, which keeps all instances of given element
     */
    @Test
    public void testRetainAll() {
        DualImplementationBag<String> testLinkedList = new DualImplementationBag<String>(false);
        testLinkedList.add("Value One");
        testLinkedList.add("Value Two");
        testLinkedList.add("Value One");
        testLinkedList.add("Value One");
        testLinkedList.add("Value Three");

        DemoBag<String> testLL = new DemoBag<String>();
        testLL.retainAll(testLinkedList, "Value One");
        assertEquals("What is the first Node of LL", "Value One", testLinkedList.get(0));
        assertEquals("What is the second Node of LL", "Value One", testLinkedList.get(1));

    }
    
    /**
     * Tests the Union of two bags
     */
     @Test
    public void testUnion() {
        DualImplementationBag<String> testLinkedList = new DualImplementationBag<String>(false);
        testLinkedList.add("Value One");
        testLinkedList.add("Value Two");
        testLinkedList.add("Value Three");
        DualImplementationBag<String> testArrayList = new DualImplementationBag<String>(true);
        testArrayList.add("Value Four");
        testArrayList.add("Value Five");
        testArrayList.add("Value Six");

        DualImplementationBag<String> testUnionExpected = new DualImplementationBag<String>(true);
        testUnionExpected.add("Value One");
        testUnionExpected.add("Value Two");
        testUnionExpected.add("Value Three");
        testUnionExpected.add("Value Four");
        testUnionExpected.add("Value Five");
        testUnionExpected.add("Value Six");

        DemoBag<String> testUnionBag = new DemoBag<String>();
        DualImplementationBag<String> testUnionActual = new DualImplementationBag<String>(true);
        testUnionActual = testUnionBag.union(testLinkedList, testArrayList);
        assertEquals("The two arrays are equal", testUnionExpected.get(0), testUnionActual.get(0));
        assertEquals("The two arrays same stuff", testUnionExpected.size(), testUnionActual.size());
    }

    /**
     * Tests adding the intersection of the two bags
     */
    @Test
    public void testIntersection() {
        DualImplementationBag<String> testLinkedList = new DualImplementationBag<String>(false);
        testLinkedList.add("Value One");
        testLinkedList.add("Value Two");
        testLinkedList.add("Value Three");
        DualImplementationBag<String> testArrayList = new DualImplementationBag<String>(true);
        testArrayList.add("Value Four");
        testArrayList.add("Value Five");
        testArrayList.add("Value One");

        DualImplementationBag<String> testIntersectionExpected = new DualImplementationBag<String>(true);
        testIntersectionExpected.add("Value One");

        DemoBag<String> testIntersectionBag = new DemoBag<String>();
        DualImplementationBag<String> testUnionActual = new DualImplementationBag<String>(true);
        testUnionActual = testIntersectionBag.intersection(testLinkedList, testArrayList);
        assertEquals("The two arrays are equal", testIntersectionExpected.get(0), testUnionActual.get(0));
        assertEquals("The two arrays same stuff", testIntersectionExpected.size(), testUnionActual.size());
    }

    /**
     * This is a test that record the different values
     */
    @Test
    public void testDifference() {
        DualImplementationBag<String> testLinkedList = new DualImplementationBag<String>(false);
        testLinkedList.add("Value One");
        testLinkedList.add("Value Two");
        testLinkedList.add("Value Three");
        DualImplementationBag<String> testArrayList = new DualImplementationBag<String>(true);
        testArrayList.add("Value One");
        testArrayList.add("Value Five");
        testArrayList.add("Value Six");

        DualImplementationBag<String> testDifferenceExpected = new DualImplementationBag<String>(true);
        testDifferenceExpected.add("Value Two");
        testDifferenceExpected.add("Value Three");
        testDifferenceExpected.add("Value Five");
        testDifferenceExpected.add("Value Six");

        DemoBag<String> testDifferenceBag = new DemoBag<String>();
        DualImplementationBag<String> testDifferenceActual = new DualImplementationBag<String>(true);
        testDifferenceActual = testDifferenceBag.difference(testLinkedList, testArrayList);
        assertEquals("The two arrays same stuff", testDifferenceExpected.get(0), testDifferenceActual.get(0));
        assertEquals("The two arrays same stuff", testDifferenceExpected.size(), testDifferenceActual.size());
    }

}
