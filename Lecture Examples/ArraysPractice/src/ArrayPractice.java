import javax.swing.JOptionPane;
import java.util.Arrays;

/**
 * ECCS 1621: Programming 2
 * @author Dr. Al-Haj
 *
 * <br>
 *     In this program, we will learn:
 *     <ol>
 *         <li> how to create arrays in Java </li>
 *         <li> how to access elements in an array </li>
 *         <li> passing arrays as parameters </li>
 *         <li> returning an array in a method </li>
 *     </ol>
 */

public class ArrayPractice {
/*
    public static void main(String[] args) {

        try {
            // get the array size from the user
            int arraySize = Integer.parseInt(JOptionPane.showInputDialog(null, " How many students are in the class? "));

            // to create an array, we use the following syntax:
             *   datatype square-brackets array-name = { put, your, data, list, here}
             *   or
             *   datatype square-brackets array-name = new datatype [ size ]


            int[] gradesArray = {5, 10, 8, 4};
            double[] grades = new double[arraySize];

            // try to change array size, will this work?
            // grades.length = 4;

            // input the grades using input dialog
            for(int i = 0 ; i < grades.length ; i++){
                try {
                    // check if grades are valid
                    grades[i] = Double.parseDouble(JOptionPane.showInputDialog("Enter grade # " + i));
                }
                // if there is an invalid grade, replace it with zero
                // --> notice that even we caught an error, we didn't exit/halt the program,
                // this is because we handled the exception inside the for loop, not outside the loop
                catch(NumberFormatException e2){
                    grades[i] = 0;
                    JOptionPane.showMessageDialog(null,
                            "Invalid grade, will be replaced by Zero",
                            "... Invalid Grade Detected ...",
                            JOptionPane.WARNING_MESSAGE);

                }
            } // end for

            // a method to display grades
            displayArray(grades);

            // curveGrades(...) method adds a bonus integer to all grades, the result
            // is stored in the same array
            //curveGrades(grades, 3);

            // curveGradesArray(---) returns a new array
            double[] curvedGrades = curveGradesArray(grades, 5);

            displayArray(grades, "Non-curved Grades");
            displayArray(curvedGrades, "Curved Grades");

            // can we use toString() with arrays?
            JOptionPane.showMessageDialog(null, "Grades (using grades.toString() ): "+grades.toString());
            JOptionPane.showMessageDialog(null, "Grades (using Arrays.toString(grades) ): "+ Arrays.toString(grades));

            JOptionPane.showMessageDialog(null, "Non-curved Grades Average: "+averageGrade(grades));
            JOptionPane.showMessageDialog(null, "Curved Grades Average: "+averageGrade(curvedGrades));


        }
        catch(NumberFormatException e1){
            JOptionPane.showMessageDialog(null,
                    "Invalid Array Size ...",
                    "... STOP ...",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(NegativeArraySizeException negSizeException){
            JOptionPane.showMessageDialog(null,
                    "Array Size Can't be Negative...",
                    "... STOP ...",
                    JOptionPane.ERROR_MESSAGE);

        }

    }
*/

    /**
     * This method adds bonus value to all elements in the grades array,
     * the grades array will be updated.
     * I.e. Any changes on the parameter array in the method will be reflected
     * on the array in the method call.
     *
     * @param gr Original grades array
     * @param bonus The value to be added
     */
    public static void curveGrades(double[] gr, int bonus){
        for(int i = 0 ; i < gr.length ; i++){
            gr[i] += bonus;
        }
    }

    /**
     * This method adds bonus value to all elements in the grades array and store the result in a new array,
     * the grades array (@param gr in the parameters list) will be NOT be updated.
     *
     * @param gr Original grades array
     * @param bonus The value to be added
     * @return The curved grades
     */
    public static double[] curveGradesArray(double[] gr, int bonus){
        double[] newArray = new double[gr.length];
        for(int i = 0 ; i < gr.length ; i++){
            newArray[i] = gr[i] + bonus;
        }

        // the name of the array only is used to return the entire array
        return newArray;
    }

    /**
     * A method to display the contents of an array using a message dialog
     * @param arr The array to be displayed
     */
    public static void displayArray(double[] arr){
        // print array contents
        String resultMsg = "";
        for(int i = 0; i< arr.length ; i++){
            resultMsg += ("grade #" +i + " : "+arr[i]+"\n");
        }
        JOptionPane.showMessageDialog(null, resultMsg);
    }

    /**
     * Overloaded displayArray method, it changes the dialog title to the given title
     * @param arr The array to be displayed
     * @param windowTitle The Title for the dialog message
     */
    public static void displayArray(double[] arr, String windowTitle){
        // print array contents
        String resultMsg = "";
        for(int i = 0; i< arr.length ; i++){
            resultMsg += ("grade #" +i + " : "+arr[i]+"\n");
        }
        JOptionPane.showMessageDialog(null, resultMsg, windowTitle, JOptionPane.INFORMATION_MESSAGE);
    }

    public static double averageGrade(double[] arr){
        double total = 0.0;
        double average = 0.0;

        for(double dbl : arr){
            total += dbl;
        }

        average = total / arr.length;
        return average;
    }
}
