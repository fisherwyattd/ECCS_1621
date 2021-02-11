import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class contains the action listeners to be used to set the coordinates of the triangle's corners.
 * Also, the class contains the main method to execute the program.
 *
 * @author Wyatt Fisher
 * @since 2 February 2021
 */
public class TriangleForm {

    // instance variable of the main class
    private Triangle triangle;

    private JButton calculationButton;
    private JTextField inputAXTextField;
    private JTextField inputAYTextField;
    private JTextField inputBXTextField;
    private JTextField inputBYTextField;
    private JTextField inputCXTextField;
    private JTextField inputCYTextField;
    private JLabel xColumnLabel;
    private JLabel yColumnLabel;
    private JLabel inputALabel;
    private JLabel inputBLabel;
    private JLabel inputCLabel;
    private JLabel lenABLabel;
    private JLabel lenACLabel;
    private JLabel lenBCLabel;
    private JLabel angleDegLabel;
    private JLabel angleAResultLabel;
    private JLabel angleBResultLabel;
    private JLabel angleCResultLabel;
    private JLabel perimeterLabel;
    private JLabel areaLabel;
    private JLabel perimeterResultLabel;
    private JLabel areaResultLabel;
    private JLabel lenABResultLabel;
    private JLabel lenACResultLabel;
    private JLabel lenBCResultLabel;
    private JPanel panel1;


    public TriangleForm() {

        // initialize new triangle object
        triangle = new Triangle();

        // action listeners to take in the coordinate values of the triangle's corners
        inputAXTextField.addActionListener(new ActionListener() {
            @Override

            /**
             * This method sets the x-coordinate for the Input A corner.
             * The input is checked to make sure it can be parsed to a double.
             * If so, the resulting double is passed to the Input A x-coordinate setter.
             */
            public void actionPerformed(ActionEvent e) {
                // test double to see if the input can be parsed to a double
                double testNum;

                // try to parse the input as a double; if it works, set the double to the coordinate
                try {
                    testNum = Double.parseDouble(inputAXTextField.getText());
                    triangle.setCornerAXCoordinate(testNum);
                } catch(NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }
        });


        inputAYTextField.addActionListener(new ActionListener() {
            @Override

            /**
             * This method sets the y-coordinate for the Input A corner.
             * The input is checked to make sure it can be parsed to a double.
             * If so, the resulting double is passed to the Input A y-coordinate setter.
             */
            public void actionPerformed(ActionEvent e) {
                // test double to see if the input can be parsed to a double
                double testNum;

                // try to parse the input as a double; if it works, set the double to the coordinate
                try {
                    testNum = Double.parseDouble(inputAYTextField.getText());
                    triangle.setCornerAYCoordinate(testNum);
                } catch(NumberFormatException e2) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }
        });


        inputBXTextField.addActionListener(new ActionListener() {
            @Override

            /**
             * This method sets the x-coordinate for the Input B corner.
             * The input is checked to make sure it can be parsed to a double.
             * If so, the resulting double is passed to the Input B x-coordinate setter.
             */
            public void actionPerformed(ActionEvent e) {
                // test double to see if the input can be parsed to a double
                double testNum;

                // try to parse the input as a double; if it works, set the double to the coordinate
                try {
                    testNum = Double.parseDouble(inputBXTextField.getText());
                    triangle.setCornerBXCoordinate(testNum);
                } catch(NumberFormatException e3) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }
        });


        inputBYTextField.addActionListener(new ActionListener() {
            @Override

            /**
             * This method sets the y-coordinate for the Input B corner.
             * The input is checked to make sure it can be parsed to a double.
             * If so, the resulting double is passed to the Input B y-coordinate setter.
             */
            public void actionPerformed(ActionEvent e) {
                // test double to see if the input can be parsed to a double
                double testNum;

                // try to parse the input as a double; if it works, set the double to the coordinate
                try {
                    testNum = Double.parseDouble(inputBYTextField.getText());
                    triangle.setCornerBYCoordinate(testNum);
                } catch(NumberFormatException e4) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }
        });


        inputCXTextField.addActionListener(new ActionListener() {
            @Override

            /**
             * This method sets the x-coordinate for the Input C corner.
             * The input is checked to make sure it can be parsed to a double.
             * If so, the resulting double is passed to the Input C x-coordinate setter.
             */
            public void actionPerformed(ActionEvent e) {
                // test double to see if the input can be parsed to a double
                double testNum;

                // try to parse the input as a double; if it works, set the double to the coordinate
                try {
                    testNum = Double.parseDouble(inputCXTextField.getText());
                    triangle.setCornerCXCoordinate(testNum);
                } catch(NumberFormatException e5) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }
        });


        inputCYTextField.addActionListener(new ActionListener() {
            @Override

            /**
             * This method sets the y-coordinate for the Input C corner.
             * The input is checked to make sure it can be parsed to a double.
             * If so, the resulting double is passed to the Input C y-coordinate setter.
             */
            public void actionPerformed(ActionEvent e) {
                // test double to see if the input can be parsed to a double
                double testNum;

                // try to parse the input as a double; if it works, set the double to the coordinate
                try {
                    testNum = Double.parseDouble(inputCYTextField.getText());
                    triangle.setCornerCYCoordinate(testNum);
                } catch(NumberFormatException e6) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }
        });


        calculationButton.addActionListener(new ActionListener() {
            @Override

            /**
             * This method calls all the calculation methods from the Triangle class.
             * It also sets the result text fields to the resulting doubles of the calculations.
             */
            public void actionPerformed(ActionEvent e) {

                // calculate the distance from Input A to Input B and convert to a formatted string
                // display the distance from Input A to Input B in the corresponding result label
                lenABResultLabel.setText(String.format("%.2f", triangle.getLengthAB()));

                // calculate the distance from Input A to Input C and convert to a formatted string
                // display the distance from Input A to Input C in the corresponding result label
                lenACResultLabel.setText(String.format("%.2f", triangle.getLengthAC()));

                // calculate the distance from Input B to Input C and convert to a formatted string
                // display the distance from Input B to Input C in the corresponding result label
                lenBCResultLabel.setText(String.format("%.2f", triangle.getLengthBC()));

                // calculate and display the perimeter of the triangle
                perimeterResultLabel.setText(String.format("%.2f", triangle.calculatePerimeter(
                        triangle.getLengthAB(), triangle.getLengthAC(), triangle.getLengthBC())));

                // calculate and display the area of the triangle
                areaResultLabel.setText(String.format("%.2f", triangle.calculateArea(
                        triangle.getLengthAB(), triangle.getLengthAC(), triangle.getLengthBC())));

                // calculate and display the angle measurement of Input A
                angleAResultLabel.setText(String.format("%.2f", triangle.getAngleADegrees()));

                // calculate and display the angle measurement of Input B
                angleBResultLabel.setText(String.format("%.2f", triangle.getAngleBDegrees()));

                // calculate and display the angle measurement of Input C
                angleCResultLabel.setText(String.format("%.2f", triangle.getAngleCDegrees()));
            }
        });
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Triangle Calculation"); //Makes the frame
        myFrame.setContentPane(new TriangleForm().panel1); //attaches the panel to the frame

        //sets up what happens with the frame is closes
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.pack(); //put everything in the frame
        myFrame.setVisible(true); //allows us to see the frame
    }
}
