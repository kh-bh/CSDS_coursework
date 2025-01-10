/**
 * @author Bhoomika Khatri
 */

/**
 * A class to represent a domino and the function to rotate dominoes
 */
public class Domino {
  
  /** A field that stores the first value of the domino */
  private int dominoValue1;
  
  /** A field that stores the second value of the domino */
  private int dominoValue2;
  
  /**
   * the constructor
   * @param dominoValue1  the first domino's element
   * @param dominoValue2  the second domino's element 
   */
  public Domino(int dominoValue1, int dominoValue2) {
    this.dominoValue1 = dominoValue1;
    this.dominoValue2 = dominoValue2;
  }
  
  /**
   * A method that sets the first value of the domino
   * @param dominoValue1  the first domino value
   */
  protected void setDomino1 (int dominoValue1) {
    this.dominoValue1 = dominoValue1;
  }
  
  /** 
   * A method that gets the value of the first domino
   * @return The first domino value
   */
  protected int getDomino1() {
    return dominoValue1;
  }
  
  /**
   * A method that sets the second value of the domino
   * @param dominoValue2  the first domino value
   */
  protected void setDomino2 (int dominoValue2) {
    this.dominoValue2 = dominoValue2;
  }
  
  /** 
   * A method that gets the value of the second domino
   * @return The second domino value
   */
  protected int getDomino2() {
    return dominoValue2;
  }
  
  /**
   * A method that rotates the dominos
   * @return the rotated domino
   */
  protected Domino rotate() {
    int d2 = getDomino1();
    int d1 = getDomino2();
    return new Domino(d1,d2);
  }
  
  @Override
  public String toString() {
    return "[" + getDomino1() + "|" + getDomino2() + "]";
  }
}