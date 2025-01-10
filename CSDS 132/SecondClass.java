public class SecondClass extends FirstClass {
  
  // The variable that will be added to
  private int i = 0;
  
  // The variable that will be subtracted from
  private int j = 0;
  
  
  public void printIJ() {
    System.out.println(i + ": The count added");
    System.out.println(j + ": The count subtracted");
  }
  
  //Overriden Normal Method #1, now addition
  @Override
  public int addOne() {
    i++;
    return i;
  }
  
  // Overriden Normal Method #2, now subtraction
  @Override
  public int subtractOne() {
    j--;
    return j;
  }
}