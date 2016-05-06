import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * StyleSelectionFrame is the pop up frame to allow any player to change the board theme after the game starts
 * or during the game
 */
public class StyleSelectionPanel extends JPanel {
	private JButton doneBtn;
	private BoardSelectionPanel boardSelectionPanel;

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
		
		
		//Make boardSelectionPanel a new BoardSelectionPanel() here

		
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
		//I ran into some layout issues when I didn't on the other one

		
		//Add boardSelectionPanel to this and set this to visible

		
	}
	
	//Need a getter method for returning a MancalaAlter object like boardSelectionPanel.getBoardSelection()

	
	//Need a getter for returning the doneBtn, so Controller can use it

}
