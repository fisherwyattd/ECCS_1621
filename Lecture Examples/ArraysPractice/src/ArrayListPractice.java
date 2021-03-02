import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * ECCS 1621: Programming 2
 * @author Dr. Al-Haj
 *
 * <br>
 *     In this program, we will learn:
 *     <ol>
 *         <li> how to create ArrayLists in Java </li>
 *         <li> how to access elements in an ArrayList </li>
 *         <li> passing ArrayLists as parameters </li>
 *         <li> returning an ArrayList in a method </li>
 *         <li> using some ArrayLists methods </li>
 *     </ol>
 *
 * <br>
 *     <b>
 *     Note:
 *     Enhanced for each loops cannot be used in all situations.
 *     Only use for-each loops when you want to loop through all the values in an array without changing their values.
 *     <ul>
 *         <li> Do not use for each loops if you need the index </li>
 *         <li> Do not use for each loops if you need to change the values in the array </li>
 *         <li> Do not use for each loops if you need to change the values in the array </li>
 *         <li> Do not use for each loops if you want to loop through only part of an array or in a different order </li>
 *     </ul>
 *     </b>
 *
 */

public class ArrayListPractice {

    public static void main(String[] args) {

        try {
            // get the array size from the user
            int arraySize = Integer.parseInt(JOptionPane.showInputDialog(null, " How many students are in the class? "));

            ArrayList<Double> grades = new ArrayList<Double>();


            // input the grades using input dialog
            for(int i = 0 ; i < arraySize ; i++){
                try {
                    // check if grades are valid
                    grades.add( Double.parseDouble(JOptionPane.showInputDialog("Enter grade # " + i)) );
                }
                // if there is an invalid grade, replace it with zero
                // --> notice that even we caught an error, we didn't exit/halt the program,
                // this is because we handled the exception inside the for loop, not outside the loop
                catch(NumberFormatException e2){
                    grades.add(0.0);
                    JOptionPane.showMessageDialog(null,
                            "Invalid grade, will be replaced by Zero",
                            "... Invalid Grade Detected ...",
                            JOptionPane.WARNING_MESSAGE);

                }
            } // end for

            // a method to display grades
            displayArray(grades);

            //curveGrades(grades, 3);

            ArrayList<Double> curvedGrades = curveGradesArray(grades, 5);

            displayArray(grades, "Non-curved Grades");
            displayArray(curvedGrades, "Curved Grades");

            // sorted ArrayList:
            curvedGrades.sort(Comparator.naturalOrder());
            displayArray(curvedGrades, "Sorted Curved Grades");

            // can we use toString() with arrays?
            JOptionPane.showMessageDialog(null, "Grades (using grades.toString() ): "+curvedGrades.toString());

            JOptionPane.showMessageDialog(null, "Non-curved Average Grade: "+averageGrade(grades));
            JOptionPane.showMessageDialog(null, "Curved Average Grade: "+averageGrade(curvedGrades));


        }
        catch(NumberFormatException e1){
            JOptionPane.showMessageDialog(null,
                    "Invalid Array Size ...",
                    "... STOP ...",
                    JOptionPane.ERROR_MESSAGE);
        }
        catch(NegativeArraySizeException negativeArraySizeException){
            JOptionPane.showMessageDialog(null,
                    "Array Size Can't be Negative...",
                    "... STOP ...",
                    JOptionPane.ERROR_MESSAGE);

        }

    }

    /**
     * This method adds bonus value to all elements in the grades arraylist,
     * the grades arraylist will be updated.
     * I.e. Any changes on the parameter arraylist in the method will be reflected
     * on the arraylist in the method call.
     *
     * @param gr Original grades arraylist
     * @param bonus The value to be added
     */
    public static void curveGrades(ArrayList<Double> gr, int bonus){

        // in arrays, we use arrayName.length
        // in ArrayLists, we use arrayName.size()

        for(int i = 0; i < gr.size(); i++){
            gr.set(i, gr.get(i)+bonus);
        }

        /* this will not work to update ArrayList values
         for(Double d: gr){
            d += bonus;
        }
         */
    }

    /**
     * This method adds bonus value to all elements in the grades arraylist and store the result in a new arraylist,
     * the grades arraylist (@param gr in the parameters list) will be NOT updated.
     *
     * @param gr Original grades arraylist
     * @param bonus The value to be added
     * @return The curved grades
     */
    public static ArrayList<Double> curveGradesArray(ArrayList<Double> gr, int bonus){
        ArrayList<Double> newArrayList = new ArrayList<Double>();
        /*
        for(int i = 0 ; i < gr.size() ; i++){
            newArrayList.add(gr.get(i) + bonus);
        }
        */

        // Another way using the enhanced for loop
        for(Double d : gr){
            newArrayList.add(d+bonus);
        }

        // the name of the array only is used to return the entire array
        return newArrayList;
    }

    /**
     * A method to display the contents of an arraylist using a message dialog
     * @param arr The array to be displayed
     */
    public static void displayArray(ArrayList<Double> arr){
        // print array contents
        String resultMsg = "";
        for(int i = 0; i< arr.size() ; i++){
            resultMsg += ("grade #" +i + " : "+arr.get(i)+"\n");
        }
        JOptionPane.showMessageDialog(null, resultMsg);
    }

    /**
     * Overloaded displayArray method, it changes the dialog title to the given title
     * @param arr The arraylist to be displayed
     * @param windowTitle The Title for the dialog message
     */
    public static void displayArray(ArrayList<Double> arr, String windowTitle){
        // print array contents
        String resultMsg = "";
        for(int i = 0; i < arr.size() ; i++){
            resultMsg += ("grade #" +i + " : "+arr.get(i)+"\n");
        }
        JOptionPane.showMessageDialog(null, resultMsg, windowTitle, JOptionPane.INFORMATION_MESSAGE);
    }

    public static double averageGrade(ArrayList<Double> arr){
        double total = 0.0;
        double average = 0.0;

        for(double dbl : arr){
            total += dbl;
        }

        average = total / arr.size();
        return average;
    }
}


