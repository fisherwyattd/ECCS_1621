import java.util.*;
import java.io.*;

/**
 * This class will validate a list of phone numbers stored in a file. Valid numbers are not formatted,
 * contain 10 digits and do not start with 0. Valid numbers from the list will be written to a different text file.
 *
 * @author Wyatt Fisher
 * @since 6 February 2021
 */
public class PhoneNumberValidator {

    public static void main(String[] args) throws FileNotFoundException {
        String inputNumStr;

        try {
            File inFile = new File("allNumbers.txt");
            Scanner inputScanner = new Scanner(inFile);

            PrintWriter outFile = new PrintWriter("validNumbers.txt");

            while(inputScanner.hasNext()) {
                inputNumStr = inputScanner.nextLine();

                try {
                    if (isValidNumber(Long.parseLong(inputNumStr)) && (inputNumStr.charAt(0) != '0') &&
                            (inputNumStr.charAt(0) != '+') && (inputNumStr.charAt(0) != '-'))
                        outFile.println(inputNumStr);
                } catch(NumberFormatException e1) {
                    System.out.println("Error: cannot be parsed to a long.");
                }
            }

            inputScanner.close();
            outFile.close();

        } catch(FileNotFoundException e) {
            System.out.println("Error: file not found.");
        }
    }


    public static boolean isValidNumber(long inputNum) {
        if((inputNum / 1000000000) >= 1)
            return true;
        else
            return false;
    }
}
