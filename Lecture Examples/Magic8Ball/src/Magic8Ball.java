import javax.swing.*;
import java.util.*;
import java.io.*;

public class Magic8Ball {
    private ArrayList<String> responses = new ArrayList<String>();

    public Magic8Ball(){
        try {
            File myFile = new File("src/Responses.txt");
            Scanner inFile = new Scanner(myFile);

            while(inFile.hasNext()){
                responses.add(inFile.nextLine());
            }
        } catch(FileNotFoundException e){
            System.out.println("File not found...");
        }
    }

    public String chooseResponse(){
        Random rand = new Random();

        return responses.get(rand.nextInt(responses.size()));
    }

    public static void main(String[] args) {
        Magic8Ball newBall = new Magic8Ball();
        String userInput = "  ";

        do {
            userInput = JOptionPane.showInputDialog("Enter your question now or Q to quit...");

            if(userInput.length() == 1)
                break;
            JOptionPane.showMessageDialog(null,"My answer is... " + newBall.chooseResponse());
        } while(userInput.length() > 1);
    }
}
