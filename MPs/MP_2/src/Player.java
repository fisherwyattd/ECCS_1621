import javax.swing.*;
import java.util.Random;


/**
 * This is the class that contains the methods and fields for the players of the Pig game.
 *
 * @author Wyatt Fisher
 * @since 22 February 2021
 */
public class Player {
    private String name = "player"; // initialized to player instead of null in case player does not enter anything
    private int turnScore;
    private int gameScore;

    // die rolling variables needed
    private Random rand = new Random();
    private final int NUMBER_OF_SIDES = 6;
    private final int NUMBER_OF_DICE = 2;
    private int[] myDiceSet = new int[NUMBER_OF_DICE + 1];


    /**
     * The rollDice method will perform the rolling of the individual die being displayed on each of the two JLabel
     * objects; (the returned value are to be used to update the game and turn scores, as well as the status variables
     * for the boolean-returning methods below).
     *
     * @param die1 The JLabel for die1.
     * @param die2 The JLabel for die2.
     * @return The sum of the die.
     */
    public int rollDie(JLabel die1, JLabel die2){
        // parse dice values extracted from the JLabel Icons
        myDiceSet[1] = Integer.parseInt("" + die1.getIcon().toString().charAt(99));
        myDiceSet[2] = Integer.parseInt("" + die2.getIcon().toString().charAt(99));

        // integer to keep track of the current sum
        int sum = myDiceSet[1] + myDiceSet[2];

        // add the values together to get the roll total and update turnScore
        turnScore += sum;

        // see if either the game or turn scores are lost
        if(isGameScoreLost()) {
            // if the game score is lost, clear the game and turn scores
            gameScore = 0;
            turnScore = 0;

            // return -100 to let the form know that the player lost their game score (for message)
            return -100;
        }
        else if(isTurnScoreLost()) {
            // if the turn score is lost, clear the turn score
            turnScore = 0;

            // return -50 to let the form know that the player lost their turn score (for message)
            return -50;
        }

        return sum;
    }


    /**
     * Returns true if the result of the roll causes the player to lose the turn, false otherwise.
     * If a single 1 is rolled, the player’s score for the current turn is lost
     * (i.e., it is set to zero) and the turn ends.
     *
     * @return True if the result of the roll causes the player to lose the turn, false otherwise.
     */
    public boolean isTurnScoreLost(){
        // check to see if either die value is 1
        if(myDiceSet[1] == 1 || myDiceSet[2] == 1) { return true; }
        else { return false; }
    }


    /**
     * Returns true if the result of the roll causes the player to lose both the turn and all points accumulated
     * in the game, false otherwise. If two 1’s are rolled, the player’s score for the entire game is lost
     * (i.e., it is set to zero) and the turn ends.
     *
     * @return True if the result of the roll causes the player to lose both the turn and all points accumulated
     * in the game, false otherwise.
     */
    public boolean isGameScoreLost(){
        // check to see if both die values are 1
        if(myDiceSet[1] == 1 && myDiceSet[2] == 1) { return true; }
        else { return false; }
    }


    /**
     * Returns true if the player has scored at least 100 points, false otherwise.
     *
     * @return True if the player has scored at least 100 points, false otherwise.
     */
    public boolean hasWon(){
        if(gameScore >= 100) { return true; }
        else { return false; }
    }


    /**
     * This method is to be called ONLY when a player finishes his/her turn.
     * Returns true if the value of the game score changes as a result of the operation.
     *
     * @return True if the value of the game score changes as a result of the operation.
     */
    public boolean addTurnScoreToGameScore(){
        // if the player scored any points, update the game score and reset the turn score
        if(turnScore > 0) {
            gameScore += turnScore;
            turnScore = 0;
            return true;
        }
        else { return false; }
    }


    /**
     * This returns the player's current turn score.
     *
     * @return Player's current turn score.
     */
    public int getTurnScore(){
        return turnScore;
    }


    /**
     * This returns the player's current game score.
     *
     * @return Player's current game score.
     */
    public int getGameScore(){
        return gameScore;
    }


    /**
     * Resets the player’s turn and game scores to zero, primarily for use in starting a new game.
     */
    public void reset(){
        turnScore = 0;
        gameScore = 0;
    }


    /**
     * Sets the player's name and saves as a string.
     *
     * @param name The player's name.
     */
    public void setName(String name){
        if(name.length() > 0)
            this.name = name;
    }


    /**
     * Gets the player's name.
     *
     * @return The player's name.
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the result of rolling die 1.
     * @return The value of die 1.
     */
    public int getDie1Value(){
        return myDiceSet[1];
    }


    /**
     * Returns the result of rolling die 2.
     * @return The value of die 2.
     */
    public int getDie2Value(){
        return myDiceSet[2];
    }
}
