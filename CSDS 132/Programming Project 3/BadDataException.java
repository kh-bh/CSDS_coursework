/**
 * An exception thrown if a computation produces a result, just not a good one
 */
public class BadDataException extends Exception {
  private int result;
  
  public BadDataException(int result) {
    this.result = result;
  }
  
  public int getResult() {
    return result;
  }
}