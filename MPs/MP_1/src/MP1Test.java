import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MP1Test {
    // instantiate an object of the RandomMooValue class
    private RandomMooValue randomMooValue;

    // variable to keep track of how many guesses the player has made
    private int guessCount = 1;

    // boolean variable to tell when game is over
    private boolean isGameFinished = false;

    private JTextField secretValueTextField;
    private JTextField guessTextField;
    private JButton randomValueButton;
    private JLabel numberOfMOOResultLabel1;
    private JLabel numberOfMooResultLabel2;
    private JLabel isCorrectGuessResultLabel;
    private JPanel panel1;


    public MP1Test() {
        // initialize the randomMooValue object
        randomMooValue = new RandomMooValue();

        secretValueTextField.addActionListener(new ActionListener() {
            @Override

            /**This listener is used to set the secret value to the number entered in the text field.
             */
            public void actionPerformed(ActionEvent e) {
                // get string input from text field, parse integer, and store value in secret value variable
                randomMooValue.setSecretValue(Integer.parseInt(secretValueTextField.getText()));

                // format the secret value as a four-digit string for displaying later
                randomMooValue.formatValue(randomMooValue.getSecretValue());

                // format the random value correctly and display this value in the secret value text field
                secretValueTextField.setText(randomMooValue.formatValue(randomMooValue.getSecretValue()));
            }
        });

        randomValueButton.addActionListener(new ActionListener() {
            @Override

            /**This listener sets a random secret value when the button is pressed.
             * This value is then displayed to the test output screen.
             */
            public void actionPerformed(ActionEvent e) {
                // set a new secret value and reset the guess counter and guess text field
                randomMooValue.setSecretValue();
                guessCount = 1;
                guessTextField.setText("");

                // enable the text field
                guessTextField.setEditable(true);

                // reset the game over flag
                isGameFinished = false;

                // reset number of big and little moos and the isCorrectGuessLabel
                numberOfMOOResultLabel1.setText("0");
                numberOfMooResultLabel2.setText("0");
                isCorrectGuessResultLabel.setText("");

                // format the random value correctly and display this value in the secret value text field
                secretValueTextField.setText(randomMooValue.formatValue(randomMooValue.getSecretValue()));
            }
        });

        guessTextField.addActionListener(new ActionListener() {
            @Override

            /**This listener takes in a string guess, parses the integer, and checks to see if the guess is correct.
             */
            public void actionPerformed(ActionEvent e) {
                // get string input from text field, parse integer, and set as the player's guess
                randomMooValue.setPlayerGuess(Integer.parseInt(guessTextField.getText()));

                // format the random value correctly and display this value in the secret value text field
                guessTextField.setText(randomMooValue.formatValue(randomMooValue.getPlayerGuess()));

                if (guessCount < 10) {
                    // check to see if integer entered is correct; if so, display "yes"
                    if(randomMooValue.isCorrectGuess(randomMooValue.getPlayerGuess())) {
                        isCorrectGuessResultLabel.setText("yes");

                        // set the number of big MOOs (should be four) and display this
                        numberOfMOOResultLabel1.setText(Integer.toString(
                                randomMooValue.getBigMooCount(randomMooValue.getPlayerGuess())));

                        // set the number of little moos (should be zero) and display this
                        numberOfMooResultLabel2.setText(Integer.toString(
                                randomMooValue.getLittleMooCount(randomMooValue.getPlayerGuess())));

                        // disable the text field
                        guessTextField.setEditable(false);

                        // set the game over flag
                        isGameFinished = true;
                    }
                    else {
                        // set result label to "no"
                        isCorrectGuessResultLabel.setText("no");

                        // find out the number of big and little moos to be displayed
                        numberOfMOOResultLabel1.setText(Integer.toString(
                                randomMooValue.getBigMooCount(randomMooValue.getPlayerGuess())));
                        numberOfMooResultLabel2.setText(Integer.toString(
                                randomMooValue.getLittleMooCount(randomMooValue.getPlayerGuess())));

                        // update the current guess count
                        guessCount++;
                    }
                }
                else if(randomMooValue.isCorrectGuess(randomMooValue.getPlayerGuess()) && !isGameFinished) {
                    isCorrectGuessResultLabel.setText("yes");

                    // set the number of big MOOs (should be four) and display this
                    numberOfMOOResultLabel1.setText(Integer.toString(
                            randomMooValue.getBigMooCount(randomMooValue.getPlayerGuess())));

                    // set the number of little moos (should be zero) and display this
                    numberOfMooResultLabel2.setText(Integer.toString(
                            randomMooValue.getLittleMooCount(randomMooValue.getPlayerGuess())));

                    // disable the text field
                    guessTextField.setEditable(false);

                    // set the game over flag
                    isGameFinished = true;
                }
                else if(!isGameFinished){
                    isCorrectGuessResultLabel.setText("Game over! You are out of guesses.");

                    // find out the number of big and little moos to be displayed
                    numberOfMOOResultLabel1.setText(Integer.toString(
                            randomMooValue.getBigMooCount(randomMooValue.getPlayerGuess())));
                    numberOfMooResultLabel2.setText(Integer.toString(
                            randomMooValue.getLittleMooCount(randomMooValue.getPlayerGuess())));

                    // disable the text field
                    guessTextField.setEditable(false);

                    // set the game over flag
                    isGameFinished = true;
                }
            }
        });
    }

/*
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("MP1 Test"); //Makes the frame
        myFrame.setContentPane(new MP1Test().panel1); //attaches the panel to the frame
        myFrame.setPreferredSize(new Dimension(430,200));

        //sets up what happens when the frame is closed
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.pack(); //put everything in the frame
        myFrame.setVisible(true); //allows us to see the frame
    }*/
}
