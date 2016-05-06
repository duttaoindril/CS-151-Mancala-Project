import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 * StyleSelectionFrame is the pop up frame to allow any player to change the board theme after the game starts
 * or during the game
 */
public class StyleSelectionFrame extends JFrame implements MancalaAlter {
	
	private static final long serialVersionUID = 1L;
	MancalaGUI mancalaFrame;
	StartPanelGUI startPanel;

	public StyleSelectionFrame(){
		this.setLayout(new SpringLayout());
		setTitle("Change Board Theme");
		setSize(415, 200);
		//sets the style selection frame beside the Mancala frame
		setLocation(MancalaGUI.mancalaFrame.getX() + MancalaGUI.mancalaFrame.getWidth(), MancalaGUI.mancalaFrame.getY());
		startPanel = new StartPanelGUI();
		
		
		this.add(startPanel);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

	}

	@Override
	public void alter(MancalaGUI g) {
		// TODO Auto-generated method stub
		
	}

	
	

}
