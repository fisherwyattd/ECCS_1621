import java.util.Random;

public class Computer extends Player {
    Computer() {
        super("Computer");
    }

    @Override
    public void setAction() {
        Random rand = new Random();
        int optionNum = rand.nextInt(3);

        switch (optionNum) {
            case 0:
                this.setAction(Actions.rock);
                break;
            case 1:
                this.setAction(Actions.paper);
                break;
            case 2:
                this.setAction(Actions.scissors);
                break;
        }
    }
}
