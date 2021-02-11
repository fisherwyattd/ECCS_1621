import javax.swing.JOptionPane;


// javadoc command:
// $ javadoc Rectangle.java -author -version -private -d Rectangle_Documentation/

/**
 *   ECCS 1621: Programming 2
 *
 *   This is simple Java program to show how to follow OO
 *   programming concepts.
 *
 *   <br>In this class, we used a static variable to hold the count
 *   of instantiated Rectangle objects.
 *
 *   <br><b>Note:
 *   The phrase "instantiating a class" means the same thing as
 *   "creating an object." When you create an object, you are creating
 *   an "instance" of a class, therefore "instantiating" a class.</b>
 *
 *   @author Dr. Al-Haj
 *   @since January 2021
 *   @version 1.0
 */

public class Rectangle{
    // private fields can't be accessed outside the class
    // we keep fields (variables) private, and we use public
    // setters and getters to update/access them

    /**
     The length of a rectangle
     */
    private double length;

    /**
     The width of a rectangle
     */
    private double width;

    // static fields are shared among all instances of a class
    // in other words, all Rectangle objects can access this
    // integer field -- rectangleCount.
    /**
     A counter to count how many Rectangle objects have been created.
     */
    private static int rectangleCount = 0;

    // Constructors are used to initialize all objects
    // when they are instantiated.
    /**
     Default constructor to initialize length and width to 0.
     */
    public Rectangle(){
        this.length = 0;
        this.width = 0;

        // update the counter when an object is instantiated
        rectangleCount++;
    }

    // an overloaded constructor that has parameters
    /**
     Overloaded constructor
     @param length the input length for the object to be created
     @param width the input width for the object to be created

     */
    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;

        // don't forget to update the counter in this constructor
        rectangleCount++;
    }

    /** a method (setter) to update length field
     @param l the input length value
     */
    public void setLength(double l){
        length = l;
    }

    /** a method (setter) to update width field
     @param w the input width value
     */
    public void setWidth(double w){
        width = w;
    }

    /** a method (getter) to access rectangleCount field
     @return the count of instantiated Rectangle objects
     */
    public int getRectangleCount(){
        return rectangleCount;
    }

    // a method the return the area of a rectangle
    // --> notice that we still can access private fields here
    /** a method to claculate the area of a rectangle
     @return the area of a Rectangle object
     */
    public double calcArea(){
        return width*length;
    }

    // main method
    // keep in mind that the signature of the main method
    // is always: public static void main(String[] args)

    /**
     The main method in the class
     @param args a String array to pass arguments from the command line
     */
    public static void main(String[] args){
        // instantiating a Rectangle object r1 and using
        // setters to update the length and width
        Rectangle r1 = new Rectangle();

        // instantiating a Rectangle object r2, the overloaded Constructors
        // is used to initialize r2 object
        Rectangle r2 = new Rectangle(4, 4);

        // If you declare r3 like this, its value will be undetermined
        // until an object is actually created and assigned to it.
        // Simply declaring a reference variable does not create an object.
        // For that, you need to use the new operator.
        Rectangle r3;
        //r3 = new Rectangle();

        // You must assign an object to r3 before you use it in your code.
        // Otherwise, you will get a compiler error.

        // r3.setLength(2);
        // r3.setWidth(2);


        System.out.println("The area of r1 = " + r1.calcArea());
        System.out.println("The area of r2 = " + r2.calcArea());
        //System.out.println("The area of r3 = " + r3.calcArea());

        System.out.println("Total number of rectangles = " + r1.getRectangleCount());
        System.out.println("Total number of rectangles = " + r2.getRectangleCount());

        // using dialog box for input and output
        String stringWidth = JOptionPane.showInputDialog("What is your width of your rectangle?");
        // we need to convert stringWidth from string to double
        r1.setWidth( Double.parseDouble(stringWidth) );

        // using dialog box for input and output
        String stringLength = JOptionPane.showInputDialog("What is your length of your rectangle?");
        // we need to convert stringLength from string to double
        r1.setLength( Double.parseDouble(stringLength) );


        // show the output in a message dialog
        JOptionPane.showMessageDialog(null, "Rectangle area = " + r1.calcArea());

    }
}