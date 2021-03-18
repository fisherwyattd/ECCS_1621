import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * PigGameForm.java class file.
 * This is the class that contains the methods and fields for game part of the Pig dice game.
 * Includes action listeners for the "Roll" and "Stop" buttons and the dice animation functionality.
 * Also includes the main method for the project.
 *
 * @author Wyatt Fisher
 * @since 22 February 2021
 */
public class PigGameForm {
    // instance variables for the class
    private Random rand = new Random();
    private int dieValue = 6;
    private final int NUMBER_OF_SIDES = 6;
    private final int NUMBER_OF_DICE = 2;
    private ImageIcon[] dieImage = new ImageIcon[NUMBER_OF_SIDES + 1];
    private int[] myDiceSet = new int[NUMBER_OF_DICE + 1];
    Player[] playerArr = new Player[2]; // array of the two players
    int currentPlayer = 0; // use an int to keep track of whose turn it is

    // instance data members for use with animating the die
    private boolean           isDieAnimated   = true;  // assume that user wants animated die
    private final static int  DELAY           = 150;   // time between successive images in ms
    private final static int  FRAME_COUNT_MAX = 12;     // maximum number of frames to show
    private final static int  FRAME_COUNT_MIN = 8;     // minimum number of frames to show
    private int               frameCount      = 0;     // current frame count
    private int               frameCountLimit = 0;     // total frames to show for an animation
    private Timer             animationTimer;          // animation actionEvent generator
    private boolean           isClickable     = false;  // blocks mouse events during animation
    private boolean[] isDieBeingHeld = new boolean[NUMBER_OF_DICE + 1];// tracks whether die is being held

    // JPanel elements from the GUI
    private JPanel panel1;
    private JButton rollButton;
    private JButton stopButton;
    private JLabel gameTitleLabel;
    private JLabel player1NameLabel;
    private JLabel player1ScoreLabel;
    private JLabel playerMessageLabel;
    private JLabel player2NameLabel;
    private JLabel player2ScoreLabel;
    private JLabel die1Label;
    private JLabel die2Label;


