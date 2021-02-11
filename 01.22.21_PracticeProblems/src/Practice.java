public class Practice {

    // 2. For each data type presented, create a variable & give it a correct initial value.
    private byte exampleByte = 12;
    private short exampleShort = 1022;
    private int exampleInt = 34527;
    private long exampleLong = 95403L;
    private float exampleFloat = 3958.2023F;
    private double exampleDouble = 35145.156541;
    private boolean exampleBool = false;
    private char exampleChar = 'g';
    private static String exampleString = "This is an example";

    // 3. Review: Which of the following are invalid identifiers. If invalid, why?
    /*
        $price                  - valid
        _my_variable            - valid
        007BondJames            - invalid; cannot begin with a number
        pixarForTheWin          - valid
        My_excellent_variable   - valid
        Quick Brown Fox         - invalid; cannot contain spaces
        ()testingFunc           - invalid; cannot contain "(" or ")"
    */

    // 4. Create a constant variable of type double for pi to the 5th decimal place.
    private final double PI = 3.14159; // could use: private static final double PI = 3.14159;

    // 5. Write example code of a method found in the String class.
    // This code should demonstrate the functionality (when run).
    public static void main(String[] args) {
        System.out.println("The string is " + exampleString.length() + " characters long.");
        if (exampleString.contains("a")) {
            System.out.println("The string contains the letter 'a'.");
        }
    }
}
