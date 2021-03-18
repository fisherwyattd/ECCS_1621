import javax.swing.*;

public class Human extends Player {
    Human() {
        String input = JOptionPane.showInputDialog("Please enter your name:");
        if(input.length() > 0) { setName(input); }
        else { setName("Human"); }
    }
}
