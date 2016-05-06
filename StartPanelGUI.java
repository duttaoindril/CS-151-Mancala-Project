import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class StartPanelGUI extends JPanel {
	private JButton threeStones;
	private JButton fourStones;
	private JButton red;
	private JButton orange;
	private JButton yellow;
	private JButton green;
	private JButton blue;
	private JButton purple;
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
		threeStones = new JButton("3 Stones");
		fourStones = new JButton("4 Stones");
		stoneBtnPane.add(threeStones);
		stoneBtnPane.add(fourStones);
		northPane.add(stonesTextArea);
		northPane.add(stoneBtnPane);
		
		JPanel southPane = new JPanel();
		southPane.setLayout(new BoxLayout(southPane, BoxLayout.Y_AXIS));
		JPanel colorTextPane = new JPanel();
		southPane.add(colorTextPane);
		JTextArea colorTextArea = new JTextArea("What color board would you like?");	
		colorTextArea.setEditable(false);
		colorTextArea.setFocusable(false);
		colorTextPane.add(colorTextArea);
		JTextArea colorChoice = new JTextArea("");
		colorChoice.setEditable(false);
		colorChoice.setFocusable(false);
		colorTextPane.add(colorChoice);
		JPanel colorBtnPane = new JPanel();
		southPane.add(colorBtnPane);
		red = new JButton("Red");
		orange = new JButton("Orange");        
		yellow = new JButton("Yellow");
		green = new JButton("Green");
		blue = new JButton("Blue");
		purple = new JButton("Purple");
		colorBtnPane.add(red);
		colorBtnPane.add(orange);
		colorBtnPane.add(yellow);
		colorBtnPane.add(green);
		colorBtnPane.add(blue);
		colorBtnPane.add(purple);
		playBtn = new JButton("Play Game");
		playBtn.setHorizontalAlignment(SwingConstants.CENTER);
		southPane.add(playBtn);
		
		this.add(northPane, BorderLayout.NORTH);
		this.add(southPane, BorderLayout.SOUTH);
		this.setVisible(true);
	}

	public JButton getThreeStones() {
		return threeStones;
	}

	public JButton getFourStones() {
		return fourStones;
	}

	public JButton getRedBtn() {
		return red;
	}

	public JButton getOrangeBtn() {
		return orange;
	}

	public JButton getYellowBtn() {
		return yellow;
	}

	public JButton getGreenBtn() {
		return green;
	}

	public JButton getBlueBtn() {
		return blue;
	}

	public JButton getPurpleBtn() {
		return purple;
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
