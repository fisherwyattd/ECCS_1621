import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGameForm {

    // code insert 1 - instance variables of the main class
    private int numberOfGuesses = 0;

    // create randomValue object of the class RandomValue
    private RandomValue randomValue;

    private JPanel panel1;
    private JLabel inputLabel;
    private JTextField inputTextField;
    private JButton newGameButton;
    private JLabel resultLabel;

    public GuessingGameForm() {

        // code insert 2 - initialization
        randomValue = new RandomValue();

        // disable the "New Game" button
        newGameButton.setEnabled(false);

        inputTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // increase number of guesses after user enters a number and presses "Enter"
                numberOfGuesses++;

                // get an integer from the inputTextField
                int guess = Integer.parseInt( inputTextField.getText() );

                // check to see if the guess is correct
                if ( randomValue.isCorrectValue(guess) ) {
                    String guessStr = " guess";  // note space before word
                    if ( numberOfGuesses > 1 )
                        guessStr = " guesses";
                    resultLabel.setText("Correct in " + numberOfGuesses + guessStr );
                    inputTextField.setEnabled(false);  // no more inputs until new game
                    newGameButton.setEnabled(true);
                    return;
                }

                // if here then incorrect guess...
                int difference = randomValue.compareTo(guess);
                if ( difference > 0 ) // then random value > guess
                    resultLabel.setText( guess + " is too low" );
                else
                    resultLabel.setText( guess + " is too high" );
                inputTextField.setText( "" );  // clear the input field

            }
        });
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // reset number of guesses
                numberOfGuesses = 0;

                // reset the randomValue
                randomValue.setRandomValue();

                inputTextField.setText( "" );
                resultLabel.setText("Can you guess my new value?");
                inputTextField.setEnabled(true);  // allow a new round of guessing
                newGameButton.setEnabled(false);

            }
        });
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("The Guessing Game!"); //Makes the frame
        myFrame.setContentPane(new GuessingGameForm().panel1); //attaches the panel to the frame

        //sets up what happens when the frame is closed
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.pack(); //put everything in the frame
        myFrame.setVisible(true); //allows us to see the frame

    }

}
