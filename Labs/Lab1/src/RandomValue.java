public class RandomValue {

    // code section 1 - instance variables
    // create random number generator from Random class
    private java.util.Random rndGenerator = new java.util.Random();

    private int randomValue;
    public final static int NUMBER_OF_VALUES = 100;


    // code section 2 - public constructor
    public RandomValue() {
        // use random number generator to assign random number to randomValue field (variable)
        randomValue = rndGenerator.nextInt(NUMBER_OF_VALUES);
    }

    // code section 3 - getters and setters
    public void setRandomValue() {
        randomValue = rndGenerator.nextInt(NUMBER_OF_VALUES);
    }

    public void setRandomValue( int n ) {
        // check to see if the random number is between 0-99, inclusive
        if ( n < 0 || n >= NUMBER_OF_VALUES )
            return; // take no action - value out of range
        randomValue = n;
    }

    public int getRandomValue() {
        return randomValue;
    }

    // code section 4 - inquirers
    public boolean isCorrectValue( int value ) {
        // if the guess = randomValue, user guessed correctly
        if ( value == randomValue )
            return true;
        return false; // fall-through is necessary to make IDE happy...
    }

    // compareTo: returns < 0 if random value is less than passed value
    //                    > 0 if random value is greater than passed value
    //                      0 if random value equals passed value
    public int compareTo( int value ) {
        // determine if the guess is higher than, lower than or equal to the random number
        return randomValue - value;
    }

}
