import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class StartPanelGUI extends JFrame {
	private JPanel startPanel;
	private JButton threeStones;
	private JButton fourStones;
	private JButton red;
	private JButton orange;
	private JButton yellow;
	private JButton green;
	private JButton blue;
	private JButton purple;
	private int startStoneCount;
	private Color startBoardColor;
	
	public StartPanelGUI()
	{
		int width = 550;
		int height = 250;
		setSize(width, height);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.GRAY);
		getContentPane().setLayout(new GridLayout(3, 3));
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new BoxLayout(northPane, BoxLayout.Y_AXIS));
		
		JTextArea stonesTextArea = new JTextArea("How many stones would you like?");
		
		JPanel stoneBtnPane = new JPanel();
		threeStones = new JButton("3 Stones");
		fourStones = new JButton("4 Stones");
		stoneBtnPane.add(threeStones);
		stoneBtnPane.add(fourStones);
		northPane.add(stonesTextArea);
		northPane.add(stoneBtnPane);
		
		JPanel southPane = new JPanel();
		southPane.setLayout(new BoxLayout(southPane, BoxLayout.Y_AXIS));
		JTextArea colorTextArea = new JTextArea("What color board would you like?");
		southPane.add(stonesTextArea);
		JPanel colorBtnPane = new JPanel();
		southPane.add(colorBtnPane);		
		red = new JButton("Red");
		orange = new JButton("Orange");
		yellow = new JButton("Yellow");
		green = new JButton("Green");
		blue = new JButton("Blue");
		purple = new JButton("Purple");
		colorBtnPane.add(fourStones);
		
		this.add(northPane, BorderLayout.NORTH);
		this.add(southPane, BorderLayout.SOUTH);
		this.setVisible(true);
	}
}
