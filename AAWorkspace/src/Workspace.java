import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Workspace {
    private static int numberOfYes = 0;
    private static final long NUMBER_OF_TRIALS = 10000000L;


    public static void pickBalls() {
        int numberOfBlue = 3;

        Random rand = new Random();

        int result1 = rand.nextInt(12) + 1;
        int result2 = rand.nextInt(12) + 1;

        while(result1 == result2) {
            result2 = rand.nextInt(12) + 1;
        }
        
        if((result1 > numberOfBlue) && (result2 > numberOfBlue)) { numberOfYes++; }
    }

    public static void getProbability() {
        numberOfYes = 0;

        for(int i = 0; i < NUMBER_OF_TRIALS; i++) {
            Workspace.pickBalls();
        }

        System.out.println("Probability of yes: " + ((double)numberOfYes / NUMBER_OF_TRIALS));
    }

    public static void main(String[] args){
        getProbability();
        getProbability();
        getProbability();
        getProbability();
        getProbability();
        getProbability();
        getProbability();
        getProbability();
        getProbability();
        getProbability();


    }
}
