import javax.swing.*;

public class Player {
    enum Actions { rock, paper, scissors }

    private String name;
    private int roundsWon;
    private Actions action;

    Player() {}

    Player(String name) { this.name = name; }

    public void setName(String name) { this.name = name; }

    public String getName() { return this.name; }

    public int getRoundsWon() { return roundsWon; }

    public void setAction(Actions action) { this.action = action; }

    public void setAction() {
        String input = JOptionPane.showInputDialog("Rock, Paper, or Scissors?");
        if(Character.toLowerCase(input.charAt(0)) == 'r') {
            this.action = Actions.rock;
        }
        else if(Character.toLowerCase(input.charAt(0)) == 'p') {
            this.action = Actions.paper;
        }
        else if(Character.toLowerCase(input.charAt(0)) == 's') {
            this.action = Actions.scissors;
        }
    }

    public Actions getAction() { return action; }

    public void hasWon() { this.roundsWon++; }

    public static void main(String[] args) {
        Human human = new Human();
        Computer computer = new Computer();

        // string for getting input for whether or not to keep on playing
        String input = "n";

        do {
            // get the actions from both players
            human.setAction();
            computer.setAction();

            // display what each player chose as their action
            JOptionPane.showMessageDialog(null, computer.getName() + " chose " +
                    computer.getAction() + "\n" + human.getName() + " chose " + human.getAction());

            // if both player chose the same action, it is a tie
            if(human.getAction().equals(computer.getAction())) {
                input = JOptionPane.showInputDialog("Tie game!\n" + "Current scores:\n" + computer.getName() +
                        ": " + computer.getRoundsWon() + ", " + human.getName() + ": " + human.getRoundsWon() +
                        "\nPlay another? (y/n)");
            }

            // if the human's action is higher in the enum or they chose rock and the computer chose scissors, they win
            // this is true unless the human chose scissors and the computer chose rock
            else if((human.getAction().compareTo(computer.getAction()) > 0 && !(human.getAction() == Actions.scissors &&
                    computer.getAction() == Actions.rock)) | (human.getAction() == Actions.rock &&
                    computer.getAction() == Actions.scissors)) {

                // update the human's score
                human.hasWon();

                // give the result and score update, then ask if the player wants to play again
                input = JOptionPane.showInputDialog(human.getName() + " won!\n" + "Current scores:\n"+
                        computer.getName() + ": " + computer.getRoundsWon() + ", " + human.getName() + ": " +
                        human.getRoundsWon() + "\nPlay another? (y/n)");
            }
            else {
                // update the computer's score
                computer.hasWon();

                // give the result and score update, then ask if the player wants to play again
                input = JOptionPane.showInputDialog(computer.getName() + " won!\n" + "Current scores:\n"+
                        computer.getName() + ": " + computer.getRoundsWon() + ", " + human.getName() + ": " +
                        human.getRoundsWon() + "\nPlay another? (y/n)");
            }


        } while(Character.toLowerCase(input.charAt(0)) == 'y');
    }
}
