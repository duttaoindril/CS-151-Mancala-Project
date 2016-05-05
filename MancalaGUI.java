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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class MancalaGUI {
    private JFrame mancalaFrame;
    private JPanel btnPnl;
    private JPanel pitPanel;
    private PitButton[] pitButtons;
    private JButton playerBScore;
    private JButton playerAScore;
    private JButton endTurn;
    private JButton undo;
    private JButton quit;

    public MancalaGUI() {
    	// Telling GUI to use native look and feel for JComponents
    	try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
    	
        //PlayerA Score Button
        playerAScore = new JButton("0");
        playerAScore.setEnabled(false);
        playerAScore.setBorder(new EmptyBorder(10, 10, 10, 10));
        //playerB Score Button
        playerBScore = new JButton("0");
        playerBScore.setEnabled(false);
        playerBScore.setBorder(new EmptyBorder(10, 10, 10, 10));
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
			tmpBtn = new PitButton("3", i);
            if(i < 6)
                tmpBtn.setEnabled(false);
			tmpBtn.setBorderPainted(false);
			tmpBtn.setFocusPainted(false);
            tmpBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
			pitButtons[i] = tmpBtn;
			pitPanel.add(pitButtons[i]);
		}
        
        // Calling this here for now, so we can test it easily
        // Later on it could be moved to a panel if needed
        StartPanelGUI startPanel = new StartPanelGUI();
        
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
        mancalaFrame.add(playerAScore, BorderLayout.EAST);
        mancalaFrame.add(playerBScore, BorderLayout.WEST);
		mancalaFrame.pack();
        mancalaFrame.setSize(550, 250);
        mancalaFrame.setResizable(false);
        mancalaFrame.setLocationRelativeTo(null);
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
        if(i.equals("playerA"))
            return playerAScore;
        else if(i.equals("playerB"))
            return playerBScore;
        else if(i.equals("end"))
            return endTurn;
        else if(i.equals("undo"))
            return undo;
        else if(i.equals("quit"))
            return quit;
        else return null;
    }
}