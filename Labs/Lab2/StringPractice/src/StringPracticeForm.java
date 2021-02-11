import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * StringPracticeForm class: includes a GUI for the user to enter two strings.
 * The lengths of both strings will displayed on the GUI.
 * The results of the operations the user chooses to activate will also be displayed on the GUI.
 * @author Wyatt Fisher
 */
public class StringPracticeForm extends javax.swing.JPanel {
    // names of the user-entered strings
    String string1;
    String string2;

    // fields from the GUI
    private JTextField string1TextField;
    private JTextField string2TextField;
    private JButton compareToButton;
    private JButton endsWithButton;
    private JButton trimButton;
    private JButton toUpperCaseButton;
    private JButton toLowerCaseButton;
    private JPanel stringPanel;
    private JLabel length1Label;
    private JLabel length2Label;
    private JLabel result2Label;
    private JLabel result1Label;



    /**
     * Default constructor method for the StringPracticeForm
     */
    public StringPracticeForm() {
        compareToButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // compares the lexicographical order of the strings
                // displays the result in result1Label
                if (string1.compareTo(string2) < 0) {
                    result1Label.setText("str1 < str2");
                }
                else if (string1.compareTo(string2) > 0) {
                    result1Label.setText("str1 > str2");
                }
                else if (string1.compareTo(string2) == 0) {
                    result1Label.setText("str1 == str2");
                }
            }
        });

        endsWithButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // checks if string2 is a suffix of string1
                if (string1.endsWith(string2)) { result2Label.setText("yes"); }
                else { result2Label.setText("no"); }
            }
        });

        toLowerCaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // sets the results labels to the lower case versions of the strings
                result1Label.setText(string1.toLowerCase());
                result2Label.setText(string2.toLowerCase());
            }
        });

        toUpperCaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // sets the results labels to the upper case versions of the strings
                result1Label.setText(string1.toUpperCase());
                result2Label.setText(string2.toUpperCase());
            }
        });

        trimButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // uses the .trim() method of the String class to remove leading/trailing whitespace
                result1Label.setText(string1.trim());
                result2Label.setText(string2.trim());
            }
        });

        string1TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // calculates and displays the length of string1
                string1 = string1TextField.getText();
                length1Label.setText("" + string1.length());
            }
        });

        string2TextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // calculates and displays the length of string2
                string2 = string2TextField.getText();
                length2Label.setText("" + string2.length());
            }
        });
    }


    /**
     * isSuffix Function: my own method for checking to see if string2 is a suffix of string1
     * @return The result of whether or not string2 is the suffix of string1
     */
    public boolean isSuffix(){
        // set true (by default) if string2 is a suffix of string1
        boolean isSuffix = true;

        // only look at the same amount of characters at the end of string1 as there are characters in string2
        int string1ArrayVal = (string1.length() - string2.length());

        // counter for while loop below
        int counter = 0;

        // look at each individual character and compare them
        while (counter < string2.length()) {
            // if the characters at that index are different, string2 is not a suffix
            if (string1.charAt(string1ArrayVal) != string2.charAt(counter)) { isSuffix = false; }

            // increment values for the next pass through the loop
            counter++;
            string1ArrayVal++;
        }

        return isSuffix;
    };


    /**
     * isSuffix2 Function: my own method for checking to see if string2 is a suffix of string1
     * @return The result of whether or not string2 is the suffix of string1
     */
    public static boolean isSuffix2(String newString1, String newString2){
        // set true (by default) if string2 is a suffix of string1
        boolean isSuffix = true;

        // only look at the same amount of characters at the end of string1 as there are characters in string2
        int string1ArrayVal = (newString1.length() - newString2.length());

        // counter for while loop below
        int counter = 0;

        // look at each individual character and compare them
        while (counter < newString2.length()) {
            // if the characters at that index are different, string2 is not a suffix
            if (newString1.charAt(string1ArrayVal) != newString2.charAt(counter)) { isSuffix = false; }

            // increment values for the next pass through the loop
            counter++;
            string1ArrayVal++;
        }

        return isSuffix;
    };

    /**
     * main Function: the main method of the class/program
     * @param args
     */
    public static void main(String[] args) {
        // creates the frame of class JFrame
        JFrame myFrame = new JFrame("String Practice!");

        // attaches the stringPanel (from GUI) to the frame
        myFrame.setContentPane(new StringPracticeForm().stringPanel);

        // tells what to do when the frame is closed
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // packs everything into the frame
        myFrame.pack();

        // makes the frame visible to the user
        myFrame.setVisible(true);
    }
}
