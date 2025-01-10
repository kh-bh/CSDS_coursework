import java.util.Random;

public class RandomQuickSort{
    
    public static <T extends Comparable<? super T>> void quickSort(T[] nums, int first, int last) {

        // This if statement checks to see if the first value is less than the last value
        if (first < last) {
            int pivotIndex = partition(nums, first, last);
            quickSort(nums, first, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, last);
        }
    }

    private static <T extends Comparable<? super T>> int partition(T[] nums, int first, int last) {
        Random rand = new Random();
        // This will pick the number that should be used for the random number
        int pivotIndex = first + rand.nextInt(last - first + 1); 
        //This will make the pivot value be the pivot index item
        T pivotValue = nums[pivotIndex];

        // This uses swapNumbers to move the pivot number to the end
        swapNumbers(nums, pivotIndex, last);
        int storeIndex = first;

        //This loop will do the actual quicksort, where one side will be sorted and then the other side is sorted
        for (int i = first; i < last; i++) {
            /*
            * This looks at all the numbers and compares them to the pivot value 
            * (Can't use equals because it's T)
            */ 
            if (nums[i].compareTo(pivotValue) < 0) {
                swapNumbers(nums, i, storeIndex);
                storeIndex++;
            }
        }
        swapNumbers(nums, storeIndex, last); // Move pivot to its final place
        return storeIndex;
    }

    /*
     * This method is used to swap two object's places
     */
    private static <T> void swapNumbers(T[] arrayofObjects, int originalIndex, int switchIndex) {
        T temp = arrayofObjects[originalIndex];
        arrayofObjects[originalIndex] = arrayofObjects[switchIndex];
        arrayofObjects[switchIndex] = temp;
    }

    public  <T> String toString(T[] makeToStringArray) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int row = 0; row < makeToStringArray.length; row++) {
            builder.append(makeToStringArray[row]);
            builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }
   

}