/**
 * @author Bhoomika Khatri
 */

/**
 * A class to represent the array of shuffled dominos
 */
import java.util.ArrayList;
import java.util.*;

public class DominoArray extends Domino {
  
  /** 
   * A field that stores the first value of the domino 
   */
  private int dominoValue1;
  
  /**
   * A field that stores the second value of the domino
   */
  private int dominoValue2;
  
  /**
   * A field that stores what domino is being used in the Mexican Train 
   */
  private int dominoValueForTrain;
  
  /**
   * A field that stores the Dominos in a linked list 
   */
  LinkedList<Domino> linkedListDominos = new LinkedList<Domino>(); 
  
  /**
   * A field that stores the list of dominoes in an Array list
   */
  private ArrayList<Domino> arrayOfDominos = new ArrayList<Domino>();
  
  /**
   * the constructor
   * @param dominoValue1  the first (back) domino's element
   * @param dominoValue2  the second (front) domino's element
   * @param dominoValueForTrain  the starting domino value
   */
  public DominoArray(int dominoValue1, int dominoValue2, int dominoValueForTrain) {
    super(dominoValue1, dominoValue2);
    this.dominoValueForTrain = dominoValueForTrain;
  }
  
  public LinkedList<Domino> createArrayList() {
    int d1 = 0;
    while (d1 < 10) {
      for (int d2 = 9; d2 > -1; d2--) {
        if (d1 == dominoValueForTrain && d2 == dominoValueForTrain) {
        }
        else 
          arrayOfDominos.add(new Domino(d1,d2));
      }
      d1++;
      for (int d2 = 9; d2 > 0; d2--) {
        if (d1 == dominoValueForTrain && d2 == dominoValueForTrain) {
        }
        else 
          arrayOfDominos.add(new Domino(d1,d2));
      }
      d1++;
      for (int d2 = 9; d2 > 1; d2--) {
        if (d1 == dominoValueForTrain && d2 == dominoValueForTrain) {
        }
        else 
          arrayOfDominos.add(new Domino(d1,d2));
      }
      d1++;
      for (int d2 = 9; d2 > 2; d2--) {
        if (d1 == dominoValueForTrain && d2 == dominoValueForTrain) {
        }
        else 
          arrayOfDominos.add(new Domino(d1,d2));
      }
      d1++;
      for (int d2 = 9; d2 > 3; d2--) {
        if (d1 == dominoValueForTrain && d2 == dominoValueForTrain) {
        }
        else 
          arrayOfDominos.add(new Domino(d1,d2));
      }
      d1++;
      for (int d2 = 9; d2 > 4; d2--) {
        if (d1 == dominoValueForTrain && d2 == dominoValueForTrain) {
        }
        else 
          arrayOfDominos.add(new Domino(d1,d2));
      }
      d1++;
      for (int d2 = 9; d2 > 5; d2--) {
        if (d1 == dominoValueForTrain && d2 == dominoValueForTrain) {
        }
        else 
          arrayOfDominos.add(new Domino(d1,d2));
      }
      d1++;
      for (int d2 = 9; d2 > 6; d2--) {
        if (d1 == dominoValueForTrain && d2 == dominoValueForTrain) {
        }
        else 
          arrayOfDominos.add(new Domino(d1,d2));
      }
      d1++;
      for (int d2 = 9; d2 > 7; d2--) {
        if (d1 == dominoValueForTrain && d2 == dominoValueForTrain) {
        }
        else 
          arrayOfDominos.add(new Domino(d1,d2));
      }
      d1++;
      for (int d2 = 9; d2 > 8; d2--) {
        if (d1 == dominoValueForTrain && d2 == dominoValueForTrain) {
        }
        else 
          arrayOfDominos.add(new Domino(d1,d2));
      }
      d1++;
    }
    Collections.shuffle(arrayOfDominos);
    LinkedList<Domino> linkedListDominos = createLinkedListOfDominos(arrayOfDominos);
    System.out.println(linkedListDominos.length());
    return linkedListDominos;
    
  }
  
  public <E> LinkedList<E> createLinkedListOfDominos (ArrayList<E> arrayList) {
    LinkedList<E> tempLinkedList = new LinkedList<>();
    for (E d : arrayList) { 
      // Add each element into the lL 
      tempLinkedList.addToEnd(d); 
    }
    return tempLinkedList;
  } 
}
