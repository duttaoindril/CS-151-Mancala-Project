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
	public StyleSelectionFrame(){
		/* We can probably leave the default layout for JFrame (BorderLayout) since 
		 * it's what the StartPanelGUI uses. Can remove the this.setLayout() call
		 */
		this.setLayout(new SpringLayout());
		setTitle("Change Board Theme");
		setSize(415, 200);
		//sets the style selection frame beside the Mancala frame
		setLocationRelativeTo(null);
		/*
		 * This is a good idea! Except we don't want the stone selection in this one,
		 * so it's better to copy the portion of that code we need and put it here
		 * 
		 * 
		 */
		startPanel = new StartPanelGUI();
		this.add(startPanel);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void alter(MancalaGUI g) {
		
	}
}
