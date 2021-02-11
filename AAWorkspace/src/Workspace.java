import java.util.Scanner;
import javax.swing.JOptionPane;

public class Workspace {

    public String getChineseZodiacSign(int year) {
        switch ((year - 2021) % 12) {
            case 0:
                return "ox";
            case 1:
            case -11:
                return "tiger";
            case 2:
            case -10:
                return "rabbit";
            case 3:
            case -9:
                return "dragon";
            case 4:
            case -8:
                return "snake";
            case 5:
            case -7:
                return "horse";
            case 6:
            case -6:
                return "sheep";
            case 7:
            case -5:
                return "monkey";
            case 8:
            case -4:
                return "rooster";
            case 9:
            case -3:
                return "dog";
            case 10:
            case -2:
                return "pig";
            case 11:
            case -1:
                return "rat";
            default:
                return "none";
        }
    }


        public static void main(String[] args){
            Workspace testCase = new Workspace();
            boolean validInput = true;
            String yearAnimal;

            while(validInput) {
                try {
                    yearAnimal = testCase.getChineseZodiacSign(Integer.parseInt(
                            JOptionPane.showInputDialog(null, "Enter a year.")));
                    JOptionPane.showMessageDialog(null, "The animal for that year is: " +
                            yearAnimal + ".");

                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid year... qutting application.");
                    validInput = false;
                }
            }
        }
}
