import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Controller implements ChangeListener {
    private DataModel dataModel;
    private MancalaGUI gui;
    private StartPanelGUI startPanel;

    public Controller(MancalaGUI g, DataModel d) {
        gui = g;
        dataModel = d;
        dataModel.attach(this);
        startPanel = gui.getStartPanel();
        attachControllers();
        stateChanged(null);
    }

    public void attachControllers() {
        for(PitButton btn : gui.getPits())
            btn.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    dataModel.replaceState(new State(dataModel));
                    dataModel.clicked(btn.getIndex());
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
        gui.getButton("changeBoardBtn").addActionListener(new ActionListener() {

        	//when clicking the changeBoard button, a new window is opened for the player to change the theme
			@Override
			public void actionPerformed(ActionEvent e) {
				StyleSelectionFrame styleFrame = new StyleSelectionFrame();			
			}
        });
        startPanel.getPlayBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dataModel.setStartingStones(startPanel.getStartStoneCount());
				gui.startGame(startPanel.getStartBoardColor());
			}
		});
    }

    public void stateChanged(ChangeEvent e) {
        gui.getMancalaA().setText("A: "+dataModel.getPlayerAScore());
        gui.getMancalaB().setText("B: "+dataModel.getPlayerBScore());
        gui.getButton("undo").setEnabled(!dataModel.getLatestState().isNull() && dataModel.getUndosLeft() > 0);
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
