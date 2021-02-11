import java.lang.Math;

/**
 * This class contains all the functionality for setting and getting the triangle's corner coordinates.
 * Also, the class contains methods to calculate the various desired triangle properties.
 *
 * @author Wyatt Fisher
 * @since 2 February 2021
 */
public class Triangle {
    // corner coordinate variables
    private double cornerAXCoordinate;
    private double cornerAYCoordinate;
    private double cornerBXCoordinate;
    private double cornerBYCoordinate;
    private double cornerCXCoordinate;
    private double cornerCYCoordinate;

    // length variables
    private double lengthAB;
    private double lengthAC;
    private double lengthBC;

    // perimeter and area variables
    private double perimeter;
    private double area;

    // angle measurement variables
    private double angleADegrees;
    private double angleBDegrees;
    private double angleCDegrees;


    /**
     * This is the constructor of the Triangle class. It sets the default corner coordinates at (0.0, 0.0).
     */
    public Triangle() {
        cornerAXCoordinate = 0.0;
        cornerAYCoordinate = 0.0;
        cornerBXCoordinate = 0.0;
        cornerBYCoordinate = 0.0;
        cornerCXCoordinate = 0.0;
        cornerCYCoordinate = 0.0;
    }


    // corner coordinates - setters

    /**
     * This method sets the x-coordinate for the Input A corner.
     * @param input A pre-parsed (validated) double given by the user.
     */
    public void setCornerAXCoordinate(double input) {
        cornerAXCoordinate = input;
    }

    /**
     * This method sets the y-coordinate for the Input A corner.
     * @param input A pre-parsed (validated) double given by the user.
     */
    public void setCornerAYCoordinate(double input) {
        cornerAYCoordinate = input;
    }

    /**
     * This method sets the x-coordinate for the Input B corner.
     * @param input A pre-parsed (validated) double given by the user.
     */
    public void setCornerBXCoordinate(double input) {
        cornerBXCoordinate = input;
    }

    /**
     * This method sets the y-coordinate for the Input B corner.
     * @param input A pre-parsed (validated) double given by the user.
     */
    public void setCornerBYCoordinate(double input) {
        cornerBYCoordinate = input;
    }

    /**
     * This method sets the x-coordinate for the Input C corner.
     * @param input A pre-parsed (validated) double given by the user.
     */
    public void setCornerCXCoordinate(double input) {
        cornerCXCoordinate = input;
    }

    /**
     * This method sets the y-coordinate for the Input C corner.
     * @param input A pre-parsed (validated) double given by the user.
     */
    public void setCornerCYCoordinate(double input) {
        cornerCYCoordinate = input;
    }


    // corner coordinates - getters

    /**
     * This method gets the x-coordinate of the Input A corner that the user entered.
     * @return The x-coordinate of the Input A corner.
     */
    public double getCornerAXCoordinate() {
        return cornerAXCoordinate;
    }

    /**
     * This method gets the y-coordinate of the Input A corner that the user entered.
     * @return The y-coordinate of the Input A corner.
     */
    public double getCornerAYCoordinate() {
        return cornerAYCoordinate;
    }

    /**
     * This method gets the x-coordinate of the Input B corner that the user entered.
     * @return The x-coordinate of the Input B corner.
     */
    public double getCornerBXCoordinate() {
        return cornerBXCoordinate;
    }

    /**
     * This method gets the y-coordinate of the Input B corner that the user entered.
     * @return The y-coordinate of the Input B corner.
     */
    public double getCornerBYCoordinate() {
        return cornerBYCoordinate;
    }

    /**
     * This method gets the x-coordinate of the Input C corner that the user entered.
     * @return The x-coordinate of the Input C corner.
     */
    public double getCornerCXCoordinate() {
        return cornerCXCoordinate;
    }

    /**
     * This method gets the y-coordinate of the Input C corner that the user entered.
     * @return The y-coordinate of the Input C corner.
     */
    public double getCornerCYCoordinate() {
        return cornerCYCoordinate;
    }


    // length between corners - getters

    /**
     * This method calls the distance calculator helper function to
     * calculate the length of the AB side of the triangle.
     * @return The length between the Input A corner and Input B corner.
     */
    public double getLengthAB() {
        // use distance formula helper function to calculate the distance
        lengthAB = calculateDistanceBetweenTwoCorners(cornerAXCoordinate, cornerBXCoordinate,
                cornerAYCoordinate, cornerBYCoordinate);

        return lengthAB;
    }

    /**
     * This method calls the distance calculator helper function to
     * calculate the length of the AC side of the triangle.
     * @return The length between the Input A corner and Input C corner.
     */
    public double getLengthAC() {
        // use distance formula helper function to calculate the distance
        lengthAC = calculateDistanceBetweenTwoCorners(cornerAXCoordinate, cornerCXCoordinate,
                cornerAYCoordinate, cornerCYCoordinate);

        return lengthAC;
    }

