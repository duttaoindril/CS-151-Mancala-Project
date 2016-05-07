import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class StyleSelectionPanel extends JPanel {
	
	public JButton doneBtn;
	private BoardSelectionPanel boardThemeChanger;

	public StyleSelectionPanel(){
		//Setting width and height to match MancalaGUI
		int width = 550;
		int height = 250;
		setSize(width, height);
		
		//set the layout manager for this to a BorderLayout
		this.setLayout(new BorderLayout());
		
		//create a new object for BoardSelectionPanel
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
		
		//Add boardSelectionPanel to this and set this to visible
		this.add(boardThemeChanger);
		this.setVisible(true);		
	}
	
	//getter method for returning a MancalaAlter object like boardSelectionPanel.getBoardSelection()
	public MancalaAlter getBoardSelection(){
		return boardThemeChanger.getBoardSelection();
	}
	
	//getter for returning the doneBtn, so Controller can use it
	public JButton getDoneBtn(){
		return doneBtn;		
	}
}