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
    private State[] states;
    private boolean switchTurn;

    public DataModel() {
        playerA = 0;
        playerB = 0;
        playerTurn = true;
        switchTurn = false;
        pits = new Pit[12];
        for(int i = 0; i < pits.length; i++)
            pits[i] = new Pit(3);
        states = new State[3];
        for(int i = 0; i < states.length; i++)
            states[i] = new State(null);
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

    public int getStateCount() {
        int count = 0;
        for(int i = 0; i < states.length; i++)
            if(!states[i].isNull())
                count++;
            else
                return count;
        return count;
    }

    public State[] getStates() {
        return states;
    }

    public void addState(State s) {
        for(int i = states.length-1; i > -1; i--)
            if(i == 0)
                states[i] = s;
            else
                states[i] = states[i-1];
    }

    public void switchTurn() {
        playerTurn = !playerTurn;
        switchTurn = false;
        update();
    }

    public void popUndo() {
        reset(states[0]);
        for(int i = 0; i < states.length; i++)
            if(i == states.length-1)
                states[i] = new State(null);
            else
                states[i] = states[i+1];
        update();
    }

    public boolean clicked(int i) {
        int stones = pits[i].getScore();
        if(stones == 0)
            return false;
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
            } else {
                pits[i].setScore(pits[i].getScore()+1);
            }
            stones--;
        }
        if((playerTurn && i < 6) || (!playerTurn && i > 5))
            switchTurn = true;
        // else if(playerTurn) {
        //     playerA += pits[i].getScore();
        //     pits[i].setScore(0);
        //     playerA += pits[i-6].getScore();
        //     pits[i-6].setScore(0);
        // } else {
        //     playerB += pits[i].getScore();
        //     pits[i].setScore(0);
        //     playerB += pits[i+6].getScore();
        //     pits[i+6].setScore(0);
        // }
        update();
        return true;
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
}