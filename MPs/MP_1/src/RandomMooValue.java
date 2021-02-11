import java.lang.Math;

/**Creates a 4-digit secret value (0000 through 9999) for a player to guess. Feedback is returned in the form of big
 * and little moos. Each "MOO!" indicates a digit correctly guessed in both value and position. Each "moo." indicates
 * a digit correctly guessed in terms of value, but not position. If no digits are correctly guessed, then all the user
 * hears are cowbells... Please note that the number generated by the program can be any four-digit number: it can have
 * leading zeros, it can have multiple instances of the same digit, and so on. For example, the following values are
 * all possible: 0000, 0123, 3455, 7870. When generating big (MOO!) and little (moo.) moos, each guessed digit can only
 * match at most one digit in the secret value. For example, if the secret value is 0055 and the user's guess is 5550,
 * our favorite cow should be uttering "MOO! moo. moo." as there is an exact matching digit position 3, plus two
 * inexact matches.
 *
 * @author Wyatt Fisher
 * @since 27 January 2021
 */
public class RandomMooValue {
    // private fields to be used in the methods below
    private static final int MIN_SECRET_NUMBER = 0;
    private static final int MAX_SECRET_NUMBER = 10000;
    private static final int NUMBER_OF_DIGITS = 4;
    private int secretValue;
    private int[] bigMooLocations = new int[NUMBER_OF_DIGITS];
    private int[] littleMooLocations = new int[NUMBER_OF_DIGITS];
    private String formattedSecretValue;
    private String formattedGuessValue;
    private int playerGuess;


    /**Creates a new RandomMooValue object containing a secret value to be guessed.
     */
    public RandomMooValue() {
        // set the secret value
        setSecretValue();
    }


    /**Generates a new secret value to be guessed in a game of LaurieMOO.
     * @return true in all cases.
     */
    public boolean setSecretValue() {
        // create the random value between 0000-9999, inclusive, and cast it to an int
        secretValue = (int)(Math.random() * (MAX_SECRET_NUMBER - MIN_SECRET_NUMBER + 1) + MIN_SECRET_NUMBER);

        // format the value with leading zeroes for display
        formattedSecretValue = formatValue(secretValue);

        return true;
    }


    /**Sets the "secret" value to be guessed in a game of LaurieMOO to a known 4-digit quantity.
     * This method is for testing purposes only.
     * @param n The number that will be set as the secret value, if it is within the inclusive range of 0000-9999.
     * @return true if the secret value was reset; false if the passed value was outside of the allowed range of values.
     */
    public boolean setSecretValue(int n) {
        // check to see that the entered value is inside the allowed range
        if ((n >= MIN_SECRET_NUMBER) && (n < MAX_SECRET_NUMBER)) {
            secretValue = n;

            // format the value with leading zeroes for display
            formattedSecretValue = formatValue(secretValue);

            return true;
        }
        else return false;
    }


    /**Access the secret value that the user is trying to guess, primarily to show the user after
     * running out of guesses.
     * @return the secret value that the user is/was attempting to guess.
     */
    public int getSecretValue() { return secretValue; }


    /**The number of digits in the user's guess that exactly (i.e., same position) matches digits in the secret value.
     * @param guess The number that the user guessed.
     * @return a number 0-4 representing how many digits the user guessed correctly by position.
     */
    public int getBigMooCount(int guess) {
        // count of number of big moos to be displayed
        int bigMooCount = 0;

        // reset bigMooLocations array
        for(int i = 0; i < NUMBER_OF_DIGITS; i++)
            bigMooLocations[i] = 0;

        /* compare each digit at each of the four positions to see if they match
           if they match, change the mooLocations value at that index to a 1*/
        for(int j = 0; j < NUMBER_OF_DIGITS; j++) {
            if(formattedGuessValue.charAt(j) == formattedSecretValue.charAt(j)) {
                bigMooCount++;
                bigMooLocations[j] = 1;
            }
        }

        return bigMooCount;
    }


    /**The number of digits in the user's guess that match digits in the secret value, but are not at the same position.
     * @param guess The number that the user guessed.
     * @return a number 0-4 representing how many of the guessed digits match, but are in different positions.
     *      Note that a guessed number cannot have any one digit generate both a "MOO!" and a "moo." as a result.
     */
    public int getLittleMooCount(int guess) {
        // count of number of little moos to be displayed
        int littleMooCount = 0;

        // reset littleMooLocations array
        for(int i = 0; i < NUMBER_OF_DIGITS; i++)
            littleMooLocations[i] = 0;

        // check to see if any digits from the guess match those in the secret value
        for (int i = 0; i < NUMBER_OF_DIGITS; i++){ // this for loop iterates through the guess digits
            for (int j = 0; j < NUMBER_OF_DIGITS; j++){ // this for loop iterates through the secret value digits

                /* if the digits are in different positions, have equal value, and neither digit has already
                   caused a big or little moo, this is the location of a new little moo digit */
                if ((i != j) && (formattedGuessValue.charAt(i) == formattedSecretValue.charAt(j)) &&
                        (bigMooLocations[j] == 0) && (bigMooLocations[i] == 0) && (littleMooLocations[j] == 0)) {
                    littleMooCount++;
                    littleMooLocations[j] = 1;
                    break;
                }
            }
        }

        return littleMooCount;
    }


    /**Determines if the user correctly guessed the secret value.
     * @param guess The number that the user guessed.
     * @return true if the guess is correct, false otherwise.
     */
    public boolean isCorrectGuess(int guess) {
        // first, format the guess value as a string
        formattedGuessValue = formatValue(guess);

        // check to see if the guess matches the secret value
        if (guess == secretValue)
            return true;
        else return false;
    }


    /**Adds leading zeroes to the secret value if it is less than four digits.
     * @param value The secret value to be formatted.
     * @return the string version of the formatted secret value.
     */
    public String formatValue(int value) {
        // convert the passed value to a string
        String formattedValue = Integer.toString(value);

        // if the value is not long enough as a string, add leading zeros for formatting
        while(formattedValue.length() < NUMBER_OF_DIGITS)
            formattedValue = ("0" + formattedValue);

        return formattedValue;
    }


    /**Sets the private variable playerGuess to the integer the player guesses.
     * @param guess The integer the player guessed.
     */
    public void setPlayerGuess(int guess) { playerGuess = (guess % MAX_SECRET_NUMBER); }


    /**Returns the player's guess as an integer.
     * @return the player's guess as an integer
     */
    public int getPlayerGuess() { return playerGuess; }
}