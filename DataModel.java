import java.util.ArrayList;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class DataModel {
    private ArrayList<ChangeListener> listeners;
    private int playerA;
    private int playerB;
    private boolean playerTurn; // True means player A, false means player B
    private Pit[] pits;
    private State latestState;
    private boolean switchTurn;
    private int undosLeft;

    public DataModel() {
        undosLeft = 3;
        playerA = 0;
        playerB = 0;
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
        return playerA;
    }

    public int getPlayerBScore() {
        return playerB;
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

    public void reset(State s) {
        for(int i = 0; i < pits.length; i++)
            pits[i].setScore(s.getPits()[i]);
        playerA = s.getAScore();
        playerB = s.getBScore();
        playerTurn = s.getTurn(); // True means player A, false means player B
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

    public void clicked(int i) {
        int stones = pits[i].getScore();
        pits[i].setScore(0);
        boolean forward = true;
        if(i < 6)
            forward = false;
        while(stones > 0) {
            if(forward)
                i++;
            else
                i--;
            if(i == 12) {
                if(playerTurn)
                    playerA++;
                else
                    stones++;
                i = 6;
                forward = false;
            } else if(i == -1) {
                if(!playerTurn)
                    playerB++;
                else
                    stones++;
                i = 5;
                forward = true;
            } else
                pits[i].setScore(pits[i].getScore()+1);
            stones--;
        }
        if((playerTurn && i < 6) || (!playerTurn && i > 5))
            switchTurn = true;
        else if(playerTurn && i < 12 && forward && pits[i].getScore() == 1) {
            playerA += pits[i].getScore();
            pits[i].setScore(0);
            playerA += pits[i-6].getScore();
            pits[i-6].setScore(0);
        } else if(!playerTurn && i > -1 && !forward && pits[i].getScore() == 1){
            playerB += pits[i].getScore();
            pits[i].setScore(0);
            playerB += pits[i+6].getScore();
            pits[i+6].setScore(0);
        }

        String s = " ";
        for(int j = 0; j < 12; j++) {
            s += pits[j].getScore()+" ";
            if(j == 5)
                s+= "| ";
        }
        System.out.println(s);

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
                playerB += pits[j].getScore();
                pits[j].setScore(0);
            } for(int j = pits.length/2; j < pits.length; j++) {
                playerA += pits[j].getScore();
                pits[j].setScore(0);
            }
            JOptionPane.showMessageDialog(null, "Game Over!");
            endGame();
        }
        update();
    }

    public void endGame() {
        String s = "The winner is Player B! Good Job! The Game will now quit.";
        if(playerA > playerB)
            s = "The winner is Player A! Good Job! The Game will now quit.";
        JOptionPane.showMessageDialog(null, s);
        System.exit(0);
    }
}