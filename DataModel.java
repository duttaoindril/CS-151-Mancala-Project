import java.util.ArrayList;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class DataModel {
    private ArrayList<ChangeListener> listeners;
    private int playerAScore;
    private int playerBScore;
    private boolean playerTurn; // True means player A, false means player B
    private Pit[] pits;
    private State latestState;
    private boolean switchTurn;
    private int undosLeft;

    public DataModel() {
        undosLeft = 3;
        playerAScore = 0;
        playerBScore = 0;
        playerTurn = true;
        switchTurn = false;
        pits = new Pit[12];
        for(int i = 0; i < pits.length; i++)
            pits[i] = new Pit(3);
        latestState = new State(null);
        listeners = new ArrayList<ChangeListener>();
    }

    public void attach(ChangeListener c) {
        listeners.add(c);
    }

    public void update() {
        for (ChangeListener l : listeners)
            l.stateChanged(new ChangeEvent(this));
    }

    public boolean getSwitch() {
        return switchTurn;
    }

    public boolean getPlayerTurn() {
        return playerTurn;
    }

    public int getPlayerAScore() {
        return playerAScore;
    }

    public int getPlayerBScore() {
        return playerBScore;
    }

    public int[] getPits() {
        int[] scores = new int[12];
        for(int i = 0; i < scores.length; i++)
            scores[i] = pits[i].getScore();
        return scores;
    }

    public int getPitScore(int i) {
        return pits[i].getScore();
    }

    public State getLatestState() {
        return latestState;
    }

    public int getUndosLeft() {
        return undosLeft;
    }

    public void replaceState(State s) {
        latestState = s;
    }

    public void reset(State state) {
        for(int i = 0; i < pits.length; i++)
            pits[i].setScore(state.getPits()[i]);
        playerAScore = state.getAScore();
        playerBScore = state.getBScore();
        playerTurn = state.getTurn(); // True means player A, false means player B
        switchTurn = false;
        update();
    }

    public void popUndo() {
        if(undosLeft > 0) {
            reset(latestState);
            latestState = new State(null);
            undosLeft--;
        }
        update();
    }

    public void switchTurn() {
        playerTurn = !playerTurn;
        undosLeft = 3;
        latestState = new State(null);
        switchTurn = false;
        update();
    }

    public void clicked(int pit) {
        int stones = pits[pit].getScore();
        pits[pit].setScore(0);
        boolean forward = true;
        boolean freeTurn = false;
        if(pit < 6)
            forward = false;
        while(stones > 0) {
            if(forward)
            	pit++;
            else
            	pit--;
            if(pit == 12) {
                if(stones == 1)
                	freeTurn = true;
            	if(playerTurn)
                    playerAScore++;
                else
                    stones++;
                pit = 6;
                forward = false;
            } else if(pit == -1) {
                if(stones == 1)
                	freeTurn = true;
                if(!playerTurn)
                    playerBScore++;
                else
                    stones++;
                pit = 5;
                forward = true;
            } else
                pits[pit].setScore(pits[pit].getScore()+1);
            stones--;
        }
        
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
        
//        if((playerTurn && pit < 6) || (!playerTurn && pit > 5))
//            switchTurn = true;
//        else if(playerTurn && pit < 12 && forward && pits[pit].getScore() == 1) {

        String stoneCount = " ";
        for(int j = 0; j < 12; j++) {
        	stoneCount += pits[j].getScore()+" ";
            if(j == 5)
            	stoneCount+= "| ";
        }
        System.out.println(stoneCount);

        boolean gameEndA = true;
        boolean gameEndB = true;
        for(int j = 0; j < pits.length/2; j++)
            if(pits[j].getScore() > 0)
                gameEndB = false;
        for(int j = pits.length/2; j < pits.length; j++)
            if(pits[j].getScore() > 0)
                gameEndA = false;
        System.out.println(gameEndA+" "+gameEndB);
        if(gameEndA || gameEndB) {
            for(int j = 0; j < pits.length/2; j++) {
                playerBScore += pits[j].getScore();
                pits[j].setScore(0);
            } for(int j = pits.length/2; j < pits.length; j++) {
                playerAScore += pits[j].getScore();
                pits[j].setScore(0);
            }
            JOptionPane.showMessageDialog(null, "Game Over!");
            endGame();
        }
        update();
    }

    public void endGame() {
        String s = "The winner is Player B! Good Job! The Game will now quit.";
        if(playerAScore > playerBScore)
            s = "The winner is Player A! Good Job! The Game will now quit.";
        JOptionPane.showMessageDialog(null, s);
        System.exit(0);
    }
}