    /**
     * Constructor of the PigGameForm class. Includes all action listeners from the form.
     */
    public PigGameForm(){
        // set isDieBeingHeld array to all false
        for(int i = 1; i <= NUMBER_OF_DICE; i++) {
            isDieBeingHeld[i] = false;
        }

        // prepare the dice
        for(int i = 1; i <= NUMBER_OF_SIDES; i ++) {
            String filename = "/images/die" + i + ".gif";
            dieImage[i] = new ImageIcon(this.getClass().getResource(filename));
        }

        // set up the animation timer
        animationTimer = new Timer(DELAY, new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animationTimerActionPerformed(evt);
            }
        });

        // counters are used to control the number of times the Timer repeats
        animationTimer.setRepeats(false);


        // initialize the player objects
        playerArr[0] = new Player();
        playerArr[1] = new Player();

        // get player names
        playerArr[0].setName(JOptionPane.showInputDialog("Enter Player 1 Name..."));
        playerArr[1].setName(JOptionPane.showInputDialog("Enter Player 2 Name..."));

        // set the player names on their JLabels
        player1NameLabel.setText(playerArr[0].getName());
        player2NameLabel.setText(playerArr[1].getName());


        // begin the game!
        // tell player1 to begin their turn by rolling
        playerMessageLabel.setText(playerArr[currentPlayer].getName() + ", press \"Roll\" to begin your turn.");

        // change the color of the current player's name and score
        player1NameLabel.setText("<html><font color='red'>" + playerArr[0].getName() + "</font></html>");
        player1ScoreLabel.setText("<html><font color='red'>" + playerArr[0].getGameScore() + "</font></html>");

        // set player2's colors back to black
        player2NameLabel.setText("<html><font color='black'>" + playerArr[1].getName() + "</font></html>");
        player2ScoreLabel.setText("<html><font color='black'>" + playerArr[1].getGameScore() + "</font></html>");


        // action listeners section below
        rollButton.addActionListener(new ActionListener() {
            /**
             * Invoked when the roll button is pressed.
             *
             * @param e The event to be processed.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // initialize the frame counting variables for this roll
                frameCount = 0;
                int range = FRAME_COUNT_MAX - FRAME_COUNT_MIN + 1;
                frameCountLimit = FRAME_COUNT_MIN + rand.nextInt(range);

                // "roll" the die and start the animation if we're to do so
                dieValue = rand.nextInt(NUMBER_OF_SIDES) + 1;
                if(isDieAnimated) {animationTimer.start();}
                else {
                    die1Label.setIcon(dieImage[myDiceSet[1]]);
                    die2Label.setIcon(dieImage[myDiceSet[2]]);
                }

                // disable the Roll and Stop buttons so the user has to wait for the animation
                rollButton.setEnabled(false);
                stopButton.setEnabled(false);
            }
        });

        stopButton.addActionListener(new ActionListener() {
            /**
             * Invoked when the stop button is pressed.
             *
             * @param e The event to be processed.
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                // rename the Stop button to make it say "Stop"
                stopButton.setText("Stop");

                // update the player's game score accordingly
                playerArr[currentPlayer].addTurnScoreToGameScore();

                // re-enable the Roll button
                rollButton.setEnabled(true);

                // check to see if the active player just won the game
                if(playerArr[currentPlayer].hasWon()) { // if the player just won the game
                    // tell the player how many points they have and that they just won
                    playerMessageLabel.setText(playerArr[currentPlayer].getName() +
                            " has " + playerArr[currentPlayer].getGameScore() + " points and just won the game!");

                    // disable both buttons
                    rollButton.setEnabled(false);
                    stopButton.setEnabled(false);

                    // update final game scores
                    if(currentPlayer == 0) {
                        // update player1's game score and set color to red
                        player1ScoreLabel.setText("<html><font color='red'>" + playerArr[0].getGameScore() +
                                "</font></html>");
                    }
                    else {
                        // update player2's game score and set color to red
                        player2ScoreLabel.setText("<html><font color='red'>" + playerArr[1].getGameScore() +
                                "</font></html>");
                    }

                    // ask players if they want to play another game
                    String input = JOptionPane.showInputDialog("<html><p>" + playerArr[currentPlayer].getName() +
                            " won the game with " + playerArr[currentPlayer].getGameScore() + " points!</p>" +
                            "<p>Play another game? (Y/N)</p></html>");

                    // if they want to play another game
                    if(input.charAt(0) == 'Y' || input.charAt(0) == 'y') {
                        // enable the stop button
                        stopButton.setEnabled(true);

                        // rename the Stop button to make it "Start a New Game"
                        stopButton.setText("Start a New Game");

                        // reset the player scores
                        playerArr[0].reset();
                        playerArr[1].reset();
                    }
                    else {
                        // tell the players that the game will now end
                        JOptionPane.showMessageDialog(null,
                                "<html><p>Okay! Thanks for playing.</p>" +
                                        "<p>Program will now terminate...</p></html>");

                        // terminate the game
                        System.exit(0);
                    }
                }

                else { // if the player did not just win the game
                    // check to see which player is the current player and update labels accordingly
                    if (currentPlayer == 0) {
                        // switch players
                        currentPlayer = 1;

                        // tell player2 to begin their turn by rolling
                        playerMessageLabel.setText(playerArr[currentPlayer].getName() +
                                ", press \"Roll\" to begin your turn.");

                        // change the color of player1's name and score
                        player1NameLabel.setText("<html><font color='black'>" + playerArr[0].getName() +
                                "</font></html>");
                        player1ScoreLabel.setText("<html><font color='black'>" + playerArr[0].getGameScore() +
                                "</font></html>");

                        // set player2's colors to red because it is now their turn
                        player2NameLabel.setText("<html><font color='red'>" + playerArr[1].getName() +
                                "</font></html>");
                        player2ScoreLabel.setText("<html><font color='red'>" + playerArr[1].getGameScore() +
                                "</font></html>");
                    } else {
                        // switch players
                        currentPlayer = 0;

                        // tell player1 to begin their turn by rolling
                        playerMessageLabel.setText(playerArr[currentPlayer].getName() +
                                ", press \"Roll\" to begin your turn.");

                        // change the color of the current player's name and score
                        player1NameLabel.setText("<html><font color='red'>" + playerArr[0].getName() +
                                "</font></html>");
                        player1ScoreLabel.setText("<html><font color='red'>" + playerArr[0].getGameScore() +
                                "</font></html>");

                        // set player2's colors back to black
                        player2NameLabel.setText("<html><font color='black'>" + playerArr[1].getName() +
                                "</font></html>");
                        player2ScoreLabel.setText("<html><font color='black'>" + playerArr[1].getGameScore() +
                                "</font></html>");
                    }
                }
            }
        });
    }

    /**
     * This method handles timer events. It also contains the functionality that occurs when the "Roll" button is
     * pressed, including calling the rollDie function from the Player class and seeing if either the game or turn
     * scores are lost as a result of the roll.
     *
     * @param evt The action event that occurred.
     */
    private void animationTimerActionPerformed(java.awt.event.ActionEvent evt) {
        isClickable = false;    // prevent mouse click events from messing things up...
        frameCount++;           // increment the animation frame counter

        // if we reached our limit, display the true value and restore mouse events;
        // otherwise, show some random value...
        if (frameCount < frameCountLimit) {
            for (int i = 1; i <= NUMBER_OF_DICE; i++) {
                if (isDieBeingHeld[i] == false) {myDiceSet[i] = rand.nextInt(NUMBER_OF_SIDES) + 1;}
                if (isDieBeingHeld[1] == false) {die1Label.setIcon(dieImage[myDiceSet[1]]);}
                if (isDieBeingHeld[2] == false) {die2Label.setIcon(dieImage[myDiceSet[2]]);}
                animationTimer.start();
            }
        }
        else {
            int diceTotal = 0;
            for (int i = 1; i <= NUMBER_OF_DICE; i++) {
                diceTotal += myDiceSet[i];
            }

            // enable the stop button now for all cases
            stopButton.setEnabled(true);

            // call the rollDie function for the current player
            int sum = playerArr[currentPlayer].rollDice(die1Label, die2Label);

            // update the JLabels to display the result of the die being rolled
            die1Label.setIcon(dieImage[playerArr[currentPlayer].getDie1Value()]);
            die2Label.setIcon(dieImage[playerArr[currentPlayer].getDie2Value()]);

            // check to see if the player will be forced to end their turn (if they rolled at least a single one)
            if(playerArr[currentPlayer].isGameScoreLost()) {
                playerMessageLabel.setText("<html><p>" + playerArr[currentPlayer].getName() + " rolled two ones!" +
                        "</p><p>You lose your game score and your turn ends.</p>" +
                        "<p>Press \"Stop\" to continue playing.</p></html>");

                // disable the Roll button so the user is forced to end their turn
                rollButton.setEnabled(false);
            }
            else if(playerArr[currentPlayer].isTurnScoreLost()) {
                playerMessageLabel.setText("<html><p>" + playerArr[currentPlayer].getName() + " rolled a one!" +
                        "</p><p>You lose your turn score and your turn ends.</p>" +
                        "<p>Press \"Stop\" to continue playing.</p></html>");

                // disable the Roll button so the user is forced to end their turn
                rollButton.setEnabled(false);
            }
            else {
                // display the current player's turn score and ask if they want to roll again
                playerMessageLabel.setText(playerArr[currentPlayer].getName() + " has " +
                        playerArr[currentPlayer].getTurnScore() + " points this turn. Roll or Stop?");

                // enable the Roll button so the user can make their decision
                rollButton.setEnabled(true);
            }

            // set the Icon for the dieLabels
            if(isDieBeingHeld[1] == false) {die1Label.setIcon(dieImage[myDiceSet[1]]);}
            if(isDieBeingHeld[2] == false) {die2Label.setIcon(dieImage[myDiceSet[2]]);}

            // make sure the players can't hold the dice values
            isClickable = false;
        }
    }


    /**
     * Sets the animation state of the dice.
     * @param animationState Whether or not the die are animated.
     */
    public void setAnimation(boolean animationState) {
        isDieAnimated = animationState;
    }


    /**
     * Gets whether or not the dice are animated.
     * @return True if the dice are animated, false otherwise.
     */
    public boolean isAnimated() {
        return isDieAnimated;
    }


    public static void main(String[] args) {
        // makes the frame for the GUI
        JFrame myFrame = new JFrame("Welcome to Roll'em Pigs!");

        // attaches the panel to the frame
        myFrame.setContentPane(new PigGameForm().panel1);

        // resize the GUI window
        myFrame.setPreferredSize(new Dimension(500,400));

        // sets up what happens when the frame is closed
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // put everything in the frame
        myFrame.pack();

        // allows us to see the frame
        myFrame.setVisible(true);
    }
}
