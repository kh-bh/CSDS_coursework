/*
 * @author Bhoomika Khatri
 * Test cases for calculus
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestCalculus {
  
  /**
   * A test case that makes sure that the x coordinate is successfully recived from Point 2d
   */
  @Test
  public void testPoint2DGetX () {
    Point2D point = new Point2D(1.0,2.0);
    assertEquals("Checking the x-coordinate",1.0, point.getX(),2D);
  }
  
  /**
   * A test case that makes sure that the y coordinate is successfully recived from Point 2d
   */
  @Test
  public void testPoint2DGetY() {
    Point2D point = new Point2D(1.0,2.0);
    assertEquals("Checking the y-coordinate",2.0, point.getY(),2D);
  }
  
  /**
   * A test case that makes sure that the z coordinate is 0 in Point 2d
   */
  @Test
  public void testPoint2DGetZ() {
    Point2D point = new Point2D(1.0,2.0);
    assertEquals("Checking the z-coordinate",0.0, point.getZ(),2D);
  }
   /** 
    * A test case that makes sure that the point2d is printed in the correct format
    */
  @Test
  public void testPoint2DToString() {
    Point2D point = new Point2D(1.0,2.0);
    assertEquals("Checking the string depiction of Point2D","(1.0,2.0)", point.toString());
  }
  
  /**
   * A test case that makes sure that the point 2d can be accurately compared
   */
  @Test
  public void testPoint2DEquals() {
    Point2D p1 = new Point2D(1.0,2.0);
    Point2D p2 = new Point2D(1.0,2.0);
    Point2D p3 = new Point2D(2.0,2.0);
    assertEquals("Checking the same point, different name", true, p1.equals(p2)); // Test the same point
    assertEquals("Checking the same point", true, p2.equals(p2)); // Test the same point, same name
    assertEquals("Checking two different points", false, p3.equals(p2)); // Test different points
  }
  
  /**
   * A test case that makes sure that the distance between two points is correct
   */
  @Test
  public void testPoint2DDistance(){
    Point p1 = new Point(1.0,2.0,2.0);
    Point2D p2 = new Point2D(1.0,2.0);
    Point2D p3 = new Point2D(2.0,2.0);
    assertEquals("Checking two points next to each other by 1 unit", 1.0, Point2D.distance(p3,p2),2D);
    assertEquals("Checking the same point and its distance", 0.0, Point2D.distance(p3,p3),2D);
    assertEquals("Checking a point and a 2d point and its distance", 2.0, Point2D.distance(p1,p2),2D);
  }
  
  /**
   * A test case that makes sure that the x coordinate is successfully recived from Point
   */ 
  @Test
  public void testPointGetX() {
    Point point = new Point(1.0,2.0,3.0);
    assertEquals("Checking the x-coordinate", 1.0, point.getX(),0D);
  }
  
  /**
   * A test case that makes sure that the y coordinate is successfully recived from Point
   */
  @Test
  public void testPointGetY() {
    Point point = new Point(1.0,2.0,3.0);
    assertEquals("Checking the y-coordinate",2.0, point.getY(),0D);
  }
  
  /**
   * A test case that makes sure that the z coordinate is successfully recived from Point
   */
  @Test
  public void testPointGetZ() {
    Point point = new Point(1.0,2.0,3.0);
    assertEquals("Checking the z-coordinate",3.0, point.getZ(),0D);
  }
  
  /**
   * A test case that makes sure that point is printed appropriately
   */
  @Test
  public void testPointToString() {
    Point point = new Point(1.0,2.0,3.0);
    assertEquals("Checking the string depiction of Point","(1.0,2.0,3.0)", point.toString());
  }
  
  /** 
   * A test case that makes sure that the 3d points can be compared to each others
   */
  @Test
  public void testPointEquals() {
    Point p1 = new Point(1.0,2.0,3.0);
    Point p2 = new Point(1.0,2.0,3.0);
    Point p3 = new Point(1.0,2.0,0.0);
    Point2D p4 = new Point2D(1.0,2.0);
    assertEquals("Checking the same exact point", true, p1.equals(p1)); // Tests the same point
    assertEquals("Checking the same point in value", true, p1.equals(p2)); // Tests two differently named, same numbers points
    assertEquals("Checking two different points", false, p2.equals(p3)); // Tests two different points
    assertEquals("Checking the same point that are the same but of different types", true, p3.equals(p4)); // Tests the same points, one of type point2d and one of point
    assertEquals("Checking two different points of two types", false, p4.equals(p2)); // Tests two different points, one of type point2d and one of point
  }
  
  /**
   * A test case that makes sure that the point's distance can be calulated
   */
  @Test
  public void testPointDistance(){
    Point p1 = new Point(1.0,2.0,3.0);
    Point p2 = new Point(1.0,2.0,3.0);
    Point p3 = new Point(1.0,2.0,0.0);
    Point2D p4 = new Point2D(1.0,2.0);
    assertEquals("Checking the distance between the same point", 0.0, Point.distance(p1,p2),2D);
    assertEquals("Checking the distance between two diff points", 3.0, Point.distance(p2,p3),2D);
    assertEquals("Checking the distance between the same point, 2d and point", 0.0, Point.distance(p3,p3),2D);
    assertEquals("Checking the distance between 2 points, 2d and point", 3.0, Point.distance(p2,p4),2D);
  }
  
  /**
   * A test case that makes sure the toString method works for Line2D
   */
  @Test
  public void testToStringLine2D(){
    Point2D p1 = new Point2D(1.0,2.0);
    Point2D p2 = new Point2D(2.0,3.0);
    Point2D p3 = new Point2D(2.0,5.0);
    Point2D p4 = new Point2D(5.0,-13.0);
    Line2D li1 = new Line2D(p1,p2);
    Line2D li2 = new Line2D(p2,p3);
    Line2D li3 = new Line2D(p3,p4);
    assertEquals("Checking toString", "y = 1.0x + 1.0", li1.toString());
    assertEquals("Checking toString vert", "x = 2.0", li2.toString());
    assertEquals("Checking toString m-", "y = -6.0x - -18.0", li3.toString()); 
  }
  
  /**
   * A test case for equals in Line 2d
   */
  @Test
  public void testEqualsLine2D() {
    Point2D p1 = new Point2D(1.0,2.0);
    Point2D p2 = new Point2D(2.0,3.0);
    Point2D p3 = new Point2D(2.0,5.0);
    Line2D li1 = new Line2D(p1,p2);
    Line2D li2 = new Line2D(p1,p2);
    Line2D li3 = new Line2D(p2,p3);
    assertEquals ("Checking two line-same", true, li1.equals(li2));
    assertEquals ("Checking two lines-diff", false, li1.equals(li3)); 
  }
  
  /**
   * A test case for whether two lines are parallel
   */
  @Test
  public void testIsParallel() {
    Point2D p1 = new Point2D(1.0,2.0);
    Point2D p2 = new Point2D(2.0,3.0);
    Point2D p3 = new Point2D(2.0,5.0);
    Line2D li1 = new Line2D(p1,p2);
    Line2D li2 = new Line2D(p1,p2);
    Line2D li3 = new Line2D(p2,p3);
    assertEquals("Checking if two lines are parallel - same", true, Line2D.isParallel(li1,li2));
    assertEquals("Checking if two lines are parallel - diff", false, Line2D.isParallel(li1,li3));
  }
  
  /**
   * A test that returns is a 3d line is equal
   */
  @Test
  public void testEqualsLine() {
    Point2D p2 = new Point2D(2.0,3.0);
    Point2D p3 = new Point2D(2.0,5.0);
    Point2D p4 = new Point2D(1.0,9.0);
    Line l1 = new Line(p2,p3);
    Line l12 = new Line(p2,p3);
    Line l2 = new Line(p3,p4);
    assertEquals("Checking if two lines are the same", true, l1.equals(l1));
    assertEquals("Checking if two lines are the same", true, l12.equals(l1));
    assertEquals("Checking if two lines are the same", false, l1.equals(l2));
  }
  
  /**
   * A test that returns a vector from a 3d line
   */
  @Test
  public void testgetVectorLine() {
    Point2D p2 = new Point2D(2.0,3.0);
    Point2D p3 = new Point2D(2.0,5.0);
    Line l1 = new Line(p2,p3);
    Vector v1 = new Vector (0.0,0.0,0.0);
    //assertEquals(v1, l1.getVector());
  }
  
  /** 
   * A test that returns whether the line is parallel
   */
  @Test
  public void testisParallelLine() {
    Point2D p2 = new Point2D(2.0,3.0);
    Point2D p3 = new Point2D(2.0,5.0);
    Line l1 = new Line(p2,p3);
    assertEquals(false, Line.isParallel(l1,l1));
  }
    
  /**
   * A test case for the toString method for Vector
   */
  @Test
  public void testToStringVector() {
    Vector v1 = new Vector(3.0,5.0,-1.0);
    assertEquals("Checking the toString method for vectors", "<3.0,5.0,-1.0>", v1.toString());
  }
  
  /**
   * A test case that checks if two vectors are the same
   */
  @Test
  public void testEqualsVector() {
    Vector v1 = new Vector(3.0,5.0,-1.0);
    Vector v2 = new Vector(2.0,3.0,1.0);
    Vector v3 = new Vector(3.0,5.0,-1.0);
    assertEquals("Checking the equals method for vectors", true, v1.equals(v1));
    assertEquals("Checking the equals method for vectors", false, v1.equals(v2));
    assertEquals("Checking the equals method for vectors", true, v1.equals(v3));
  }
  
  /**
   * A test case that checks the magnitude of a vector
   */
  @Test
  public void testMagnitude(){
    Vector v = new Vector(0.0,0.0,1.0);
    Vector v1 = new Vector(0.0,1.0,0.0);
    Vector v2 = new Vector(1.0,0.0,0.0);
    assertEquals("Checks if the magnitude works", 1.0, v.magnitude(),2D);
    assertEquals("Checks if the magnitude works", 1.0, v1.magnitude(),2D);
    assertEquals("Checks if the magnitude works", 1.0, v2.magnitude(),2D);
  }
  
  /**
   * A test case that returns the sum of a vector
   */
  @Test
  public void testSum(){
    Vector v = new Vector(1.0,0.0,1.0);
    Vector v1 = new Vector(0.0,1.0,0.0);
    Vector v2 = new Vector(1.0,1.0,1.0);
    assertEquals(v2, Vector.sum(v,v1));
  }
  
  /**
   * A test case that checks the scale of a vector
   */
  @Test 
  public void testScale() {
    Vector v = new Vector(0.0,0.0,1.0);
    Vector v1 = new Vector(0.0,1.0,0.0);
    Vector v2 = new Vector(1.0,0.0,0.0);
    Vector vt = new Vector(0.0,0.0,2.0);
    Vector v1t = new Vector(0.0,2.0,0.0);
    Vector v2t = new Vector(2.0,0.0,0.0);
    assertEquals(vt, Vector.scale(v,2.0)); // Tests the scale on the Z coordinate
    assertEquals(v1t, Vector.scale(v1,2.0)); // Tests the scale on the Y coordinate
    assertEquals(v2t, Vector.scale(v2,2.0)); // Tests the scale on the X coordinate
  }
  
  /**
   * A test case that checks dot product
   */
  @Test
  public void testDotProduct() {
    Vector v1 = new Vector(1.0,2.0,3.0);
    Vector v2 = new Vector(4.0,5.0,6.0);
    assertEquals(32.0, Vector.dotProduct(v1,v2),2D);
  }
  
  /**
   * A test case that test if the cross product will work
   */
  @Test 
  public void testCrossProduct() {
    Vector v1 = new Vector(1.0,2.0,3.0);
    Vector v2 = new Vector(4.0,5.0,6.0);
    Vector v3 = new Vector(2*6-3*5,-(1*6-3*4),1*5-2*4);
    assertEquals(v3, Vector.crossProduct(v1,v2));
  }
  
  /** 
   * A test case that tests if the angle works
   */
  @Test
  public void testAngle() {
    Vector v1 = new Vector(1.0,2.0,3.0);
    Vector v2 = new Vector(3.0,-2.0,1.0);
    Vector v3 = new Vector(-1.0,-2.0,3.0);
    assertEquals(1.42,Vector.angle(v1,v2),2D); //Test for almost opposite angle
    assertEquals(0.00,Vector.angle(v1,v1),2D); // Test for the same angle
    assertEquals(1.28, Vector.angle(v1,v3),2D); //Test for opposite angle
  }
  
  /**
   * A test that tests if two vectors are orthogonal
   */
  @Test
  public void testOrthogonal() {
    Vector v1 = new Vector(1.0,2.0,3.0);
    Vector v2 = new Vector(3.0,-2.0,1.0);
    Vector v3 = new Vector(2.0,18.0,0.0);
    Vector v4 = new Vector(1.5,-.666666,0.0);
    assertEquals(false, Vector.isOrthogonal(v1,v2));
    assertEquals(true,Vector.isOrthogonal(v3,v4));
  }
  
  /**
   * A test that tests if two vectors are parallel
   */
  @Test
  public void testParallel() {
    Vector v1 = new Vector(1.0,2.0,3.0);
    Vector v2 = new Vector(3.0,-2.0,1.0);
    assertEquals(false, Vector.isParallel(v1,v2));
  }
  
  /**
   * A test that tests if a plane's toString method works
   */
  @Test
  public void testVectorToString(){
    Point p1 = new Point(1,2,3);
    Vector v1 = new Vector (5,6,7);
    Plane plane = new Plane(p1,v1);
    assertEquals("5.0x + 6.0y + 7.0z + -38.0 = 0", plane.toString());
  }
  
  /**
   * A test that tests if a plane is equal to another plane
   */
  @Test
  public void testVectorEquals(){
    Point p1 = new Point(1,2,3);
    Vector v1 = new Vector (5,6,7);
    Vector v2 = new Vector (1,2,3);
    Plane plane = new Plane(p1,v1);
    Plane plane1 = new Plane(p1,v2);
    assertEquals(false, plane.equals(plane1)); // Test for different -- working
    assertEquals(true, plane.equals(plane)); // Test for the same -- not working
  }
}