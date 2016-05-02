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
    private JPanel pitPanel;
    private JButton[] pitButtons;
    private JButton opponentScore;
    private JButton playerScore;
    private JButton endTurn;
    private JButton quit;

    public MancalaGUI() {
        //Pit Buttons Array
        pitButtons = new JButton[12];
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
        //Quit Button
        quit = new JButton("Quit Game");
        quit.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Array of Pit Buttons
		pitPanel = new JPanel();
		pitPanel.setLayout(new GridLayout(2, 6));
		pitPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Init of pit buttons
        JButton tmpBtn;
        for(int i = 0; i < pitButtons.length; i++) {
			tmpBtn = new JButton("0");
            if(i < 6)
                tmpBtn.setEnabled(false);
			tmpBtn.setBorderPainted(false);
			tmpBtn.setFocusPainted(false);
            tmpBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
			pitButtons[i] = tmpBtn;
			pitPanel.add(pitButtons[i]);
		}
        //Frame Init
        mancalaFrame = new JFrame();
		mancalaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mancalaFrame.setSize(200, 400);
        mancalaFrame.add(quit, BorderLayout.NORTH);
        mancalaFrame.add(endTurn, BorderLayout.SOUTH);
		mancalaFrame.add(pitPanel, BorderLayout.CENTER);
        mancalaFrame.add(playerScore, BorderLayout.EAST);
        mancalaFrame.add(opponentScore, BorderLayout.WEST);
		mancalaFrame.setVisible(true);
		mancalaFrame.setResizable(false);
		mancalaFrame.pack();
    }

    public MancalaGUI(MancalaColor c) {
        this();
        c.alter(this);
    }

    public JFrame getFrame() {
        return mancalaFrame;
    }

    public JPanel getPanel() {
        return pitPanel;
    }

    public JButton[] getPits() {
        return pitButtons;
    }

    public JButton getScore(String i) {
        if(i.equals("player"))
            return playerScore;
        else if(i.equals("opponent"))
            return opponentScore;
        else if(i.equals("end"))
            return endTurn;
        else if(i.equals("quit"))
            return quit;
        else return null;
    }
}