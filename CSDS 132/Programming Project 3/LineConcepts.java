/**
 * @author Bhoomika Khatri
 */

/**
 * An abstract class that creates an overarching class for all line concepts
 */
public abstract class LineConcepts extends Calculus {
  
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
   * the constructor
   * @param p1  the first point used to construct the line
   * @param p2  the second point used to construct the line
   */
  public LineConcepts (PointConcepts p1, PointConcepts p2) {
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
  
  public LineConcepts(PointConcepts p1, Vector v) {
    p1X = p1.getX();
    p2X = v.getX();
    p1Y = p1.getY();
    p2Y = v.getY();
    p1Z = p1.getZ();
    p2Z = v.getZ();
  }
}