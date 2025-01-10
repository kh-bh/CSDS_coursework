import javax.swing.JFrame;

/** A class that demonstrates methods that manipulate our linked list */
public class ListStuff {
  
  /**
   * Prints the contents of the list.
   * This method demonstrates how you can declare a generic in the header of the method,
   * and it demonstrates using an iterator to loop over the data in the list.
   * @param list the list we are printing the contents of
   */
  public static <T> void printList1(LinkedList<T> list) {
    LinkedListIterator<T> it = list.iterator();
    
    while (it.hasNext()) {
      System.out.print(it.next() + " ");
    }
    System.out.println();
  }
  
  /**
   * Prints the contents of the list.
   * This method demonstrates using the generic type wildcard ? to indicate that the generic type is not used.
   * The method also uses the iterator to loop over the data in the list.
   * @param list the list we are printing the contents of
   */
  public static void printList2(LinkedList<?> list) {
    LinkedListIterator<?> it = list.iterator();
    
    while (it.hasNext()) {
      System.out.print(it.next() + " ");
    }
    System.out.println();
  }
   
  /**
   * Prints the contents of the list.
   * This method demonstrates the "foreach" loop shortcut for Iterable types.
   * @param list the list we are printing the contents of
   */
  public static <T> void printList3(LinkedList<T> list) {
    for (T value : list)
      System.out.print(value + " ");
    System.out.println();
  }
  
  /**
   * Take a linked list of JFrame and display all the frames in the list.
   * @param list the list of JFrames to display
   */
  public static <T extends JFrame> void displayFrames(LinkedList<T> list) {
    for (JFrame j : list)
      j.setVisible(true);
  }
  
  /**
   * Version 2 to take a list of JFrame and display all the frames.
   * @param list the list of JFrames to display
   */
  public static void displayFrames2(LinkedList<? extends JFrame> list) {
    for (JFrame j : list)
      j.setVisible(true);
  }
}
    