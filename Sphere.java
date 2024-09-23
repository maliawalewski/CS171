public class Sphere extends Circle {


    /* THIS CODE WAS MY OWN WORK , IT WAS WRITTEN WITHOUT CONSULTING
    CODE WRITTEN BY OTHER STUDENTS OR COPIED FROM ONLINE RESOURCES.
    Malia Walewski */

    // Instance variables (data members) of class Sphere
    // Do not need to redeclare x, y, radius because they are protected in Circle class so we have access
    protected double z;

    // The default constructor with no argument where x, y, radius are inherited from Circle class
    public Sphere() {
        super();
        z = 0.0;
    }

    // Second constructor with parameters x, y, z, and radius 
    // x, y, radius are inherited from Circle class
    public Sphere(double x, double y, double z, double radius) {
        super(radius, x, y);
        this.z = z;
    }

    // Override the method getCenter() from Circle class 
    // Returns new double array with three coordinates x, y, z
    @Override
    public double[] getCenter() {
        double[] c = {this.x, this.y, this.z};
        return c;
    }

    // Overload method setCenter() from Circle class
    //sets the spheres center by taking in 3 parameters
    // x and y inherited from super class setCenter() method and z from class Sphere
    public void setCenter(double x, double y, double z) {
        super.setCenter(x, y);
        this.z = z;
    }

    // Override the method getArea() from Circle class and return surface area of sphere
    // Uses method getArea() from Circle class
    @Override
    public double getArea() {
        return 4 * super.getArea();
    }

    // Method getVolume() that uses the getArea() method from Circle class
    // returns double volume of sphere 
    public double getVolume() {
        return (4.0/3.0) * super.getArea() * this.radius;
    }

    public static void main(String[] args) {
        // Test the default constructor
        Sphere sphereA = new Sphere();
        System.out.println("Sphere A:");
        System.out.println("Center: (" + sphereA.getCenter()[0] + ", " + sphereA.getCenter()[1] + ", " + sphereA.getCenter()[2] + ")"); // Expected: (0.0, 0.0, 0.0)
        System.out.println("Radius: " + sphereA.getRadius()); 
        System.out.println("Surface Area: " + sphereA.getArea()); 
        System.out.println("Volume: " + sphereA.getVolume()); 

        // Test the parameterized constructor
        Sphere sphereB = new Sphere(2.0, 3.0, 4.0, 5.0);
        System.out.println("\nSphere B:");
        System.out.println("Center: (" + sphereB.getCenter()[0] + ", " + sphereB.getCenter()[1] + ", " + sphereB.getCenter()[2] + ")"); // Expected: (2.0, 3.0, 4.0)
        System.out.println("Radius: " + sphereB.getRadius()); 
        System.out.println("Surface Area: " + sphereB.getArea()); 
        System.out.println("Volume: " + sphereB.getVolume()); 

        // Test setCenter method
        sphereA.setCenter(1.0, 1.0, 1.0);
        System.out.println("\nSphere A after setting new center:");
        System.out.println("New Center: (" + sphereA.getCenter()[0] + ", " + sphereA.getCenter()[1] + ", " + sphereA.getCenter()[2] + ")"); // Expected: (1.0, 1.0, 1.0)

        // Test getArea and getVolume
        Sphere sphereC = new Sphere(0, 0, 0, 2.0);
        System.out.println("\nSphere C:");
        System.out.println("Surface Area: " + sphereC.getArea()); 
        System.out.println("Volume: " + sphereC.getVolume()); 
    }
} 
