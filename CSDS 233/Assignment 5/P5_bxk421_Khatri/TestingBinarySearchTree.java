import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestingBinarySearchTree {

    @Test
    public void testContains() {
        BinarySearchTree testBTC = new BinarySearchTree();
        testBTC.add(10);
        testBTC.add(5);
        testBTC.add(15);
        
        assertFalse(testBTC.contains(3));  // Nonexistent value
        assertFalse(testBTC.contains(12)); // Nonexistent value
        assertFalse(testBTC.contains(20));
        assertEquals(false, testBTC.contains(3));  // Value in left subtree
        assertEquals(true, testBTC.contains(10));  // Value in left subtree
        assertEquals(true, testBTC.contains(5)); // Value in right subtree
        assertEquals(true, testBTC.contains(15));
    }

    @Test
    public void testAdd(){
        BinarySearchTree testBTC = new BinarySearchTree();
        testBTC.add(1);
        testBTC.add(2);
        testBTC.add(3);
        
    }

    @Test
    public void testToString() {
        BinarySearchTree testBTC = new BinarySearchTree();
        testBTC.add(3);
        testBTC.add(1);
        testBTC.add(2);
        assertEquals("3 1 2", testBTC.toString());
        testBTC.add(4);
        testBTC.add(5);
        testBTC.add(9);
        assertEquals("3 1 2 4 5 9", testBTC.toString());
    }

    @Test
    public void testBFS() {
        BinarySearchTree testBTC = new BinarySearchTree();
        assertEquals("", testBTC.bfs());
        testBTC.add(10);
        assertEquals("10", testBTC.bfs());
        testBTC.add(5);
        testBTC.add(15);
        testBTC.add(3);
        testBTC.add(7);
        assertEquals("10 5 15 3 7", testBTC.bfs());
    }

    @Test
    public void testDelete() {
        BinarySearchTree testBTC = new BinarySearchTree();
        assertFalse(testBTC.delete(10));
        testBTC.add(10);
        assertTrue(testBTC.delete(10));
    }

    @Test
    public void testHeight() {
        BinarySearchTree testBTC = new BinarySearchTree();
        assertEquals(0, testBTC.height());
        testBTC.add(10);
        assertEquals(2, testBTC.height());
        testBTC.add(12);
        testBTC.add(8);
        testBTC.add(9);
        assertEquals(4, testBTC.height());
    }

    @Test
    public void testHasSum() {
        BinarySearchTree testBTC = new BinarySearchTree();
        assertFalse(testBTC.hasSum(10));

        testBTC.add(10);
        assertTrue(testBTC.hasSum(10));
        assertFalse(testBTC.hasSum(15));

        testBTC.add(5);
        testBTC.add(15);
        testBTC.add(3);
        testBTC.add(7);
        testBTC.add(13);
        testBTC.add(20);
        assertTrue(testBTC.hasSum(18));
        assertFalse(testBTC.hasSum(25));
    }

    @Test
    public void testIsSymmetrical() {
        int[] tree = {};
        assertTrue(BinarySearchTree.isSymmetrical(tree));
        int[] tree0 = {1};
        assertTrue(BinarySearchTree.isSymmetrical(tree0));
        int[] tree1 = {1, 2, 2, 3, 4, 4, 3};
        assertEquals(false, BinarySearchTree.isSymmetrical(tree1));
        int[] tree3 = {1, 2, 2, -1, 3, -1, 3};
        assertEquals(false, BinarySearchTree.isSymmetrical(tree3));
    }


}