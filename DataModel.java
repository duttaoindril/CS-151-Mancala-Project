import java.util.ArrayList;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class DataModel {
    private ArrayList<ChangeListener> listeners;
    private Pit[] pits;

    public DataModel() {
        pits = new Pit[12];
        listeners = new ArrayList<ChangeListener>();
    }

    public void attach(ChangeListener c) {
        listeners.add(c);
    }

    public void update() {
        for (ChangeListener l : listeners)
            l.stateChanged(new ChangeEvent(this));
    }
}