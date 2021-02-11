import javax.swing.JOptionPane;


/**
 * This program will ask the user to enter an amount of numbers as doubles into a dialogue box.
 * After each entry, the current total and number of entered numbers up to that point.
 * The user will be asked if they want to continue entering numbers.
 * If "y" the program will continue running; if "n" the program will display the total average and quit.
 *
 * @author Wyatt Fisher
 * @since 29 January 2021
 */

public class AverageCalculator {
    private int count;
    private double sum;
    private double inputValue;
    private char yesOrNo;
    private String inputStr;
    private String messageString;


    public AverageCalculator() {
        count = 0;
        sum = 0.0;
    }

    // getters and setters
    public void setInputValue() {
        // boolean to check the input for validity; cleared each time
        boolean validInput = false;

        // make sure the user enters a valid input
        while(!validInput) {
            // read in a string input from the dialog box
            inputStr = JOptionPane.showInputDialog("Enter a number as a double.");

            // try parsing the string to a double; if not possible, ask the user to input an actual double
            try {
                inputValue = Double.parseDouble(inputStr);
                validInput = true;
            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(null,"Invalid entry.\nPlease enter a double.");
            }
        }

        // update the running total and count
        sum += inputValue;
        count++;
    }

    public void setYesOrNo() {
        yesOrNo = JOptionPane.showInputDialog("Do you want to add more numbers? (Y/N)").toUpperCase().charAt(0);
    }

    public void setMessageString() {
        messageString = String.format("The current average is %.2f.\n" +
                "The total count of numbers entered is %d.", (sum / count), count);
    }

    public void setMessageString(char endChar) {
        messageString = String.format("The final average is %.2f.\n" +
                "The total count of numbers entered is %d.", (sum / count), count);
    }

    public double getInputValue() {
        return inputValue;
    }

    public double getSum() { return sum; }

    public int getCount() { return count; }

    public char getYesOrNo() {
        return yesOrNo;
    }

    public String getMessageString() { return messageString; }

    public static void main(String[] args) {
        // instantiate a new object
        AverageCalculator averageCalculator = new AverageCalculator();

        do {
            averageCalculator.setInputValue();
            averageCalculator.setMessageString();
            JOptionPane.showMessageDialog(null, averageCalculator.getMessageString());
            averageCalculator.setYesOrNo();
        } while (averageCalculator.getYesOrNo() == 'Y');

        // display the final average and count
        averageCalculator.setMessageString(averageCalculator.getYesOrNo());
        JOptionPane.showMessageDialog(null, averageCalculator.getMessageString());
    }
}
