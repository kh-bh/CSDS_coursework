import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class DualImplementationTestingClass {
    /**
     * This function tests the Add function of DualImplementation bag, first a LL and then an Array
     */
    @Test
    public void testAdd() {
        DualImplementationBag<String> testLinkedList = new DualImplementationBag<String>(false);
        assertEquals("Add a value", true,testLinkedList.add("Value One"));
        assertEquals("Add another value", true,testLinkedList.add("Value Two"));

        DualImplementationBag<String> testArray = new DualImplementationBag<String>(true);
        assertEquals("Add a value", true,testArray.add("Value One"));
        assertEquals("Add another value", true,testArray.add("Value Two"));

        testArray.setUseArrayList(false);
        assertEquals("Add a value", true,testArray.add("Value One"));
        assertEquals("Add another value", true,testArray.add("Value Two"));
    }

    /**
     * This function tests the Remove function of DualImplementation bag, first a LL and then an Array
     */
    @Test
    public void testRemove() {
        DualImplementationBag<String> testLinkedList = new DualImplementationBag<String>(false);
        testLinkedList.add("Value One");
        testLinkedList.add("Value Two");
        testLinkedList.add("Value Three");
        assertEquals("Removing the first Value", true, testLinkedList.remove("Value One"));
        assertEquals("Trying to Remove a value not present", false, testLinkedList.remove("NonValue"));

        DualImplementationBag<String> testArray = new DualImplementationBag<String>(true);
        testArray.add("Value One");
        testArray.add("Value Two");
        testArray.add("Value Three");
        assertEquals("Removing the first Value", true, testArray.remove("Value One"));
        assertEquals("Trying to Remove a value not present", false, testArray.remove("NonValue"));
    }

    /**
     * This function tests the Contains function of DualImplementation bag, first a Array and then an LL
     */
    @Test
    public void testContains (){
        DualImplementationBag<String> test = new DualImplementationBag<String>(true);
        test.add("Value One");
        test.add("Value Two");
        test.add("Value Three");
        assertEquals("Checking for the first value", true, test.contains("Value One"));
        assertEquals("Checking for the second value", true, test.contains("Value Two"));
        assertEquals("Checking for the last value", true, test.contains("Value Three"));
        assertEquals("Checking for a nonvalue", false, test.remove("NonValue"));

        test.setUseArrayList(false);
        assertEquals("Checking for the first value", true, test.contains("Value One"));
        assertEquals("Checking for the second value", true, test.contains("Value Two"));
        assertEquals("Checking for the last value", true, test.contains("Value Three"));
        assertEquals("Checking for a nonvalue", false, test.remove("NonValue"));
    }

    @Test
    public void testIsEmpty() {
        DualImplementationBag<String> testLinkedList = new DualImplementationBag<String>(false);
        assertEquals("Check for empty List", true, testLinkedList.isEmpty());
        testLinkedList.add("Value One");
        testLinkedList.add("Value Two");
        testLinkedList.add("Value Three");
        assertEquals("Check for empty List", false, testLinkedList.isEmpty());

        DualImplementationBag<String> testArray = new DualImplementationBag<String>(true);
        assertEquals("Check for empty List", true, testArray.isEmpty());
        testArray.add("Value One");
        testArray.add("Value Two");
        testArray.add("Value Three");
        assertEquals("Check for empty List", false, testArray.isEmpty());
    }

    /**
     * This function tests the Size function of DualImplementation bag, first a Array and then an LL
     */
    @Test
    public void testSize() {
        DualImplementationBag<String> test = new DualImplementationBag<String>(true);
        test.add("Value One");
        test.add("Value Two");
        test.add("Value Three");
        test.add("Value Four");
        assertEquals("Checking for the size of the 3 element list", 4, test.size());

        test.setUseArrayList(false);
        assertEquals("Checking for the size of the 3 element list", 4, test.size());
    }

    /**
     * This function tests the getFrequencyOf function of DualImplementation bag, first a Array and then an LL
     */
    @Test
    public void testGetFrequencyOf() {
        DualImplementationBag<Integer> test = new DualImplementationBag<Integer>(false);
        test.add(1);
        test.add(1);
        test.add(2);
        assertEquals("Checking for the frequency of 1", 2, test.getFrequencyOf(1));
        assertEquals("Checking for the frequency of 2", 1, test.getFrequencyOf(2));
        assertEquals("Checking for the frequency of 23 (not in list)", 0, test.getFrequencyOf(3));

        test.setUseArrayList(false);
        assertEquals("Checking for the frequency of 1", 2, test.getFrequencyOf(1));
        assertEquals("Checking for the frequency of 2", 1, test.getFrequencyOf(2));
        assertEquals("Checking for the frequency of 23 (not in list)", 0, test.getFrequencyOf(3));
    }

    /**
     * This function tests the get of function DualImplementation bag, first Array and then LL
     */
    @Test
    public void testGet() {
        DualImplementationBag<String> test = new DualImplementationBag<String>(true);
        test.add("Hello");
        test.add("Hi");
        test.add("Bonjour");
        assertEquals("Checking for the index of 1", "Hello", test.get(0));
        assertEquals("Checking for the index of 1", "Hi", test.get(1));

        test.setUseArrayList(false);
        assertEquals("Checking for the index of 1", "Hello", test.get(0));
        assertEquals("Checking for the index of 1", "Hi", test.get(1));
    }
}
