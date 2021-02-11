import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.JOptionPane;

public class LaurieMOO extends JPanel {
    // instantiate an object of the RandomMooValue class
    private RandomMooValue randomMooValue;

    // variable to keep track of how many guesses the player has made
    private int guessCount = 1;

    // variable that holds the maximum number of guesses allowed per game
    private static final int GUESSES_PER_GAME = 10;

    // boolean variable to tell when game is over
    private boolean isGameFinished = false;

    // components of the GUI JFrame
    private Image backgroundImage;
    private JPanel panel1;
    private JTextField guessTextField;
    private JLabel guessCountLabel;
    private JLabel mooResultsLabel;


    public LaurieMOO() {
        // initialize the randomMooValue object
        randomMooValue = new RandomMooValue();

        // display the beginning guess count
        guessCountLabel.setText(String.format("Enter guess #%d:", guessCount));

        // action listener for the player guess entry text field
        guessTextField.addActionListener(new ActionListener() {
            @Override

            /**This listener takes in a string guess, parses the integer, and checks to see if the guess is correct.
             */
            public void actionPerformed(ActionEvent e) {
                // string to display number of moos
                String mooResults = "";

                // use a try-catch statement section to catch errors thrown when the user does not enter a valid int
                try {
                    // get string input from text field, parse integer, and set as the player's guess
                    randomMooValue.setPlayerGuess(Integer.parseInt(guessTextField.getText()));

                    // format the guess value correctly and display this value in the guess value text field
                    guessTextField.setText(randomMooValue.formatValue(randomMooValue.getPlayerGuess()));

                    // if the user is not out of guesses and the game is not over
                    if ((guessCount < GUESSES_PER_GAME) && !isGameFinished) {
                        // check to see if integer entered is correct; if so, display LaurieMOO ending message
                        if (randomMooValue.isCorrectGuess(randomMooValue.getPlayerGuess())) {
                            // for loop to add big moos to the results string
                            for (int i = 0; i < randomMooValue.getBigMooCount(randomMooValue.getPlayerGuess()); i++)
                                mooResults += "MOO! ";

                            // display the four big moos
                            mooResultsLabel.setText(mooResults);

                            // display the end game "LaurieMOO" message in a message dialog
                            JOptionPane.showMessageDialog(null, "LaurieMOO!!!" +
                                    "\nYou won in only " + guessCount + " guesses!" +
                                    "\nThe game is over and the program will now terminate...");

                            // disable the text field
                            guessTextField.setEditable(false);

                            // set the game over flag
                            isGameFinished = true;

                            // terminate the program
                            System.exit(0);
                        } else { // if the integer entered is not correct
                            // for loop to add big moos to the results string
                            for (int i = 0; i < randomMooValue.getBigMooCount(randomMooValue.getPlayerGuess()); i++)
                                mooResults += "MOO! ";

                            // for loop to add big moos to the results string
                            for (int i = 0; i < randomMooValue.getLittleMooCount(randomMooValue.getPlayerGuess()); i++)
                                mooResults += "moo. ";

                            // check to see if the player got any of the digits correct
                            if (mooResults.length() > 0)
                                // display the moo results on the label
                                mooResultsLabel.setText(mooResults);
                            else
                                // if nothing was correct, display the cowbells message
                                mooResultsLabel.setText("All you hear are cowbells");

                            // update and display the current guess count
                            guessCount++;
                            guessCountLabel.setText(String.format("Enter guess #%d out of %d:",
                                    guessCount, GUESSES_PER_GAME));
                        }

                        // this else-if is only used when the user enters their last allowed guess and are correct
                    } else if (randomMooValue.isCorrectGuess(randomMooValue.getPlayerGuess()) && !isGameFinished) {
                        // for loop to add big moos to the results string
                        for (int i = 0; i < randomMooValue.getBigMooCount(randomMooValue.getPlayerGuess()); i++)
                            mooResults += "MOO! ";

                        // display the four big moos
                        mooResultsLabel.setText(mooResults);

                        // display the end game "LaurieMOO" message in a message dialog
                        JOptionPane.showMessageDialog(null, "LaurieMOO!!!" +
                                "\nYou won in only " + guessCount + " guesses!" +
                                "\nThe game is over and the program will now terminate...");

                        // disable the text field
                        guessTextField.setEditable(false);

                        // set the game over flag
                        isGameFinished = true;

                        // terminate the program
                        System.exit(0);

                        // this else-if is used when the user enters their last guess and are incorrect
                    } else if (!isGameFinished) {
                        // for loop to add big moos to the results string
                        for (int i = 0; i < randomMooValue.getBigMooCount(randomMooValue.getPlayerGuess()); i++)
                            mooResults += "MOO! ";

                        // for loop to add big moos to the results string
                        for (int i = 0; i < randomMooValue.getLittleMooCount(randomMooValue.getPlayerGuess()); i++)
                            mooResults += "moo. ";

                        // check to see if the player got any of the digits correct
                        if (mooResults.length() > 0)
                            // display the moo results on the label
                            mooResultsLabel.setText(mooResults);
                        else
                            // if no digits are correct, display the cowbells message
                            mooResultsLabel.setText("All you hear are cowbells");

                        // display the game over message and secret number in a message dialog
                        JOptionPane.showMessageDialog(null, "Boo hoo -- no LaurieMOO." +
                                "\nYou are out of guesses!" + "\nThe secret number was: " +
                                randomMooValue.formatValue(randomMooValue.getSecretValue())
                                + "\nThe game is over and the program will now terminate...");

                        // disable the text field
                        guessTextField.setEditable(false);

                        // set the game over flag
                        isGameFinished = true;

                        // terminate the program
                        System.exit(0);
                    }
                } catch(NumberFormatException e1) {
                    // tell the user to enter a valid number in any case where an integer cannot be parsed
                    JOptionPane.showMessageDialog(null,"Please enter a valid number.");
                }
            }
        });
    }


    /**This constructor is passed the location of an image to be displayed as the background of the GUI.
     * @param fileName The file to be used as the background image of the GUI.
     * @throws IOException
     */
    public LaurieMOO(String fileName) throws IOException {
        // read in the file as an image using ImageIO from the Java API
        backgroundImage = ImageIO.read(new File(fileName));
    }


    /**This method "draws" the background image using the Graphics class from the Java API.
     * @param g An object of the Graphics class to be used to draw the background image given the file to read from.
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // draw the background image
        g.drawImage(backgroundImage, 0, 0, this);
    }


    public static void main(String[] args) throws IOException {
        // makes the frame for the GUI
        JFrame myFrame = new JFrame("LaurieMOO Game")
        {
            // adds the cow image as the background image
            // NOTE: File path will need to be changed for the background image to appear on a different machine!
            private Image backgroundImage = ImageIO.read(new File(
                    "C:\\Users\\fishe\\Desktop\\Fisher ECCS 1621\\MPs\\MP_1\\images\\cow.jpg"));

            public void paint(Graphics g) {
                super.paint(g);
                g.drawImage(backgroundImage, 0, 0, null);
            }
        };

        // attaches the panel to the frame and passes the image file to the constructor so it becomes the background
        myFrame.setContentPane(new LaurieMOO().panel1);

        // resize the GUI window
        myFrame.setPreferredSize(new Dimension(480,360));

        // sets up what happens when the frame is closed
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // put everything in the frame
        myFrame.pack();

        // allows us to see the frame
        myFrame.setVisible(true);

        // display the beginning game dialog
        JOptionPane.showMessageDialog(null,"Enter a four digit number to begin the game...");
    }
}
