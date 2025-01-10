import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList; 

public class Assignment4TestingCase {

    @Test
    public void testFindMin() {
        Binary testBTC = new Binary();
        int[] numbers0 = {0,1,2,3,4,5,6,7,8};
        assertEquals(0,testBTC.findMin(numbers0));
        int[] numbers1 = {8,0,1,2,3,4,5,6,7};
        assertEquals(0,testBTC.findMin(numbers1));
        int[] numbers2 = {7,8,0,1,2,3,4,5,6};
        assertEquals(0,testBTC.findMin(numbers2));
        int[] numbers3 = {6,7,8,0,1,2,3,4,5};
        assertEquals(0,testBTC.findMin(numbers3));
        int[] numbers4 = {5,6,7,8,0,1,2,3,4};
        assertEquals(0,testBTC.findMin(numbers4));
        int[] numbers5 = {4,5,6,7,8,0,1,2,3};
        assertEquals(0,testBTC.findMin(numbers5));
        int[] numbers6 = {3,4,5,6,7,8,0,1,2};
        assertEquals(0,testBTC.findMin(numbers6));
        int[] numbers7 = {2,3,4,5,6,7,8,0,1};
        assertEquals(0,testBTC.findMin(numbers7));
        int[] numbers8 = {1,2,3,4,5,6,7,8,0};
        assertEquals(0,testBTC.findMin(numbers8));
        int[] numbers9 = {1,2,3,4,5,6,7,8,9,10};
        assertEquals(1,testBTC.findMin(numbers9));
    }

    @Test
    public void testQuickSort() {
        RandomQuickSort testQuickSort = new RandomQuickSort();
        int[]setToSort1 = {51,73,82,52,0,1,27,2,11,81};
        assertEquals("[51,52,73,82,0,1,27,2,11,81]",testQuickSort.toString(testQuickSort.quickSort(setToSort1,1,4)));
        int[] setToSort2 = {57,89,75,13,62,777,666,57,69,57,420,25,24};
        assertEquals("[13,57,62,69,75,89,777,666,57,69,57,420,25,24]",testQuickSort.toString(testQuickSort.quickSort(setToSort2,1,9)));
        assertEquals("[51,52,73,82,0,1,27,2,11,81]",testQuickSort.toString(testQuickSort.quickSort(setToSort1,8,9))); // Sort end of 1
        assertEquals("[13,57,62,69,75,89,777,666,57,69,57,420,25,24]",testQuickSort.toString(testQuickSort.quickSort(setToSort2,11,12))); //Sort end of 2
    }



    @Test
    public void testkClosest() {
        Solution testkClose = new Solution();
        int[][] testSet = {{223,9,3,4},{223,9,3,4}};


        assertEquals("[]",testkClose.toString(testkClose.kClosest(testSet,0)));
        assertEquals("[{223, 223}, {9, 9}, ]",testkClose.toString(testkClose.kClosest(testSet,2)));
        int[][] testSet1 = {{223,233,9,10},{223,233,3,4}};
        assertEquals("[{223, 223}, {233, 233}, {9, 3}, {10, 4}, ]",testkClose.toString(testkClose.kClosest(testSet1,4)));
    }
}