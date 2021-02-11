import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This program will take in a ten-digit phone number from the user via a GUI.
 * Then, the number will be formatted to match the format (XXX)XXX-XXXX.
 *
 * @author Wyatt Fisher
 * @since 30 January 2021
 */
public class PhoneNumberForm {
    private String inputNumberStr; // will hold the user's input number

    private JPanel numberFormatPanel;
    private JTextField userNumberTextField;
    private JButton formatNumberButton;
    private JLabel resultJLabel;

    public PhoneNumberForm() {
        userNumberTextField.addActionListener(new ActionListener() {
            @Override

            /**This listener will be activated when the user enters a number and presses "Enter."
             * It will take in the input as a string.
             */
            public void actionPerformed(ActionEvent e) {
                // take in a string input from the text field
                inputNumberStr = userNumberTextField.getText();
            }
        });

        formatNumberButton.addActionListener(new ActionListener() {
            @Override

            /**This listener will reformat the number and display it in the adjacent JLabel.
             */
            public void actionPerformed(ActionEvent e) {
                // format the number by breaking the string into substrings and concatenating with other characters.
                resultJLabel.setText("(" + inputNumberStr.substring(0,3) + ")" +
                        inputNumberStr.substring(3,6) + "-" + inputNumberStr.substring(6));
            }
        });
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Reformat The Phone Number"); //Makes the frame
        myFrame.setContentPane(new PhoneNumberForm().numberFormatPanel); //attaches the panel to the frame
        myFrame.setPreferredSize(new Dimension(500, 200));

        //sets up what happens when the frame is closed
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.pack(); //put everything in the frame
        myFrame.setVisible(true); //allows us to see the frame
    }
}
