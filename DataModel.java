import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Model for the Mancala game state.
 * 
 * @author Team 7
 *
 */
public class DataModel {
    private ArrayList<ChangeListener> listeners;
    private int playerAScore;
    private int playerBScore;
    private boolean playerTurn; // True means player A, false means player B
    private Pit[] pits;
    private State latestState;
    private boolean switchTurn;
    private int undosLeft;
    private int startingStones;

    /**
     * Initializes the game model with pits, stores, starting stones,
     * player score, collection of change listeners, and max undo count.
     */
    public DataModel() {
        undosLeft = 3;
        playerAScore = 0;
        playerBScore = 0;
        playerTurn = true;
        switchTurn = false;
        //Default number of stones per pit is 3
        startingStones = 3;
        pits = new Pit[12];
        for(int i = 0; i < pits.length; i++)
            pits[i] = new Pit(startingStones);
        latestState = new State(null);
        listeners = new ArrayList<ChangeListener>();
    }

    /**
     * Attach views to the model.
     * 
     * @param c		ChangeListener to attach.
     */
    public void attach(ChangeListener c) {
        listeners.add(c);
    }

    /**
     * Updates the view when changes are made.
     */
    public void update() {
        for (ChangeListener l : listeners)
            l.stateChanged(new ChangeEvent(this));
    }

    /**
     * Gets the state of switchTurn.
     * 
     * @return		The current boolean state of switchTurn.
     */
    public boolean getSwitch() {
        return switchTurn;
    }

    /**
     * Gets the state of playerTurn.
     * 
     * @return		The current boolean state of playerTurn.
     */
    public boolean getPlayerTurn() {
        return playerTurn;
    }

    /**
     * Gets player A's score.
     * 
     * @return		An int representation of player A's score.
     */
    public int getPlayerAScore() {
        return playerAScore;
    }

    /**
     * Gets player B's score.
     * 
     * @return		An int representation of player B's score.
     */
    public int getPlayerBScore() {
        return playerBScore;
    }

    /**
     * Sets the number of stones per pit at the beginning of the game and updates the view.
     * 
     * @param numStones		The number of stones to start with in each pit.
     */
    public void setStartingStones(int numStones) {
    	startingStones = numStones;
    	for(int i = 0; i < pits.length; i++)
            pits[i].setScore(startingStones);
    	update();
    }
    
    /**
     * Gets a reference to an array of stone counts per pit.
     * 
     * @return		A reference to the int[] named scores.
     */
    public int[] getPits() {
        int[] scores = new int[12];
        for(int i = 0; i < scores.length; i++)
            scores[i] = pits[i].getScore();
        return scores;
    }

    /**
     * Gets the current number of stones in a given pit.
     * 
     * @param i		Index of the pit whose stone count is needed.
     * @return		An int representation of the stone count.
     */
    public int getPitScore(int i) {
        return pits[i].getScore();
    }

    /**
     * Gets the latest state of the model.
     * 
     * @return		A State object containing the latest game state.
     */
    public State getLatestState() {
        return latestState;
    }

    /**
     * Gets the number of undos remaining this turn.
     * 
     * @return		An int representing the number of remaining undos.
     */
    public int getUndosLeft() {
        return undosLeft;
    }

    /**
     * Replaces the current latest state with a new one.
     * 
     * @param s		The State to replace the latest state.
     */
    public void replaceState(State s) {
        latestState = s;
    }

    /** 
     * Resets the state to before the last move was made and updates the view.
     * 
     * @param state		State object containing the previous game state.
     */
    public void reset(State state) {
        for(int i = 0; i < pits.length; i++)
            pits[i].setScore(state.getPits()[i]);
        playerAScore = state.getAScore();
        playerBScore = state.getBScore();
        playerTurn = state.getTurn(); // True means player A, false means player B
        switchTurn = false;
        update();
    }

    /**
     * Manages remaining undos in the latest State object and updates the view.
     */
    public void popUndo() {
        if(undosLeft > 0) {
            reset(latestState);
            latestState = new State(null);
            undosLeft--;
        }
        update();
    }

    /**
     * Switches the turn state from one player to another and updates the view.
     */
    public void switchTurn() {
        playerTurn = !playerTurn;
        undosLeft = 3;
        latestState = new State(null);
        switchTurn = false;
        update();
    }

    /**
     * Carries out the primary game logic and checks game rules starting from
     * a given pit.
     * 
     * @param pit		Index of the pit that was clicked.
     */
    public void clicked(int pit) {
        //Find out how many stones in pit
    	int stones = pits[pit].getScore();
        //Empty pit
    	pits[pit].setScore(0);
        boolean forward = true;
        boolean freeTurn = false;
        //If pit was one of the first six then go other direction
        if(pit < 6)
            forward = false;
        while(stones > 0) {
            if(forward)
            	pit++;
            else
            	pit--;
            if(pit == 12) {
                if(stones == 1)
                	//If last stone landed in a player's store then free turn
                	freeTurn = true;
            	if(playerTurn)
                    playerAScore++;
                else
                    stones++;
                pit = 6;
                forward = false;
            } else if(pit == -1) {
                if(stones == 1)
                	//If last stone landed in a player's store then free turn
                	freeTurn = true;
                if(!playerTurn)
                    playerBScore++;
                else
                    stones++;
                pit = 5;
                forward = true;
            } else
            	//Else add a stone
                pits[pit].setScore(pits[pit].getScore()+1);
            stones--;
        }
        
        //Checking game rules to see if players get a free turn or collect extra stones
        if((playerTurn && !freeTurn) || (!playerTurn && !freeTurn))
            switchTurn = true;
        if(playerTurn && pit < 12 && forward && pits[pit].getScore() == 1) {
            playerAScore += pits[pit].getScore();
            pits[pit].setScore(0);
            playerAScore += pits[pit-6].getScore();
            pits[pit-6].setScore(0);
        } else if(!playerTurn && pit > -1 && !forward && pits[pit].getScore() == 1){
            playerBScore += pits[pit].getScore();
            pits[pit].setScore(0);
            playerBScore += pits[pit+6].getScore();
            pits[pit+6].setScore(0);
        }
        
        boolean gameEndA = true;
        boolean gameEndB = true;
        //Checking if both sides still have stones
        for(int j = 0; j < pits.length/2; j++)
            if(pits[j].getScore() > 0)
                gameEndB = false;
        for(int j = pits.length/2; j < pits.length; j++)
            if(pits[j].getScore() > 0)
                gameEndA = false;
        //If either side has no stones then tally score and end the game
        if(gameEndA || gameEndB) {
            for(int j = 0; j < pits.length/2; j++) {
                playerBScore += pits[j].getScore();
                pits[j].setScore(0);
            } for(int j = pits.length/2; j < pits.length; j++) {
                playerAScore += pits[j].getScore();
                pits[j].setScore(0);
            }
            update();
            JOptionPane.showMessageDialog(null, "Game Over!");
            endGame();
        }
        update();
    }

    /**
     * Ends the game and lets the players know who the victor is.
     */
    public void endGame() {
        String s = "The winner is Player B! Good Job! The Game will now quit.";
        if(playerAScore > playerBScore)
            s = "The winner is Player A! Good Job! The Game will now quit.";
        JOptionPane.showMessageDialog(null, s);
        System.exit(0);
    }
}