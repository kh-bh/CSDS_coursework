/**
 * @author Bhoomika Khatri
 */

/*
 * A class that creates a 3 dimensional line
 */
public class Line extends LineConcepts {
  
  /** 
   * the field that stores the x-coordinate of the first point
   */
  private double p1X;
  
  /** 
   * the field that stores the x-coordinate of the second point
   */
  private double p2X;
  
  /** 
   * the field that stores the y-coordinate of the first point
   */
  private double p1Y;
  
  /** 
   * the field that stores the y-coordinate of the second point
   */
  private double p2Y;
  
  /**
   * the field that stores the z-coordinate of the first point
   */
  private double p1Z;
  
  /**
   * the field that stores the z-coordinate of the second point
   */
  private double p2Z;
  
  /**
   * the field that store the x slope
   */
  private double mX;
  
  /**
   * the field that store the y slope
   */
  private double mY;
  
  /**
   * the field that store the z slope
   */
  private double mZ;
  
  /**
   * the constructor
   * @param p1  the first point used to construct the line
   * @param p2  the second point used to construct the line
   */
  public Line (PointConcepts p1, PointConcepts p2) {
    super(p1,p2);
    this.p1X = p1.getX();
    this.p2X = p2.getX();
    this.p1Y = p1.getY();
    this.p2Y = p2.getY();
    this.p1Z = 0.0;
    this.p2Z = 0.0;
    if (p1 instanceof Point)
      this.p1Z = p1Z;
    if (p2 instanceof Point)
      this.p2Z = p2Z;
  }
  
  /**
   * the constructor
   * @param p1  the point the vector runs through
   * @param v  the vector that the line runs parallel to
   */
  public Line(PointConcepts p1, Vector v) {
    super(p1,v);
    p1X = p1.getX();
    p2X = v.getX();
  }
  
  /** 
   * A method that gets the X slope of a line 
   * @return mX the slope of x in parametric
   */
  public double getXSlope() {
    mX = p1X-p2X;
    return mX;
  }
  
  /** 
   * A method that gets the Y slope of a line 
   * @return mY the slope of y in parametric
   */
  public double getYSlope() {
    mY = p1Y-p2Y;
    return mY;
  }
  
  /** 
   * A method that gets the Z slope of a line 
   * @return mZ the slope of z in parametric
   */
  public double getZSlope() {
    mZ = p1Z-p2Z;
    return mZ;
  }
  
  /**
   * the parametric equations that represent the line
   */
  public String toString() {
    String xString = "x = " + p1X + " + " + mX + "t";
    String yString = "y = " + p1Y + " + " + mY + "t";
    String zString = "z = " + p1Z + " + " + mZ + "t";
    return (xString + "\n" + yString + "\n" + zString);
  }
  
  /**
   * A method that writes over the equals method, finds if two lines are equal
   * @param obj  the line that is being evaluates
   * @return equals  whether the two lines are the same or not
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof LineConcepts) {
      Line compare = (Line)obj;
      if (this.getXSlope() == compare.getXSlope() && 
          this.getYSlope() == compare.getYSlope() && 
          this.getZSlope() == compare.getZSlope()) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  /**
   * A method that returns if two lines are parallel
   * @param l1  the first line being evaluated
   * @param l2  the second line being evaluated
   * @return whether the two lines are parallel or not
   */
  public static boolean isParallel(LineConcepts l1, LineConcepts l2){
    Line line1 = (Line)l1;
    Line line2 = (Line)l2;
    if (line1.getXSlope() == line2.getXSlope() &&
        line1.getYSlope() == line2.getYSlope() &&
        line1.getZSlope() == line2.getZSlope() &&
        line1.getX() != line2.getX()) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * A method that returns if two lines intersect
   * @param line1  the first line being evaluated
   * @param line2  the second line being evaluated
   * @return  whether the two lines are intersecting or not
   */
  public static PointConcepts intersection (LineConcepts line1, LineConcepts line2) {
    if (isParallel(line1,line2)) {
      return null;
    }
    else {
      if (line1 instanceof Line || line2 instanceof Line) {
        if (line1 instanceof Line) {
          Line l1 = (Line)line1;
        }
        if (line2 instanceof Line) {
          Line l2 = (Line)line2;
        } 
        PointConcepts p1int = new Point2D (1.0, 2.0);
        return (p1int);
      }
      else {
        Line2D l1 = (Line2D)line1;
        Line2D l2 = (Line2D)line2;
        double mInt1 = l1.getSlope();
        double mInt2 = l2.getSlope();
        double yInt1 = l1.getYint();
        double yInt2 = l2.getYint();
        double xCoordInt = (yInt2 - yInt1)/(mInt1 - mInt2);
        double yCoordInt = mInt1*xCoordInt + yInt1;
        PointConcepts p1int = new Point2D (xCoordInt, yCoordInt);
        return (p1int);
      }
    }
  }
}
