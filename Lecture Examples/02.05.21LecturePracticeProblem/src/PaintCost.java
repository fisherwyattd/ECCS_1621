import javax.swing.JOptionPane;

/**
 * <p>This program will ask the user to enter the area of wall they want painted.</p>
 * <p>It will then display:</p>
 * <ol>
 *     <li>The number of gallons needed</li>
 *     <li>The total cost of the paint</li>
 *     <li>The hours of labor needed</li>
 *     <li>The total charge for labor</li>
 * </ol>
 *
 * @author Wyatt Fisher
 * @since 6 February 2021
 */
public class PaintCost {
    private static final int GALLON_AREA_COVERAGE = 115;
    private static final double PAINT_COST = 37.99;
    private static final double PAINT_SPEED_RATE = (GALLON_AREA_COVERAGE / 8.0);
    private static final double RATE_PER_HOUR = 18.0;
    private static double gallonsNeededDbl;
    private static double userWallArea;


    public static void main(String[] args) {
        // try parsing the input to a double; if this is not possible, let the user know they entered an invalid number
        try{
            userWallArea = Double.parseDouble(JOptionPane.showInputDialog(null,
                    "Please enter the square feet of wall space you want painted."));

            // if parsing was successful, display the results of the calculations
            JOptionPane.showMessageDialog(null,
                    String.format("Number of gallons needed: %d\n" +
                                    "Total cost of paint: $%,.2f\n" +
                                    "Hours of labor needed: %,.2f hours\n" +
                                    "Total charge for labor: $%,.2f",
                                    gallonsNeeded(userWallArea), (gallonsNeeded(userWallArea) * PAINT_COST),
                                    hoursOfLabor(userWallArea), (hoursOfLabor(userWallArea) * RATE_PER_HOUR)));

        } catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Sorry, that is an invalid area.");
        }
    }

    /**
     * This method will calculate the number of gallons needed to cover the desired square feet of wall space.
     * It will round the number of gallons up to the nearest whole gallon.
     * @param wallArea The desired area of wall space to be painted.
     * @return The number of gallons needed, rounded up to the nearest whole gallon.
     */
    public static int gallonsNeeded(double wallArea) {
        gallonsNeededDbl = (wallArea / GALLON_AREA_COVERAGE);
        if((wallArea % GALLON_AREA_COVERAGE) == 0)
            return (int)(gallonsNeededDbl);
        else
            return ((int)gallonsNeededDbl + 1);
    }


    /**
     * This method will calculate the amount of hours of labor needed to paint the specified area
     * @param wallArea The area the user wants painted.
     * @return The number of hours of labor needed to paint the provided area.
     */
    public static double hoursOfLabor(double wallArea) {
        return (wallArea / PAINT_SPEED_RATE);
    }
}
