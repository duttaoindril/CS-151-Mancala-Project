import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * JPanel consisting of a starting stones selection panel, BoardSelectionPanel, and
 * a Play Game button. Clicked buttons are highlighted to indicate selected options 
 * to the player. 
 * 
 * @author Team 7
 *
 */
public class StartPanelGUI extends JPanel {
	private JButton threeStonesBtn;
	private JButton fourStonesBtn;
	private JButton playBtn;
	private JButton selectedStoneBtn;
	private int startStoneCount;
	private BoardSelectionPanel boardSelectionPanel;
	
	/**
	 * Instantiates GUI components for the game start menu.
	 */
	public StartPanelGUI() {
		int width = 550;
		int height = 250;
		setSize(width, height);
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());
		
		//Default stone count of 3
		startStoneCount = 3;
		
		//Creating the north panel with stone selection components
		JPanel northPane = new JPanel();
		northPane.setBackground(Color.DARK_GRAY);
		northPane.setLayout(new BoxLayout(northPane, BoxLayout.Y_AXIS));
		JTextArea stonesTextArea = new JTextArea("Select the number of stones per pit: ");
		stonesTextArea.setBackground(Color.DARK_GRAY);
		stonesTextArea.setForeground(Color.WHITE);
		stonesTextArea.setEditable(false);
		stonesTextArea.setFocusable(false);
		//Creating stone button wrapper
		JPanel stoneBtnPane = new JPanel();
		stoneBtnPane.setBackground(Color.DARK_GRAY);
		stoneBtnPane.setPreferredSize(new Dimension(width, height/2-70));
		threeStonesBtn = new JButton("3 Stones");
		threeStonesBtn.setPreferredSize(new Dimension(65, 45));
		threeStonesBtn.setBackground(Color.DARK_GRAY);
		threeStonesBtn.setFocusable(false);
		threeStonesBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		fourStonesBtn = new JButton("4 Stones");
		fourStonesBtn.setPreferredSize(new Dimension(65, 45));
		fourStonesBtn.setBackground(Color.DARK_GRAY);
		fourStonesBtn.setFocusable(false);
		fourStonesBtn.setBorder(new EmptyBorder(10, 10, 10, 10));

		//Creating stone button listeners
		threeStonesBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		selectStoneButton(threeStonesBtn);
        		startStoneCount = 3;
        	}
        });
		fourStonesBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		selectStoneButton(fourStonesBtn);
        		startStoneCount = 4;
        	}
        });

		stoneBtnPane.add(threeStonesBtn);
		stoneBtnPane.add(fourStonesBtn);
		northPane.add(stonesTextArea);
		northPane.add(stoneBtnPane);
		
		//Creating color selector panel
		boardSelectionPanel = new BoardSelectionPanel();
		
		//Creating Play Game button wrapper
		JPanel playBtnPanel = new JPanel();
		playBtnPanel.setPreferredSize(new Dimension(width, 60));
		playBtnPanel.setBackground(Color.DARK_GRAY);
		//Creating Play Game button
		playBtn = new JButton("Play Game");
		playBtn.setPreferredSize(new Dimension(80, 45));
		playBtn.setBackground(Color.DARK_GRAY);
		playBtn.setFocusable(false);
		playBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		playBtnPanel.add(playBtn);
		boardSelectionPanel.add(playBtnPanel);
		
		this.add(northPane, BorderLayout.NORTH);
		this.add(boardSelectionPanel, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	/**
	 * Highlights clicked button with a blue border.
	 * 
	 * @param colorBtn		JButton to be highlighted.
	 */
	private void selectStoneButton(JButton stoneBtn) {
		if(selectedStoneBtn != null)
			selectedStoneBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		selectedStoneBtn = stoneBtn;
		stoneBtn.setBorder(BorderFactory.createLineBorder(new Color(94,223,255), 2, false));
	}
	
	/**
	 * Gets a reference to the Play Game button.
	 * 
	 * @return		A reference to the Play Game button.
	 */
	public JButton getPlayBtn() {
		return playBtn;
	}

	/**
	 * Gets the selected value for starting stones.
	 * 
	 * @return		The currently selected starting stone count.
	 */
	public int getStartStoneCount() {
		return startStoneCount;
	}

	/**
	 * Gets the MancalaAlter object corresponding to the currently 
	 * selected board color option.
	 * 
	 * @return		An appropriate MancalaAlter object of the currently selected color.
	 */
	public MancalaAlter getStartBoardColor() {
		return boardSelectionPanel.getBoardSelection();
	}
}