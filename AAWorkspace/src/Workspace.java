import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Workspace {


    public static void main(String[] args){
        File inFile = new File("C:\\Users\\fishe\\Desktop\\CTF\\50k-users.txt");
        Scanner fileScan;
        try {
             fileScan = new Scanner(inFile);
            while(fileScan.hasNext()) {
                String username = fileScan.nextLine();
                if(username.charAt(2) == 'x') {
                    if(username.charAt(3) == '2' | username.charAt(3) == '3' | username.charAt(3) == '4' |
                            username.charAt(3) == '5' | username.charAt(3) == '6') {
                        System.out.println(username);
                    }
                }
            }
        } catch(FileNotFoundException e){
            System.out.print("File not found.");
        }


    }
}
