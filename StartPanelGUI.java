import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class StartPanelGUI extends JPanel {
	private JButton threeStonesBtn;
	private JButton fourStonesBtn;
	private JButton redBtn;
	private JButton orangeBtn;
	private JButton yellowBtn;
	private JButton greenBtn;
	private JButton blueBtn;
	private JButton purpleBtn;
	private JButton playBtn;
	private int startStoneCount;
	private Color startBoardColor;
	
	public StartPanelGUI()
	{
		int width = 550;
		int height = 250;
		setSize(width, height);
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new BoxLayout(northPane, BoxLayout.Y_AXIS));
		
		JTextArea stonesTextArea = new JTextArea("Select number of stones per pit: ");
		stonesTextArea.setEditable(false);
		stonesTextArea.setFocusable(false);
		JPanel stoneBtnPane = new JPanel();
		threeStonesBtn = new JButton("3 Stones");
		fourStonesBtn = new JButton("4 Stones");
		stoneBtnPane.add(threeStonesBtn);
		stoneBtnPane.add(fourStonesBtn);
		northPane.add(stonesTextArea);
		northPane.add(stoneBtnPane);
		
		//create a southPane to contain all the color buttons
		JPanel southPane = new JPanel();
		southPane.setLayout(new BoxLayout(southPane, BoxLayout.Y_AXIS));
		
		//create colorTextpane to contain JTextArea
		JPanel colorTextPane = new JPanel();
		
		//add colorTextPane to the southPane
		southPane.add(colorTextPane);
		
		//display text to allow the user to select the desired theme
		JTextArea colorTextArea = new JTextArea("What color board would you like?");	
		colorTextArea.setEditable(false);
		colorTextArea.setFocusable(false);
		
		//add textArea to the colorTextPane
		colorTextPane.add(colorTextArea);
		
		JTextArea colorChoice = new JTextArea("");
		colorChoice.setEditable(false);
		colorChoice.setFocusable(false);
		colorTextPane.add(colorChoice);
		
		//create a color button pane
		JPanel colorBtnPane = new JPanel();
		
		//add colorBtnPane to the south pane
		southPane.add(colorBtnPane);
		
		//create color buttons
		redBtn = new JButton("Red");
		orangeBtn = new JButton("Orange");        
		yellowBtn = new JButton("Yellow");
		greenBtn = new JButton("Green");
		blueBtn = new JButton("Blue");
		purpleBtn = new JButton("Purple");
		
		//add all the color buttons to the color button pane
		colorBtnPane.add(redBtn);
		colorBtnPane.add(orangeBtn);
		colorBtnPane.add(yellowBtn);
		colorBtnPane.add(greenBtn);
		colorBtnPane.add(blueBtn);
		colorBtnPane.add(purpleBtn);
		
		//create a play game button so that the user can start playing the game after
		//selecting the desired color for the board
		playBtn = new JButton("Play Game");
		playBtn.setHorizontalAlignment(SwingConstants.CENTER);
		
		//add the playbutton to the southPane
		southPane.add(playBtn);
		
		//add northPane to the StartPanelGUI and set the location to NORTH
		this.add(northPane, BorderLayout.NORTH);
		//add southPane to the StartPanelGUI and set the location to SOUTH
		this.add(southPane, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public JButton getthreeStonesBtn() {
		return threeStonesBtn;
	}

	public JButton getfourStonesBtn() {
		return fourStonesBtn;
	}

	public JButton getRedBtn() {
		return redBtn;
	}

	public JButton getOrangeBtn() {
		return orangeBtn;
	}

	public JButton getYellowBtn() {
		return yellowBtn;
	}

	public JButton getGreenBtn() {
		return greenBtn;
	}

	public JButton getBlueBtn() {
		return blueBtn;
	}

	public JButton getPurpleBtn() {
		return purpleBtn;
	}
	
	public JButton getPlayBtn() {
		return playBtn;
	}

	public int getStartStoneCount() {
		return startStoneCount;
	}

	public Color getStartBoardColor() {
		return startBoardColor;
	}
}