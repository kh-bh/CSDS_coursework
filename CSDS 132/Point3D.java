/*
 * Bhoomika Khatri
 **/

public class Point3D extends Point2D{
  
  /** 
   * the fields that store the coordinates of the point
   */
  double x;
  double y;
  double z;
  
  /**
   * the constructor
   * @param x  the x coordinate of the point
   * @param y  the y coordinate of the point
   * @param z  the z coordinate of the point
   */
  public Point3D (double x, double y, double z) {
    super(x,y);
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  /**
   * A method that returns what x-value the point is at
   */
  public double getX() {
    return x;
  }
  
  /**
   * A method that returns what y-value the point is at
   */
  public double getY(){
    return y;
  }
  
  /**
   * A method that returns what z-value the point is at
   */
  public double getZ(){
    return z;
  }
  
  /**
   * A method that returns the point in a string format
   */
  @Override
  public String toString() {
    return "(" + getX() + "," + getY() + "," + getZ() + ")";
  }
}

