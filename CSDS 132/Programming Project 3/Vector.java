/**
 * @author Bhoomika Khatri
 */

import java.lang.Math;

/**
 * A class that creates a vector, a line that starts at the origin and goes till another point
 */
public class Vector extends Calculus {
  
  /** 
   * the field that stores the x-coordinate of the Vector endpoint
   */
  private double x;
  
  /** 
   * the field that stores the y-coordinate of the Vector endpoint
   */
  private double y;
  
  /** 
   * the field that stores the z-coordinate of the Vector endpoint
   */
  private double z;
  
  /**
   * This is a constructor that makes a vector from three coordinates
   * @param x  the x coordinate
   * @param y  the y coordinate
   * @param z  the z coordinate
   */
  public Vector(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  /**
   * This is a constructor that makes a vector from a point
   * @param point  the point that the vector is made from
   */
  public Vector(Point point) {
    x = point.getX();
    y = point.getY();
    z = point.getZ();
  }
  
  /**
   * This is a constructor that makes a vector from a precious vector and a length
   * @param vector  the vector that directs where the vector is going
   * @param length  the length of the vector
   */
  public Vector(Vector vector, double length){
    double lengthOfVector = vector.magnitude();
    double scalarNumber = lengthOfVector/length;
    scale(vector,scalarNumber);
    x = scale(vector,scalarNumber).getX();
    y = scale(vector,scalarNumber).getY();
    z = scale(vector,scalarNumber).getZ();
  }
  
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
  
  /**
   * A method that returns the Vector in a string format
   */
  @Override
  public String toString() {
    return "<" + getX() + "," + getY() + "," + getZ() + ">";
  }
  
  
  /**
   * A method that returns if two points are equal, an overriden equals from Object
   * @param obj  the point that is being evaluates
   * @return equals  whether the two points are the same or not
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Vector) {
      Vector compareVector = (Vector)obj;
      if ((this.getX() == compareVector.getX()) && 
          (this.getY() == compareVector.getY()) && 
          (this.getZ() == compareVector.getZ())) {
        return true;
      }
      else {
        return false;
      }
    }
    return false;
  }
  
  /**
   * A method that returns the length of a vector starting at origin
   * @return the magnitude of the vector
   */
  public double magnitude() {
    return (Math.sqrt(
                      Math.pow(getX(),2.0) + 
                      Math.pow(getY(),2.0) + 
                      Math.pow(getZ(),2.0)));
  }
  
  /**
   * A method that displays the unit vector
   * @return Returns the unit vector
   */
  public Vector unitVector() {
    double unitVectorX = (getX()/this.magnitude());
    double unitVectorY = (getY()/this.magnitude());
    double unitVectorZ = (getZ()/this.magnitude());
    Vector unitVector = new Vector(unitVectorX,unitVectorY,unitVectorZ);
    return unitVector;
  }
  
  /**
   * A method that adds two vectors together
   * @param v1  the first vector that is added
   * @param v2  the second vector that is going to be added
   * @return the new sum vector
   */
  public static Vector sum(Vector v1, Vector v2) {
    Vector sumVector = new Vector(v1.getX()+v2.getX(),
                                  v1.getY()+v2.getY(),
                                  v1.getZ()+v2.getZ());
    return sumVector;
  } 
  
  /**
   * A method that scales the vector
   * @param vector  the vector that is being scaled
   * @param scalar  the amount the vector is being scaled by
   * @return the new scalar vector
   */
  public static Vector scale(Vector vector, double scalar) {
    Vector scalarVector = new Vector (vector.getX()*scalar,
                                      vector.getY()*scalar,
                                      vector.getZ()*scalar);
    return scalarVector;
  }
  
  /**
   * A method that returns the dot product of two vectors
   * @param v1  the first vector
   * @param v2  the second vector
   * @return a double that represents the result of the dot product of two vectors
   */
  public static double dotProduct(Vector v1, Vector v2){
    return (v1.getX()*v2.getX() + 
            v1.getY()*v2.getY() + 
            v1.getZ()*v2.getZ());
  }
  
  /**
   * A method that returns the cross product of the two vectors
   * @param v1  the first vector being multiplied
   * @param v2  the second vector being multiplied
   * @return a vector that shows the cross product of two vectors
   */
  public static Vector crossProduct(Vector v1, Vector v2) {
    Vector vectorCrossProduct = new Vector((v1.getY()*v2.getZ()-(v1.getZ()*v2.getY())),
                                           (-(v1.getX()*v2.getZ()-(v1.getZ()*v2.getX()))),
                                            (v1.getX()*v2.getY()-(v1.getY()*v2.getX())));
    return vectorCrossProduct;
  }
  
  /**
   * A method that returns the angle between two vectors
   * @param v1  the first vector for measuring the angle
   * @param v2  the second vector for measuring the angle
   * @return the angle between the two vectors
   */
  public static double angle (Vector v1, Vector v2) {
    return Math.acos((dotProduct(v1,v2)/(v1.magnitude()*v2.magnitude())));
  }
  
  /**
   * A method that returns whether two vectors are orthogonal
   * @param v1 the first angle being looked at
   * @param v2 the second angle being analyzed
   * @return if the vectors are/are not orthonogal
   */
  public static boolean isOrthogonal(Vector v1, Vector v2){
    return (dotProduct(v1,v2) == 0);
  }
  
  /**
   * A method that returns whether two vectors are parallel
   * @param v1 the first vector being looked at
   * @param v2 the second vector being looked at
   * @return if the vectors are/are not parallel
   */
  public static boolean isParallel(Vector v1, Vector v2) {
    return (angle(v1,v2) == 0 || angle(v1,v2) == 180);
  }
}
