/**
 * @auth Bhoomika Khatri
 */

/*
 * An abstract class that creates an overarching class for all point concepts
 */
public abstract class VectorConcepts extends Calculus {
  private double x;
  
  private double y;
  
  private double z;
  
  public VectorConcepts(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  public VectorConcepts(Point point) {
    x = point.getX();
    y = point.getY();
    z = point.getZ();
  }
  
  public VectorConcepts(Vector vector, double length){
    
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

  public double getY() {
    return y;
  }
  
  /**
  * A method that returns what z-value the point is at
  */
  public double getZ() {
    return z;
  }
  
  @Override
  public String toString() {
    return "<" + getX() + "," + getY() + "," + getZ() + ">";
  }
}