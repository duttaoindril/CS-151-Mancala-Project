import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * StyleSelectionFrame is the pop up frame to allow any player to change the board theme after the game starts
 * or during the game
 */
public class StyleSelectionPanel extends JPanel {
	
	public static JButton doneBtn;
	private static BoardSelectionPanel boardSelectionPanel;

	public StyleSelectionPanel(){
		/*
		 * Just have to add some stuff here and hook it up to the Controller
		 * then we are good! Good luck. If it doesn't work let me know and I 
		 * can do it in the morning. But I'm sure you got this now. No worries.
		 */
		
		/*
		 * Note: Removed "implements MancalaAlter" since we can use 
		 * action listeners to change the game board color.
		 * The idea is that we save a MancalaAlter based on which
		 * button gets clicked, then we can send that object to
		 * MancalaGUI (through the Controller class) when the
		 * "Done" button is clicked.
		 */
		 
		/*
		 * Note: All of the ActionListeners for selecting colors are in the 
		 * BoardSelectionPanel class. Shouldn't have to update 
		 * anything there. I made it earlier because we need the 
		 * exact same stuff for the start menu.
		 */
		
		//Setting width and height to match MancalaGUI
		int width = 550;
		int height = 250;
		setSize(width, height);
		
		// We need to set the layout manager for this to a BorderLayout
		this.setLayout(new FlowLayout());
		
		//Make boardSelectionPanel a new BoardSelectionPanel() here
		BoardSelectionPanel boardThemeChanger = new BoardSelectionPanel();
		
		/*
		 * I went ahead and did this part since it was a little 
		 * tricky in the other panel.
		 * Just have to add it to boardSelectionPanel below.
		 */
		//Creating Done button wrapper
		JPanel doneBtnPanel = new JPanel();
		doneBtnPanel.setPreferredSize(new Dimension(this.getWidth(), 140));
		doneBtnPanel.setBackground(Color.DARK_GRAY);
		//Creating Done button
		doneBtn = new JButton("Done");
		doneBtn.setPreferredSize(new Dimension(80, 45));
		doneBtn.setBackground(Color.DARK_GRAY);
		doneBtn.setFocusable(false);
		doneBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		doneBtnPanel.add(doneBtn);
		
		//Add doneBtnPanel to boardSelectionPanel so it will show up
	    this.add(doneBtnPanel);
		//I ran into some layout issues when I didn't on the other one
		
		//Add boardSelectionPanel to this and set this to visible
		this.add(boardThemeChanger);
		this.setVisible(true);		
	}
	
	//getter method for returning a MancalaAlter object like boardSelectionPanel.getBoardSelection()
	public static MancalaAlter getBoardSelection(){
		return boardSelectionPanel.getBoardSelection();
	}
	
	//getter for returning the doneBtn, so Controller can use it
	public JButton getDoneBtn(){
		return doneBtn;		
	}

}
