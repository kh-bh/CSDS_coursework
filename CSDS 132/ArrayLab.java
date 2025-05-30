/**
 * Michelle Kim
 * Bhoomika Khatri
 * A collection of methods related to int[].
 */
public class ArrayLab {

  /**
   * Return whether k is in array[start..end].
   * Precondition: the length of array is at least end+1
   * @param array the array of int values.
   * @param start the index of the start of the range to be searched.
   * @param end the index of the end of the range to be searched.
   * @param k the number to search for.
   * @return true if k is in array[start..end]
   */
  public static boolean contains(int[] array, int start, int end, int k) {
    for (int index = start; index <= end; index++) {
      if (array[index] == k) {
          return true;
      }
    }
    return false;
  }

  /**
   * Create a String that has the contents of list[0..n-1] on one line, 
   * separated by spaces and surrounded by { and }.
   * @param list the sorted array.
   * @param n the number of items in list to put in the string.
   * @return  the first n elements of the array, separated by spaces, and surrounded by { and }.
   */
  public static String arrayToString(int[] list, int n) {
    StringBuilder builder = new StringBuilder();
    builder.append("{");
    for (int index = 0; index < n; index++) {
      builder.append(list[index]);
      if ((index+1) < n) {
        builder.append(" ");
      }
    }
    builder.append("}");
    System.out.println(builder.toString());
    return builder.toString();
    
  }

  /**
   * Remove k from list[0..n-1].
   * Precondition: list[0..n-1] is sorted, and k is an element of list[0..n-1].
   * Postcondition: list[0..n-2] is sorted.
   * @param list the sorted array.
   * @param n the number of items in list.
   * @param k the number to remove from list.
   */
  public static void remove(int[] list, int n, int k) {
    for (int index = 0; index < n; index++) {
      
      if (index < k) {
        System.out.println("a");
      }
      else if (index == k) {
        System.out.println("b");
      }
      else {
        System.out.println("c");
      }
    }
  }

  /**
   * Insert k into list where it belongs.
   * Precondition: list[0..n-1] is sorted, and list[n] is unused.
   * Postcondition: list[0..n] is sorted.
   * @param list the sorted array.
   * @param n the number of items in list.
   * @param k the number to add to list.
   */
  public static void insert(int[] list, int n, int k) {
  }
}
