// This class represents a rectangle shape
public class Rectangle {


    /* THIS CODE WAS MY OWN WORK , IT WAS WRITTEN WITHOUT CONSULTING
    CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
    Malia Walewski */

	private double l; // the length of the rectangle
	private double h; // the height of the rectangle
	private double x; // the x coordinate of the  bottom left corner of the rectangle
	private double y; // the y coordinate of the bottom left corner of the rectangle

	// A simple constructor that creates a rectangle with
	// side lengths 1 whose bottom left corner is at (0.0,0.0)
	public Rectangle() {
		this.l = 1.0;
		this.h = 1.0;
		this.x = 0.0;
		this.y = 0.0;
	}

	// A constructor that takes all four inputs,
	// named Ell, Eich, Ex, and Why for L, H, x, and y, respectively.
	public Rectangle(double Ell, double Eich, double Ex, double Why) {
		this.l = Ell;
		this.h = Eich;
		this.x = Ex;
		this.y = Why;
	}

	// A public method called getLength which returns the length.
	public double getLength() {
		return this.l;
	}

	// A public method called getHeight which returns the height.
	public double getHeight() {
		return this.h;
	}

	// A public method called setLength which takes as input a double
	// called Ell and uses it to set the length of the rectangle.
	public void setLength(double Ell) {
		this.l = Ell;
	}

	// A public method called setHeight which takes as input a double
	// called Eich and uses it to set the height of the rectangle.
	public void setHeight(double Eich) {
		this.h = Eich;
	}

	// A public method called getPerimeter which computes and returns
	// the perimeter of the rectangle.
	public double getPerimeter() {
		return 2*l + 2*h;
	}

	// A public method called getArea which computes and returns the
	// area of the rectangle.
	public double getArea() {
		return l*h;
	}

	// Override the method equals which is inherited from class Object
	// (similar to what we did in class Employee), and make it return true if the
	// two rectangles have equal areas, false otherwise
	// Important: Use the @Override annotation
	@Override 
	public boolean equals(Object obj) {
		if (!(obj instanceof Rectangle)) {
			return false;
		}
		Rectangle temp = (Rectangle) obj;
		return(this.getArea() == temp.getArea());
	}

	public static void main(String[] args) {
        // Test the default constructor
        Rectangle rectA = new Rectangle();
        System.out.println("Rectangle A: ");
        System.out.println("Length: " + rectA.getLength()); 
        System.out.println("Height: " + rectA.getHeight()); 
        System.out.println("Area: " + rectA.getArea()); 
        System.out.println("Perimeter: " + rectA.getPerimeter()); 

        // Test the parameterized constructor
        Rectangle rectB = new Rectangle(4.0, 3.0, 1.0, 1.0);
        System.out.println("\nRectangle B: ");
        System.out.println("Length: " + rectB.getLength()); 
        System.out.println("Height: " + rectB.getHeight()); 
        System.out.println("Area: " + rectB.getArea());
        System.out.println("Perimeter: " + rectB.getPerimeter()); 

        // Test setLength and setHeight
        rectA.setLength(5.0);
        rectA.setHeight(2.0);
        System.out.println("\nRectangle A after setting new length and height: ");
        System.out.println("New Length: " + rectA.getLength()); 
        System.out.println("New Height: " + rectA.getHeight()); 
        System.out.println("New Area: " + rectA.getArea()); 
        System.out.println("New Perimeter: " + rectA.getPerimeter()); 

        // Test equals method
        Rectangle rectC = new Rectangle(5.0, 2.0, 0.0, 0.0); 
        Rectangle rectD = new Rectangle(3.0, 4.0, 0.0, 0.0); 
        System.out.println("\nRectangle A is equal to Rectangle C: " + rectA.equals(rectC)); 
        System.out.println("Rectangle A is equal to Rectangle D: " + rectA.equals(rectD)); 
    }

}
