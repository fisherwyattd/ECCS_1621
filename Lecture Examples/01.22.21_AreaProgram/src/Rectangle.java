public class Rectangle {

    // specifications for the rectangle are private for security
    private double length;
    private int width;
    private double area;
    private static int numberOfRectangles = 0;

    // public constructor for Rectangle class
    public Rectangle() {
        numberOfRectangles++;
    }

    // setter for the length of the rectangle
    public void setLength(double newLength) {
        length = newLength;
    }

    // setter for the width of the rectangle
    public void setWidth(int newWidth) {
        width = newWidth;
    }

    // method to calculate and return the area of the rectangle
    public void calcArea() {
        area = length * width;
    }

    // getter for the area of the rectangle
    public double getArea() {
        return area;
    }

    // getter for number of rectangles
    public int getRectangles() {
        return numberOfRectangles;
    }

    public static void main(String[] args) {

        // create object rectangle1 and assign values
        Rectangle rectangle1 = new Rectangle();
        rectangle1.setLength(10.0);
        rectangle1.setWidth(5);
        rectangle1.calcArea();
        System.out.println(rectangle1.getArea());
        System.out.println("Number of rectangles = " + rectangle1.getRectangles());

        // create object rectangle2 and assign values
        Rectangle rectangle2 = new Rectangle();
        rectangle2.setLength(12.0);
        rectangle2.setWidth(4);
        rectangle2.calcArea();
        System.out.println(rectangle2.getArea());
        System.out.println("Number of rectangles = " + rectangle1.getRectangles());
    }
}