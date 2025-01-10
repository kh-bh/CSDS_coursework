/**
 * @author Bhoomika Khatri
 */

/**
 * A class that creates a 2 dimensional Line
 */
import java.lang.Math;
public class Line2D extends Line{
  
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
   * the field that stores the slope
   */
  private double m;
  
  /**
   * the field that store the y-int
   */
  private double yint;
  
  /**
   * the constructor
   * @param p1  the first point used to construct the line
   * @param p2  the second point used to construct the line
   */
  public Line2D (PointConcepts p1, PointConcepts p2) {
    super((Point2D)p1, (Point2D)p2);
    this.p1X = p1.getX();
    this.p2X = p2.getX();
    this.p1Y = p1.getY();
    this.p2Y = p2.getY();
  }
  
  public double getSlope() {
    m = (p1Y - p2Y)/(p1X - p2X);
    return m;
  }
  
  public double getYint() {
    m = this.getSlope();
    return (m*p1X + p1Y);
  }
  
  /**
   * A method that writes over toString to display the line correctly
   * @return  the string interpretation of the line
   */
  public String toString() {
    if ((p1X - p2X) != 0) {
      double m = (p1Y - p2Y)/(p1X - p2X);
      double constant = -(m*p1X - m*p1Y);
      if (constant > 0) {
        return ("y = " + m + "x + " + constant);
      }
      else if (constant < 0) {
        return ("y = " + m + "x - " + constant);
      }
      else {
        return ("y = " + m + "x");
      }
    }
    else {
      return ("x = " + p1X);
    }
  }
  
  /**
   * A method that writes over the equals method, finds if two lines are equal
   * @param obj  the line that is being evaluates
   * @return equals  whether the two lines are the same or not
   */
  @Override
  public boolean equals(Object obj) {
    if (obj instanceof LineConcepts) {
      Line2D compare = (Line2D)obj;
      double mOri = (p1Y - p2Y)/(p1X - p2X);
      double mComp = (compare.getSlope());
      if (mOri == mComp) {
        return true;
      }
      return false;
    }
    return false;
  }
  
  /**
   * A method that finds if two lines are parallel
   * @param line1  the first line being evaluated
   * @param line2  the second line being evaluated
   * @return isParalle if the line is parallel
   */
  public static boolean isParallel(LineConcepts line1, LineConcepts line2){
    double m1;
    double m2;
    if (line1 instanceof Line2D) {
      Line2D l1 = (Line2D)line1;
      m1 = l1.getSlope();
    }
    else {
      Line l1 = (Line)line1;
      m1 = 0.0;
    }
    if (line2 instanceof Line2D){
      Line2D l2 = (Line2D)line2;
      m2 = l2.getSlope();
    }
    else {
      Line l2 = (Line)line2;
      m2 = 0.0;
    }
    if (m1 == m2) {
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