    /**
     * This method calls the distance calculator helper function to
     * calculate the length of the BC side of the triangle.
     * @return The length between the Input B corner and Input C corner.
     */
    public double getLengthBC() {
        // use distance formula helper function to calculate the distance
        lengthBC = calculateDistanceBetweenTwoCorners(cornerBXCoordinate, cornerCXCoordinate,
                cornerBYCoordinate, cornerCYCoordinate);

        return lengthBC;
    }


    // angle getters

    /**
     * This method uses the helper function calculateAngle to calculate the angle of coordinate A.
     * @return The angle measurement of Input A in degrees.
     */
    public double getAngleADegrees() {
        angleADegrees = calculateAngle(lengthAB, lengthAC, lengthBC, 'A');
        return angleADegrees;
    }

    /**
     * This method uses the helper function calculateAngle to calculate the angle of coordinate B.
     * @return The angle measurement of Input B in degrees.
     */
    public double getAngleBDegrees() {
        angleBDegrees = calculateAngle(lengthAB, lengthAC, lengthBC, 'B');
        return angleBDegrees;
    }

    /**
     * This method uses the helper function calculateAngle to calculate the angle of coordinate C.
     * @return The angle measurement of Input C in degrees.
     */
    public double getAngleCDegrees() {
        angleCDegrees = calculateAngle(lengthAB, lengthAC, lengthBC, 'C');
        return angleCDegrees;
    }


    // calculation methods

    /**
     * This method is a helper function that uses the distance formula
     * to calculate the distance between the passed coordinates.
     * @param x1 The x-value of the first coordinate set.
     * @param x2 The x-value of the second coordinate set.
     * @param y1 The y-value of the first coordinate set.
     * @param y2 The y-value of the second coordinate set.
     * @return The calculated distance between the two coordinates.
     */
    private double calculateDistanceBetweenTwoCorners(double x1, double x2, double y1, double y2) {
        // use the distance formula to calculate the distance between the entered coordinates
        return Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
    }

    /**
     * This method adds up the side lengths of the triangle to calculate its perimeter.
     * @param side1 One of the sides of the triangle.
     * @param side2 Another side of the triangle.
     * @param side3 The third side of the triangle.
     * @return The perimeter of a triangle with the passed parameter side lengths.
     */
    public double calculatePerimeter(double side1, double side2, double side3) {
        // add up the side lengths to find the perimeter
        perimeter = side1 + side2 + side3;

        return perimeter;
    }

    /**
     * This method uses Heron's Formula to calculate the area of a triangle given its side lengths.
     * @param side1 One of the sides of the triangle.
     * @param side2 Another side of the triangle.
     * @param side3 The third side of the triangle.
     * @return The area of a triangle with the passed parameter side lengths.
     */
    public double calculateArea(double side1, double side2, double side3) {
        // Heron's Formula for calculating the area of a triangle given its side lengths
        double s = (side1 + side2 + side3) / 2;
        area = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));

        return area;
    }

    /**
     * This method is a helper function that uses the Law of Cosines to calculate
     * the unknown angles of a triangle given its side lengths.
     * @param sideAB One of the sides of the triangle (side c).
     * @param sideAC Another side of the triangle (side b).
     * @param sideBC The third side of the triangle (side a).
     * @param angleToCalc The angle the user wishes to calculate.
     * @return The angle of a triangle with the passed parameter side lengths.
     */
    private double calculateAngle(double sideAB, double sideAC, double sideBC, char angleToCalc) {
        // use a switch statement because there are three different angles the user may want to calculate
        switch(angleToCalc) {
            case 'A':
            case 'a':
                // use the Law of Cosines and multiply by (180 degrees/pi radians) to convert angle to degrees
                return (Math.acos((Math.pow(sideAC, 2) + Math.pow(sideAB, 2) - Math.pow(sideBC, 2))
                        / (2 * sideAC * sideAB))) * (180 / Math.PI);
            case 'B':
            case 'b':
                // use the Law of Cosines and multiply by (180 degrees/pi radians) to convert angle to degrees
                return (Math.acos((Math.pow(sideAB, 2) + Math.pow(sideBC, 2) - Math.pow(sideAC, 2))
                        / (2 * sideAB * sideBC))) * (180 / Math.PI);
            case 'C':
            case 'c':
                // use the Law of Cosines and multiply by (180 degrees/pi radians) to convert angle to degrees
                return (Math.acos((Math.pow(sideBC, 2) + Math.pow(sideAC, 2) - Math.pow(sideAB, 2))
                        / (2 * sideBC * sideAC))) * (180 / Math.PI);
            default: return 0.0;
        }
    }
}
