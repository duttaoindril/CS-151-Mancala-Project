import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
    private PitButton[] pitButtons;
    private JTextArea playerBScore;
    private JTextArea playerAScore;
    private JButton endTurn;
    private JButton undo;
    private JButton changeBoardBtn;
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
    	
        //PlayerA Score area
        playerAScore = new JTextArea("0");
        playerAScore.setEnabled(false);
        playerAScore.setBorder(new EmptyBorder(10, 10, 10, 10));
        //playerB Score area
        playerBScore = new JTextArea("0");
        playerBScore.setEnabled(false);
        playerBScore.setBorder(new EmptyBorder(10, 10, 10, 10));
        //End Turn Button
        endTurn = new JButton("End Turn Player A");
        endTurn.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Undo Button
        undo = new JButton("Undo");
        undo.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Change board button
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
		mancalaFrame.setSize(200, 400);
		mancalaFrame.add(gameBoardPanel);
		mancalaFrame.pack();
        mancalaFrame.setSize(550, 250);
        mancalaFrame.setResizable(false);
        mancalaFrame.setLocationRelativeTo(null);
        mancalaFrame.setVisible(true);

        //Adding start panel and hiding game board until selections are made
        gameBoardPanel.setVisible(false);
        startPanel = new StartPanelGUI();
        mancalaFrame.add(startPanel);
        
        //Game board is made visible after stone and color selection
    }

    public MancalaGUI(MancalaAlter alterGUI) {
        this();
        alterGUI.alter(this);
    }

    public void changeBoard(MancalaAlter alterGUI) {
    	alterGUI.alter(this);
    }
    
    public void startGame() {
    	startPanel.setVisible(false);
    	gameBoardPanel.setVisible(true);
    }
    
    public JFrame getFrame() {
        return mancalaFrame;
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
    
    public JTextArea getMancalaA() {
    	return playerAScore;
    }
    
    public JTextArea getMancalaB() {
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