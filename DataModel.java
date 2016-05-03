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

    public DataModel() {
        playerA = 0;
        playerB = 0;
        playerTurn = true;
        pits = new Pit[12];
        for(int i = 0; i < pits.length; i++)
            pits[i] = new Pit();
        listeners = new ArrayList<ChangeListener>();
    }

    public void attach(ChangeListener c) {
        listeners.add(c);
    }

    public void update() {
        for (ChangeListener l : listeners)
            l.stateChanged(new ChangeEvent(this));
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

    public void switchTurn() {
        playerTurn = !playerTurn;
        update();
    }

    public void popUndo() {
        update();
    }

    public void clicked(int i) {
        update();
    }

    public void reset(State s) {
        for(int i = 0; i < pits.length; i++)
            pits[i].setScore(s.getPits()[i]);

        update();
    }
}