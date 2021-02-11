import java.io.* ;
import java.util.Scanner;

/**
 * ECCS 1621: Programming 2
 * @author Dr. Al-Haj
 * @since February 2021
 *
 * <br><b>
 *     This is a simple Java program to demonstrate the following:<br>
 *     <ol>
 *         <li> Read/write data from/to file </li>
 *         <li> Use try / catch to handle exceptions </li>
 *         <li> Validate input data given in a file </li>
 *         <li> Learn some HTML tags </li>
 *     </ol>
 *     </b>
 * <br>
 *     <b>
 *         Note: when you process a file, you need to provide the file name. If you provide the file name only,
 *         it is assumed to be located in the active directory of the Java project. Otherwise, you must provide
 *         the absolute file for the path. Keep in mind that directory structures are different across different
 *         operating systems.
 *     </b>
 */


public class LearnFileProcessing {

    /** Part 1: A new file is created in the active project directory
     * This method demonstrates the tree steps to write to a files:
     * 1. open the file and create a connection to the physical file
     * 2. process the file
     * 3. close the file
     *
     * @throws IOException if stream to file cannot be written to or closed.
     */
    public void part1() throws IOException{
        PrintWriter outputFile = new PrintWriter("eccs1621students.txt");
        outputFile.println("Tim");
        outputFile.println("Kim");
        outputFile.println("Jim");

        outputFile.close();
    }

    //--------------------------------------------------------------------

    // Part 2: Using the absolute path with the file name
    public void part2() throws IOException{

        // --> change this path to make it work on your computer

        // The absolute path for the directory of the file to be processed is:
        //String documentsPath = "/Users/saeedal-haj/Documents/Java Text Files/";


        // This will provide the Documents path regardless of the operating system
        String documentsPath = System.getProperty ("user.home") + "/Documents/Java Text Files/";

        PrintWriter outputFile = new PrintWriter(documentsPath + "eccs1621students.txt");
        outputFile.println("Tim");
        outputFile.println("Kim");
        outputFile.println("Jim");

        outputFile.close();
    }

    //--------------------------------------------------------------------

    // Part 3: Reading from a file, line by line
    public void part3() throws IOException{
        String documentsPath = System.getProperty("user.home") + "/Documents/Java Text Files/";
        File myFile = new File(documentsPath + "eccs1621students.txt");

        Scanner inputFile = new Scanner(myFile);

        while (inputFile.hasNext()) {
            String line = inputFile.nextLine();
            System.out.println(line);

        }
        System.out.println("File has been processed! ");

        inputFile.close();

    }

    //--------------------------------------------------------------------
    // Part 4: Reading from a file, but the file does not exist!!
    public void part4() throws IOException{

        String documentsPath = System.getProperty("user.home") + "/Documents/Java Text Files/";
        File myFile = new File(documentsPath + "eccs1621students-2.txt");

        Scanner inputFile = new Scanner(myFile);

        while (inputFile.hasNext()) {
            String line = inputFile.nextLine();
            System.out.println(line);

        }
        System.out.println("File has been processed! ");

        inputFile.close();
    }

    //--------------------------------------------------------------------
    // Part 5: Reading from a file, but the file does not exist!!
    // Fixed using try and catch
    public void part5() throws IOException{

        try {
            String documentsPath = System.getProperty("user.home") + "/Documents/Java Text Files/";
            File myFile = new File(documentsPath + "eccs1621students-2.txt");

            Scanner inputFile = new Scanner(myFile);

            while (inputFile.hasNext()) {
                String line = inputFile.nextLine();
                System.out.println(line);

            }
            System.out.println("File has been processed! ");

            inputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found ... ");
        }
    }

    /**
     * The main program create an object called lesson from the class LearnFileProcessing
     * and calls five different methods.
     * <br>
     * Call every method my itself to see what happens.
     *
     *
     * @param args String array of arguments
     * @throws IOException if stream to file cannot be written to or closed.
     */
    public static void main(String[] args) throws IOException {

        // create an object from the LearnFileProcessing to be able to
        // call the methods part1 - part5
        LearnFileProcessing lesson = new LearnFileProcessing();

        // call the methods and learn new things:

        //lesson.part1();
        //lesson.part2();
        //lesson.part3();
        //lesson.part4();
        lesson.part5();

    }
}
