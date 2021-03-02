import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.*;

public class DieGame {
    // instance variables for the class
    private Random rand = new Random();
    private int dieValue = 6;
    private final int NUMBER_OF_SIDES = 6;
    private final int NUMBER_OF_DICE = 5;
    private ImageIcon[] dieImage = new ImageIcon[NUMBER_OF_SIDES + 1];
    private int[] myDiceSet = new int[NUMBER_OF_DICE + 1];


    // instance data members for use with animating the die
    private boolean           isDieAnimated   = true;  // assume that user wants animated die
    private final static int  DELAY           = 200;   // time between successive images in ms
    private final static int  FRAME_COUNT_MAX = 9;     // maximum number of frames to show
    private final static int  FRAME_COUNT_MIN = 5;     // minimum number of frames to show
    private int               frameCount      = 0;     // current frame count
    private int               frameCountLimit = 0;     // total frames to show for an animation
    private Timer             animationTimer;          // animation actionEvent generator
    private boolean           isClickable     = true;  // blocks mouse events during animation
    private boolean[] isDieBeingHeld = new boolean[NUMBER_OF_DICE + 1];// tracks whether die is being held


    // JPanel elements from the GUI
    private JButton rollTheDiceButton;
    private JPanel panel1;
    private JLabel resultLabel;
    private JLabel die1Label;
    private JLabel die2Label;
    private JLabel die3Label;
    private JLabel die4Label;
    private JLabel die5Label;


    /**
     * Constructor of the DieGame class. Includes all action listeners from the form.
     */
    public DieGame() {

        // prepare the dice
        for(int i = 1; i <= NUMBER_OF_SIDES; i ++) {
            String filename = "/images/die" + i + ".gif";
            dieImage[i] = new ImageIcon(this.getClass().getResource(filename));
        }

        // set isDieBeingHeld array to all false, change labels
        for(int i = 1; i <= NUMBER_OF_DICE; i++) {
            isDieBeingHeld[i] = false;
        }
        die1Label.setText(" ");
        die2Label.setText(" ");
        die3Label.setText(" ");
        die4Label.setText(" ");
        die5Label.setText(" ");

        // set up the animation timer
        animationTimer = new Timer( DELAY, new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                animationTimerActionPerformed(evt);
            }
        });

        // counters are used to control the number of times the Timer repeats
        animationTimer.setRepeats(false);


        // action listeners section below

        rollTheDiceButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e The event to be processed.
             */
            @Override
            public void actionPerformed(ActionEvent e) {

                // Reset the text in the result label for each roll
                resultLabel.setText("Score is...");

                // initialize the frame counting variables for this roll
                frameCount = 0;
                int       range = FRAME_COUNT_MAX - FRAME_COUNT_MIN + 1;
                frameCountLimit = FRAME_COUNT_MIN + rand.nextInt( range );

                // "roll" the die and start the animation if we're to do so
                dieValue = rand.nextInt( NUMBER_OF_SIDES ) + 1;
                if(isDieAnimated) { animationTimer.start(); }
                else {
                    die1Label.setIcon(dieImage[ myDiceSet[1] ]);
                    die2Label.setIcon(dieImage[ myDiceSet[2] ]);
                    die3Label.setIcon(dieImage[ myDiceSet[3] ]);
                    die4Label.setIcon(dieImage[ myDiceSet[4] ]);
                    die5Label.setIcon(dieImage[ myDiceSet[5] ]);
                }
            }
        });

        die1Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // this flips the text of the label when it is clicked by the mouse
                if(die1Label.getText().equals(" ")) {
                    die1Label.setText("Held");
                    isDieBeingHeld[1] = true;
                }
                else { die1Label.setText(" "); isDieBeingHeld[1] = false; }
            }
        });

        die2Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // this flips the text of the label when it is clicked by the mouse
                if(die2Label.getText().equals(" ")) {
                    die2Label.setText("Held");
                    isDieBeingHeld[2] = true;
                }
                else { die2Label.setText(" "); isDieBeingHeld[2] = false; }
            }
        });

        die3Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // this flips the text of the label when it is clicked by the mouse
                if(die3Label.getText().equals(" ")) {
                    die3Label.setText("Held");
                    isDieBeingHeld[3] = true;
                }
                else { die3Label.setText(" "); isDieBeingHeld[3] = false; }
            }
        });

        die4Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // this flips the text of the label when it is clicked by the mouse
                if(die4Label.getText().equals(" ")) {
                    die4Label.setText("Held");
                    isDieBeingHeld[4] = true;
                }
                else { die4Label.setText(" "); isDieBeingHeld[4] = false; }
            }
        });

        die5Label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                // this flips the text of the label when it is clicked by the mouse
                if(die5Label.getText().equals(" ")) {
                    die5Label.setText("Held");
                    isDieBeingHeld[5] = true;
                }
                else { die5Label.setText(" "); isDieBeingHeld[5] = false; }
            }
        });
    }


    private void animationTimerActionPerformed(java.awt.event.ActionEvent evt) {
        isClickable = false;    // prevent mouse click events from messing things up...
        frameCount++;           // increment the animation frame counter

        // if we reached our limit, display the true value and restore mouse events;
        // otherwise, show some random value...
        if ( frameCount < frameCountLimit ) {

            for ( int i = 1; i <= NUMBER_OF_DICE; i++ ) {
                if(isDieBeingHeld[i] == false) {
                    myDiceSet[i] = rand.nextInt(NUMBER_OF_SIDES) + 1;
                }
            }

            if(isDieBeingHeld[1] == false) {die1Label.setIcon(dieImage[ myDiceSet[1] ]);}
            if(isDieBeingHeld[2] == false) {die2Label.setIcon(dieImage[ myDiceSet[2] ]);}
            if(isDieBeingHeld[3] == false) {die3Label.setIcon(dieImage[ myDiceSet[3] ]);}
            if(isDieBeingHeld[4] == false) {die4Label.setIcon(dieImage[ myDiceSet[4] ]);}
            if(isDieBeingHeld[5] == false) {die5Label.setIcon(dieImage[ myDiceSet[5] ]);}
            animationTimer.start();
        }
        else {
            int diceTotal = 0;
            for ( int i = 1; i <= NUMBER_OF_DICE; i++ ) {
                System.out.println(myDiceSet[i]);
                diceTotal += myDiceSet[i];
            }

            if(isDieBeingHeld[1] == false) {die1Label.setIcon(dieImage[ myDiceSet[1] ]);}
            if(isDieBeingHeld[2] == false) {die2Label.setIcon(dieImage[ myDiceSet[2] ]);}
            if(isDieBeingHeld[3] == false) {die3Label.setIcon(dieImage[ myDiceSet[3] ]);}
            if(isDieBeingHeld[4] == false) {die4Label.setIcon(dieImage[ myDiceSet[4] ]);}
            if(isDieBeingHeld[5] == false) {die5Label.setIcon(dieImage[ myDiceSet[5] ]);}
            resultLabel.setText("Score is " + diceTotal);
            isClickable = true;
        }
    }


    public void setAnimation( boolean animationState ) {
        isDieAnimated = animationState;
    }


    public boolean isAnimated() {
        return isDieAnimated;
    }


    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Dice Game!"); // makes the frame
        myFrame.setContentPane(new DieGame().panel1); // attaches the panel to the frame

        // sets up what happens with the frame is closed
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // specifies the initial size of the frame
        myFrame.setPreferredSize(new Dimension(500, 300));
        
        // make the frame unable to be resized
        myFrame.setResizable(false);

        myFrame.pack(); // put everything in the frame
        myFrame.setVisible(true); // allows us to see the frame
    }
}
