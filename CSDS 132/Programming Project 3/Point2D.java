/**
 * @author Bhoomika Khatri
 */

/**
 * A class that creates a 2 dimensional point (x,y)
 */
import java.lang.Math;
public class Point2D extends Point {
  
  /** 
   * the field that stores the x-coordinate of the point
   */
  private double x;
  
  /** 
   * the field that stores the y-coordinate of the point
   */
  private double y;
  
  /**
   * the constructor
   * @param x  the x coordinate of the point
   * @param y  the y coordinate of the point
   */
  public Point2D (double x, double y) {
    super(x,y,0.0);
  }
  
  /** 
   * A method that returns a string verion of the location of the point, an overriden toString from Object
   */
  @Override
  public String toString() {
    return "(" + getX() + "," + getY() + ")";
  }
}