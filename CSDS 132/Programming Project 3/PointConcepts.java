/**
 * @author Bhoomika Khatri
 */

/*
 * An abstract class that creates an overarching class for all point concepts
 */
public abstract class PointConcepts extends Calculus {
  
  /**
   * A field that stores the x value
   */
  private double x;
  
  /**
   * A field that store the y value
   */
  private double y;
  
  /**
   * A field that store the z value
   */
  private double z;
  
  /**
  * A method that returns what x-value the point is at
  * @return the X value of the coordinate
  */
  public double getX() {
    return x;
  }
  
  /**
   * A method that returns what y-value the point is at
   * @return the Y value of the coordinate
   */

  public double getY() {
    return y;
  }
  
  /**
  * A method that returns what z-value the point is at
  * @return the Z value of the coordinate
  */
  public double getZ() {
    return z;
  }
  
  public PointConcepts(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
}