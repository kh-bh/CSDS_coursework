/**
 * @author Bhoomika Khatri
 */

/**
 * An class that creates a plan
 */
public class Plane extends Calculus {
  
  /** 
   * the field that stores the x coefficient of the plane equation
   */
  private double xCoef;
  
  /** 
   * the field that stores the y coefficient of the plane equation
   */
  private double yCoef;
  
  /** 
   * the field that stores the z coefficient of the plane equation
   */
  private double zCoef;
  
  /** 
   * the field that stores the constant of the plane equation
   */
  private double dConst;
  
  /**
   * A constructor that creates a plane with a point and a vector
   * @param point  the point
   * @param vector  the normal vector
   */
  public Plane(Point point, Vector vector) {
    xCoef = vector.getX();
    yCoef = vector.getY();
    zCoef = vector.getZ();
    dConst = - (xCoef*point.getX() + 
                yCoef*point.getY() + 
                zCoef*point.getZ());
  }
  
  /**
   * A constructor that creates a plane with 3 points
   * @param p1  the first point for input
   * @param p2  the second point for input
   * @param p3  the third point for input
   */
  public Plane(Point p1, Point p2, Point p3) {
    Vector coplanarVector1 = new Vector(p1.getX()-p2.getX(),
                                        p1.getY()-p2.getY(),
                                        p1.getZ()-p2.getZ());
    Vector coplanarVector2 = new Vector(p2.getX()-p3.getX(),
                                        p2.getY()-p3.getY(),
                                        p2.getZ()-p3.getZ());
    xCoef = Vector.crossProduct(coplanarVector1,coplanarVector2).getX();
    yCoef = Vector.crossProduct(coplanarVector1,coplanarVector2).getY();
    zCoef = Vector.crossProduct(coplanarVector1,coplanarVector2).getZ();
    dConst = - (xCoef*p1.getX() + 
                yCoef*p1.getY() + 
                zCoef*p1.getZ()); 
  }
  
  public Vector getNormal(){
    return new Vector(xCoef,yCoef,zCoef);
  }
  
  /** 
   * A method that returns a string verion of the location of the point, an overriden toString from Object
   */
  @Override
  public String toString() {
    return xCoef + "x + " + yCoef + "y + " + zCoef + "z + " + dConst + " = 0";
  }
  
  /**
   * A method that returns if two Planes are equal, an overriden equals from Object
   * @param obj  the Plane that is being evaluates
   * @return equals  whether the two Planes are the same or not
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Plane) {
      Plane comparePlane = (Plane)obj;
      if (this.getNormal().getX() == comparePlane.getNormal().getY() && 
          this.getNormal().getY() == comparePlane.getNormal().getY() &&
          this.getNormal().getZ() == comparePlane.getNormal().getZ()){
        return true;
      }
      else {
        return false;
      }
    }
    return false;
  }
  
  /**
   * A method that returns if the plane contains a given 3d point
   * @param point  the point being assesed to see if it is in the plane
   * @return contains  if the plane contains the point
   */
  public boolean contains(Point point) {
    if (dConst == -(xCoef*point.getX() + yCoef*point.getY() + zCoef*point.getZ())) {
      return true;
    }
    else {
      return false;
    }         
  }
  
  /**
   * A method that returns if two planes are parallel
   * @param p1  the first plane being assessed
   * @param p2  the second plane being assessed
   * @return isParallel if the two planes are parallel
   */
  public static boolean isParallel (Plane p1, Plane p2) {
    Vector p1Normal = p1.getNormal();
    Vector p2Normal = p2.getNormal();
    if (Vector.isParallel(p1Normal,p2Normal) == true) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * A method that returns if two planes are orthogonal
   * @param p1  the first plane being assessed
   * @param p2  the second plane being assessed
   * @return if two planes are orthogonal
   */
  public static boolean isOrthogonal (Plane p1, Plane p2) {
    Vector p1Normal = p1.getNormal();
    Vector p2Normal = p2.getNormal();
    if (Vector.isOrthogonal(p1Normal,p2Normal) == true) {
      return true;
    }
    else {
      return false;
    }
  }
  
}
