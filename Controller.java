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
        attachControllers();
        stateChanged(null);
    }

    public void attachControllers() {
        for(PitButton btn : gui.getPits())
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    State s = new State(dataModel);
                    if(dataModel.clicked(btn.getIndex()))
                        dataModel.addState(s);
                    dataModel.update();
                }
            });
        gui.getButton("undo").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataModel.popUndo();
            }
        });
        gui.getButton("end").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dataModel.switchTurn();
            }
        });
        gui.getButton("quit").addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Thank you!\n");
                System.exit(0);
            }
        });
    }

    public void stateChanged(ChangeEvent e) {
        gui.getButton("playerA").setText(""+dataModel.getPlayerAScore());
        gui.getButton("playerB").setText(""+dataModel.getPlayerBScore());
        gui.getButton("undo").setEnabled(dataModel.getStateCount() != 0);
        gui.getButton("end").setEnabled(dataModel.getSwitch());
        if(dataModel.getPlayerTurn())
            gui.getButton("end").setText("End Turn Player A");
        else
            gui.getButton("end").setText("End Turn Player B");
        for(int i = 0; i < gui.getPits().length; i++)
            if(i < 6) {
                gui.getPits()[i].setEnabled(!dataModel.getPlayerTurn() && !dataModel.getSwitch() && dataModel.getPitScore(i) > 0);
                gui.getPits()[i].setText("B"+(i+1)+": "+dataModel.getPitScore(i));
            } else {
                gui.getPits()[i].setEnabled(dataModel.getPlayerTurn() && !dataModel.getSwitch() && dataModel.getPitScore(i) > 0);
                gui.getPits()[i].setText("A"+(i-5)+": "+dataModel.getPitScore(i));
            }
    }
}