// This class represents some circle shape
public class Circle {

    /* THIS CODE WAS MY OWN WORK , IT WAS WRITTEN WITHOUT CONSULTING
    CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
    Malia Walewski */
 

    // Instance variables (data members) of class Circle
    protected double radius; // the radius of the circle
    protected double x; // the x coordinate the circle's center
    protected double y; // the y coordinate the circle's center

    // The default constructor with no argument
    public Circle(){
      // Initializing the values of the instance variables
      radius = 1.0;
      x = 0.0;
      y = 0.0;
    }

    // Second constructor with given radius, but origin default
    public Circle(double radius) {
      this.radius = radius;
      x = 0.0;
      y = 0.0;
    }

    // Overloaded constructor
    // Parameter r should be the radius length
    // Parameter ex should be the x coordinate
    // Parameter why should be the y coordinate
    public Circle(double r, double x, double y) {
        this.radius = r; 
        this.x = x;
        this.y = y;
    }

    // A public getter method for retrieving the radius
    public double getRadius() {
        return radius;
    }

    // A public getter method for retrieving the center coordinates
    public double[] getCenter() {
        double[] c = {this.x, this.y};
        return c;
    }

    // A public getter method for computing and returning
    // the area the circle
    public double getArea() {
        return radius * radius * Math.PI;
    }

    // A public method you need to write to
    // compute and return the circumference of the circle
    public double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // A public method that compares the sizes of two circles: the circle
    // represented by the current object, and the circle passed as a parameter.
    // Example: circleA.isBiggerThan(circleB) should return true if circleA
    // has a larger area than circleB, false otherwise.
    // NOTE: You may need to modify the parameter list!
    public boolean isBiggerThan(Circle paramCircle) {
        return this.getArea() > paramCircle.getArea();
    }

    // A public method that takes as input an x coordinate (as a double)
    // and a y coordinate (a double), and returns true if the (x, y) coordinate
    // is inside the current circle, false otherwise.
    // NOTE: You may need to modify the parameter list!
    public boolean containsPoint(double x, double y) {
        double distance = Math.sqrt(Math.pow(x - this.x, 2) + Math.pow(y - this.y, 2));
        return distance <= this.radius;
    }

    // A public method named setRadius that sets this object's radius
    // based on the passed parameter (of type double).
    // The method should not return anything.
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // A public method named setCenter that sets this object's center.
    // The method takes two doubles as parameters: ex and why.
    // It should set the x coordinate of the circle to ex,
    // and the y coordinate of the circle to why.
    // The method should not return anything.
    public void setCenter(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Overriden method toString which should
    // return the string representation of this Circle object, as follows:
    // "This circle is centered at point <display_coordinate_of_center_here>
    // with radius <display_radius>"
    @Override
    public String toString() {
        double[] center = getCenter();
        return "This circle is centered at point (" + center[0] + ", " + center[1] + ") with radius " + getRadius();
    }

    // Override the method equals which is inherited from class Object
    // (similar to what we did in class Employee), and make it return true if the
    // two circles have equal areas, false otherwise
    // Important: Use the @Override annotation
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Circle)) {
            return false;
        } 
        Circle temp = (Circle) obj;
        return(this.getArea() == temp.getArea());
    }

    public static void main(String[] args) {
        // Test the constructors
        Circle circleA = new Circle(7);
        Circle circleB = new Circle(2);
        Circle circleC = new Circle(3, 5, 5); // Circle with radius 3 centered at (5,5)

        // Test isBiggerThan
        if (circleA.isBiggerThan(circleB)) {
            System.out.println("Circle A is bigger than Circle B");
        } else {
            System.out.println("Circle B is bigger than Circle A");
        }

        // Test getRadius
        System.out.println("Circle A's radius: " + circleA.getRadius());

        // Test getCenter
        double[] center = circleC.getCenter();
        System.out.println("Circle C's center: (" + center[0] + ", " + center[1] + ")");

        // Test getArea
        System.out.println("Circle A's area: " + circleA.getArea());

        // Test getCircumference
        System.out.println("Circle A's circumference: " + circleA.getCircumference());

        // Test containsPoint
        System.out.println("Circle A contains point (3, 4): " + circleA.containsPoint(3, 4));
        System.out.println("Circle C contains point (8, 8): " + circleC.containsPoint(8, 8));

        // Test setRadius
        circleB.setRadius(5);
        System.out.println("Circle B's new radius: " + circleB.getRadius());

        // Test setCenter
        circleB.setCenter(2, 3);
        double[] newCenter = circleB.getCenter();
        System.out.println("Circle B's new center: (" + newCenter[0] + ", " + newCenter[1] + ")");

        // Test toString
        System.out.println(circleA.toString());

        // Test equals
        Circle circleD = new Circle(7); // Another circle with radius 7
        System.out.println("Circle A is equal to Circle D: " + circleA.equals(circleD));
        System.out.println("Circle A is equal to Circle B: " + circleA.equals(circleB));

    }

}
