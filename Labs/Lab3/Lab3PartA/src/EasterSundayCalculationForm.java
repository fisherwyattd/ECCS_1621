import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * This program will take in an input as a year and use Carl Friedrich Gauss'
 * algorithm to determine the date of Easter Sunday that year.
 *
 * @author Wyatt Fisher
 * @since 2 February 2021
 */
public class EasterSundayCalculationForm {
    private int inputYear;
    private String resultDate;

    private JTextField inputYearTextField;
    private JLabel enterYearLabel;
    private JLabel resultLabel;
    private JPanel panel1;


    /**
     * This method takes the validated input year and uses Gauss' algorithm to calculate the date of Easter Sunday.
     * @param y The year the user inputs.
     * @return The string date including
     */
    public String calculateDate(int y) {
        // perform the algorithm
        int a = y % 19;
        int b = y / 100;
        int c = y % 100;
        int d = b / 4;
        int e = b % 4;
        int g = (8 * b + 13) / 25;
        int h = (19 * a + b - d - g + 15) % 30;
        int j = c / 4;
        int k = c % 4;
        int m = (a + 11 * h) / 319;
        int r = (2 * e + 2 * j - k - h + m + 32) % 7;
        int n = (h - m + r + 90) / 25;
        int p = (h - m + r + n + 19) % 32;

        // determine the month of Easter Sunday
        switch(n) {
            case 1: resultDate = "January";
                break;
            case 2: resultDate = "February";
                break;
            case 3: resultDate = "March";
                break;
            case 4: resultDate = "April";
                break;
            case 5: resultDate = "May";
                break;
            case 6: resultDate = "June";
                break;
            case 7: resultDate = "July";
                break;
            case 8: resultDate = "August";
                break;
            case 9: resultDate = "September";
                break;
            case 10: resultDate = "October";
                break;
            case 11: resultDate = "November";
                break;
            case 12: resultDate = "December";
                break;
        }

        // add the day to the month in the result string
        resultDate += (" " + p);

        return resultDate;
    }

    public EasterSundayCalculationForm() {
        inputYearTextField.addActionListener(new ActionListener() {
            @Override

            /**
             * This listener is activated when the user enters input in the inputYearTextField.
             * The input will be taken as a string and the method will attempt to parse an integer from it.
             * If an exception is thrown, the user will be notified that they entered an invalid input.
             */
            public void actionPerformed(ActionEvent e) {
                // take in the input as a string
                String input = inputYearTextField.getText();

                // try to parse an integer from this; if possible, show the calculated date
                try {
                    inputYear = Integer.parseInt(input);
                    resultLabel.setText("In " + inputYear + ", Easter Sunday fell on " +
                            calculateDate(inputYear) + ".");
                } catch(NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "That is an invalid year.\n" +
                            "Please enter a new year.");
                }
            }
        });
    }


    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Easter Sunday Calculation"); //Makes the frame
        myFrame.setContentPane(new EasterSundayCalculationForm().panel1); //attaches the panel to the frame

        //sets up what happens with the frame is closes
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.pack(); //put everything in the frame
        myFrame.setVisible(true); //allows us to see the frame
    }
}
