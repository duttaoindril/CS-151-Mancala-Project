import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Controller implements ChangeListener {
    private DataModel dataModel;
    private MancalaGUI gui;

    public Controller(MancalaGUI g, DataModel d) {
        gui = g;
        dataModel = d;
        dataModel.attach(this);
        stateChanged(null);
    }

    public void stateChanged(ChangeEvent e) {

    }
}