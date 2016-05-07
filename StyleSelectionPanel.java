import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Encapsulates components necessary for game board style selection.
 * 
 * @author Team 7
 *
 */
public class StyleSelectionPanel extends JPanel {
	public JButton doneBtn;
	private BoardSelectionPanel boardThemeChanger;

	/**
	 * Initializes all components needed for the style selection panel.
	 */
	public StyleSelectionPanel(){
		//Setting width and height to match MancalaGUI
		int width = 550;
		int height = 250;
		setSize(width, height);
		
		this.setLayout(new BorderLayout());
		
		//Creating a new color selection panel
		boardThemeChanger = new BoardSelectionPanel();
		
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
		boardThemeChanger.add(doneBtnPanel);
		
		this.add(boardThemeChanger);
	}
	
	/**
	 * Gets a reference to the selected board style.
	 * 
	 * @return		A MancalaAlter reference of the selected type.
	 */
	public MancalaAlter getBoardSelection(){
		return boardThemeChanger.getBoardSelection();
	}
	
	/**
	 * Gets a reference to the Done button.
	 * 
	 * @return		A JButton reference to the Done button.
	 */
	public JButton getDoneBtn(){
		return doneBtn;		
	}
}