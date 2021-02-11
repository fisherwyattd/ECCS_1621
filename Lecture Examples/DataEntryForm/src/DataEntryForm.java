import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/** ECCS 1621: Programming 2 -- In-class activity
    * @author Dr. Al-Haj and Dr. Coffman-Wolph
    * @since February 2, 2021
    *
    * Description: this program takes user input from textboxes (i.e., like registrating
    * for a website). User enters first name, last name, username, and password
    *
    * This Java code takes this information when the user hits enter after hitting enter
    * at the end of each line. This is not a complete program. The focus is on the
    * GUI. And designed to give you a platform for discussing poor none diverse design.
 */


public class DataEntryForm {
    private JPanel backPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel firstName;
    private JLabel lastName;
    private JLabel userName;
    private JPasswordField passwordField1;
    private JLabel passWord;
    private JLabel nameInstructionsLabel;
    private JButton submitButton;
    private JLabel submitInstructionsLabel;
    private JLabel userNamePasswordInstructionsLabel;

    private String firstN = "";
    private String lastN = "";
    private String userN = "";
    private char[] passW;

    public DataEntryForm() {
        textField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                firstN = textField1.getText();
            }
        });
        textField2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                lastN = textField2.getText();
            }
        });
        textField3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                userN = textField3.getText();
            }
        });
        passwordField1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                passW = passwordField1.getPassword();
            }
        });
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("User Registration Form"); //Makes the frame
        //myFrame.setSize(100, 50);
        myFrame.setContentPane(new DataEntryForm().backPanel); //attaches the panel to the frame

        //sets up what happens with the frame is closes
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Using java dimension, set the preferred size - both width and height
        myFrame.setPreferredSize(new Dimension(600, 400));


        myFrame.pack(); //put everything in the frame
        myFrame.setVisible(true); //allows us to see the frame
    }
}
