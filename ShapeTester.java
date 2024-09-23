public class ShapeTester {


  /* THIS CODE WAS MY OWN WORK , IT WAS WRITTEN WITHOUT CONSULTING
  CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
  Malia Walewski */

  // !!!Important!!!
  // All methods in this class should be declared "static"

  // A public method isLarger which takes as input two shapes
  // (a Circle first, then a Rectangle) and returns true if the area of
  // the circle is bigger than (or equal to) the area of the rectangle,
  // false otherwise.
  public static boolean isLarger(Circle shapeCircle, Rectangle shapeRectangle) {
    return shapeCircle.getArea() >= shapeRectangle.getArea();
  }

  // A public method longerPerim which takes as input
  // a Circle object followed by a Rectangle object and returns
  // the length of the perimeter of the longer of the two objects.
  public static double longerPerim(Circle shapeCircle, Rectangle shapeRectangle) {
    double circlePerim = shapeCircle.getCircumference();
    double rectanglePerim = shapeRectangle.getPerimeter();
      return Math.max(circlePerim, rectanglePerim);
  }

  // Another version of the public method longerPerim which has the
  // same name and functionality but it takes as input a Rectangle object
  // followed by a Circle object. The method also returns the length of
  // the perimeter of the longer of the two objects.
  public static double longerPerim(Rectangle shapeRectangle, Circle shapeCircle) {
    double rectanglePerim = shapeRectangle.getPerimeter();
    double circlePerim = shapeCircle.getCircumference();
      return Math.max(circlePerim, rectanglePerim);
  }

  // A public method largerArea which takes as input
  // a Circle object followed by a Rectangle object and returns
  // the area of the larger of the two objects.
  public static double largerArea(Circle shapeCircle, Rectangle shapeRectangle) {
    double circleArea = shapeCircle.getArea();
    double rectangleArea = shapeRectangle.getArea();
    return Math.max(circleArea, rectangleArea);
  }

  // Another version of the public method largerArea which has the
  // same name and functionality but it takes as input a Rectangle object
  // followed by a Circle object.
  public static double largerArea(Rectangle shapeRectangle, Circle shapeCircle) {
    double rectangleArea = shapeRectangle.getArea();
    double circleArea = shapeCircle.getArea();
    return Math.max(circleArea, rectangleArea);
  }

  // A public method containsCenter which takes as input two circles,
  // and returns true if the first circle contains the center of the second circle,
  // false otherwise.
  public static boolean containsCenter(Circle circle1, Circle circle2) {
    double[] circle2Center = circle2.getCenter();
    double circle2_X = circle2Center[0];
    double circle2_Y = circle2Center[1];
    
    return circle1.containsPoint(circle2_X, circle2_Y);
  }

  public static void main(String[] args) {
    // Create Circle and Rectangle objects
    Circle circleA = new Circle(5); // Circle with radius 5
    Circle circleB = new Circle(3, 2, 2); // Circle with radius 3 centered at (2, 2)
    Rectangle rectangleA = new Rectangle(4, 6, 0, 0); // Rectangle with length 4 and height 6

    // Test isLarger method
    System.out.println("Is Circle A's area larger than Rectangle A's area? " + ShapeTester.isLarger(circleA, rectangleA));

    // Test longerPerim method (Circle first, Rectangle second)
    System.out.println("Longer perimeter (Circle A, Rectangle A): " + ShapeTester.longerPerim(circleA, rectangleA));

    // Test longerPerim method (Rectangle first, Circle second)
    System.out.println("Longer perimeter (Rectangle A, Circle A): " + ShapeTester.longerPerim(rectangleA, circleA));

    // Test largerArea method (Circle first, Rectangle second)
    System.out.println("Larger area (Circle A, Rectangle A): " + ShapeTester.largerArea(circleA, rectangleA));

    // Test largerArea method (Rectangle first, Circle second)
    System.out.println("Larger area (Rectangle A, Circle A): " + ShapeTester.largerArea(rectangleA, circleA));

    // Test containsCenter method
    System.out.println("Does Circle A contain the center of Circle B? " + ShapeTester.containsCenter(circleA, circleB));
}

}
