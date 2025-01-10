/** A program that takes input from the command line and prints their average */

public class Averager {
  
  /**
   * A method that takes an array of strings and returns an average in interger
   * @param values the array of string representing numbers
   * @return the average of the numbers entered
   */
  public static int average(String[] values) throws NumberFormatException, BadDataException{
    int total = 0;
    int count = 0;
    for (String val : values) {
      try {
        total += Integer.parseInt(val);
      }
      catch (NumberFormatException ex) {
        try {
          total += (int)(Double.parseDouble(val));
          count ++;
        }
        catch (NumberFormatException ex2) {
          //ignore the value because it is not an int or a double
        }
      }
    }
    if (count == values.length) 
      return total / values.length;
    else
      throw new BadDataException(total/count);
  }
  
  /**
   * Runs the program. Averages a list of numbers
   * @param args a list of numbers entered by user
   */
  public static void main(String[] args) {
    try {
      int average = average(args);
      System.out.println("The average of the numbers is " + average);
    }
    catch (ArithmeticException ex) {
      System.out.println("You did not enter any numbers to average");
    }
    catch (BadDataException ex) {
      System.out.println("You entered non-numbers! The average of the numbers entered is " + ex.getResult());
    }
  }
}