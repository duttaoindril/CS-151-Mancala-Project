import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class MancalaGUI {
    private JFrame mancalaFrame;
    private JPanel btnPnl;
    private JPanel pitPanel;
    private PitButton[] pitButtons;
    private JButton opponentScore;
    private JButton playerScore;
    private JButton endTurn;
    private JButton undo;
    private JButton quit;

    public MancalaGUI() {
        //Player Score Button
        playerScore = new JButton("0");
        playerScore.setEnabled(false);
        playerScore.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Opponent Score Button
        opponentScore = new JButton("0");
        opponentScore.setEnabled(false);
        opponentScore.setBorder(new EmptyBorder(10, 10, 10, 10));
        //End Turn Button
        endTurn = new JButton("End Turn Player A");
        endTurn.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Undo Button
        undo = new JButton("Undo");
        undo.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Quit Button
        quit = new JButton("Quit Game");
        quit.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Array of Pit Buttons
		pitPanel = new JPanel();
		pitPanel.setLayout(new GridLayout(2, 6));
		pitPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Init of Pit Buttons Array
        pitButtons = new PitButton[12];
        PitButton tmpBtn;
        for(int i = 0; i < pitButtons.length; i++) {
			tmpBtn = new PitButton("4", i+1);
            if(i < 6)
                tmpBtn.setEnabled(false);
			tmpBtn.setBorderPainted(false);
			tmpBtn.setFocusPainted(false);
            tmpBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
			pitButtons[i] = tmpBtn;
			pitPanel.add(pitButtons[i]);
		}
        //JPanel Button Panel for Undo & EndTurn
        btnPnl = new JPanel();
        btnPnl.add(undo, BorderLayout.NORTH);
        btnPnl.add(endTurn, BorderLayout.SOUTH);
        //Frame Init
        mancalaFrame = new JFrame();
		mancalaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mancalaFrame.setSize(200, 400);
        mancalaFrame.add(quit, BorderLayout.NORTH);
        mancalaFrame.add(btnPnl, BorderLayout.SOUTH);
		mancalaFrame.add(pitPanel, BorderLayout.CENTER);
        mancalaFrame.add(playerScore, BorderLayout.EAST);
        mancalaFrame.add(opponentScore, BorderLayout.WEST);
		mancalaFrame.pack();
        mancalaFrame.setSize(550, 250);
        mancalaFrame.setResizable(false);
        mancalaFrame.setVisible(true);
    }

    public MancalaGUI(MancalaAlter c) {
        this();
        c.alter(this);
    }

    public JFrame getFrame() {
        return mancalaFrame;
    }

    public JPanel getPanel(String i) {
        if(i.equals("pits"))
            return pitPanel;
        else if(i.equals("btns"))
            return btnPnl;
        return null;
    }

    public PitButton[] getPits() {
        return pitButtons;
    }

    public JButton getButton(String i) {
        if(i.equals("player"))
            return playerScore;
        else if(i.equals("opponent"))
            return opponentScore;
        else if(i.equals("end"))
            return endTurn;
        else if(i.equals("undo"))
            return undo;
        else if(i.equals("quit"))
            return quit;
        else return null;
    }
}