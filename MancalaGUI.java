import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class MancalaGUI {
    private JFrame mancalaFrame;
    private JPanel btnPnl;
    private JPanel pitPanel;
    private JPanel menuPanel;
    private JPanel gameBoardPanel;
    private StartPanelGUI startPanel;
    private StyleSelectionPanel stylePanel;
    private PitButton[] pitButtons;
    private JButton playerBScore;
    private JButton playerAScore;
    private JButton endTurn;
    private JButton undo;
    private JButton changeBoardBtn;
    private JButton quit;

    public MancalaGUI() {
    	//Telling GUI to use native look and feel for JComponents
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
    	
        //PlayerA Score area
        playerAScore = new JButton("0");
        playerAScore.setEnabled(false);
        playerAScore.setFocusable(false);
        playerAScore.setBackground(Color.DARK_GRAY);
        playerAScore.setForeground(Color.BLACK);
        playerAScore.setBorder(new EmptyBorder(10, 10, 10, 10));
        //playerB Score area
        playerBScore = new JButton("0");
        playerBScore.setEnabled(false);
        playerBScore.setFocusable(false);
        playerBScore.setBackground(Color.DARK_GRAY);
        playerBScore.setForeground(Color.BLACK);
        playerBScore.setBorder(new EmptyBorder(10, 10, 10, 10));
        //End Turn Button
        endTurn = new JButton("End Turn Player A");
        endTurn.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Undo Button
        undo = new JButton("Undo");
        undo.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Change board button is used the change the style of the board during the game
        changeBoardBtn = new JButton("Change Board");
        changeBoardBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
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
        //JPanel Button Panel for Undo & EndTurn
        btnPnl = new JPanel();
        btnPnl.add(undo, BorderLayout.NORTH);
        btnPnl.add(endTurn, BorderLayout.SOUTH);
        //JPanel for Quit and Change Board buttons
        menuPanel = new JPanel();
        menuPanel.add(changeBoardBtn);
        menuPanel.add(quit);        
        //Creating gameBoardPanel so the board can be hidden at first
    	gameBoardPanel = new JPanel();
    	gameBoardPanel.setLayout(new BorderLayout());
    	gameBoardPanel.add(menuPanel, BorderLayout.NORTH);
    	gameBoardPanel.add(btnPnl, BorderLayout.SOUTH);
    	gameBoardPanel.add(pitPanel, BorderLayout.CENTER);
    	gameBoardPanel.add(playerAScore, BorderLayout.EAST);
    	gameBoardPanel.add(playerBScore, BorderLayout.WEST);
        //Frame Init
        mancalaFrame = new JFrame();
		mancalaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mancalaFrame.setLocationRelativeTo(null);
		mancalaFrame.setTitle("Mancala");
		mancalaFrame.add(gameBoardPanel);
		mancalaFrame.pack();
        mancalaFrame.setSize(550, 250);
        mancalaFrame.setResizable(false);
        mancalaFrame.setLocationRelativeTo(null);
        mancalaFrame.setVisible(true);
        //Hiding game board until selections are made
        gameBoardPanel.setVisible(false);
        //Adding style selection panel and hiding it
        stylePanel = new StyleSelectionPanel();
        mancalaFrame.add(stylePanel);
        stylePanel.setVisible(false);

        //Adding start panel 
        startPanel = new StartPanelGUI();
        mancalaFrame.add(startPanel);

        //Game board is made visible after stone and color selection
    }
    
    public void startGame(MancalaAlter alterGui) {
    	if(alterGui != null)
    		alterGui.alter(this);
    	else
    		//Default to orange if not selection
    		new AlterOrange().alter(this);
    	startPanel.setVisible(false);
    	gameBoardPanel.setVisible(true);
    }
    
    public void changeBoard(MancalaAlter alterGui) {
    	if(alterGui != null)
    		alterGui.alter(this);
    	stylePanel.setVisible(false);
    	gameBoardPanel.setVisible(true);
    }
    
    public void showStylePanel() {
    	gameBoardPanel.setVisible(false);
    	stylePanel.setVisible(true);
    }

    public JPanel getPanel(String pnlRequest) {
        if(pnlRequest.equals("pits"))
            return pitPanel;
        else if(pnlRequest.equals("btns"))
            return btnPnl;
        else if(pnlRequest.equals("menu"))
        	return menuPanel;
        return null;
    }

    public StartPanelGUI getStartPanel() {
    	return startPanel;
    }
    
    public StyleSelectionPanel getStylePanel() {
    	return stylePanel;
    }
    
    public JButton getMancalaA() {
    	return playerAScore;
    }
    
    public JButton getMancalaB() {
    	return playerBScore;
    }
    
    public PitButton[] getPits() {
        return pitButtons;
    }
    
    public JButton getButton(String btnRequest) {
        if(btnRequest.equals("end"))
            return endTurn;
        else if(btnRequest.equals("undo"))
            return undo;
        else if(btnRequest.equals("changeBoardBtn"))
        	return changeBoardBtn;
        else if(btnRequest.equals("quit"))
            return quit;
        else return null;
    }
}