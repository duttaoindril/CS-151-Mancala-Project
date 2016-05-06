import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

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
	private JButton selectedStoneBtn;
	private JButton selectedColorBtn;
	private int startStoneCount;
	private MancalaAlter startBoardColor;
	
	public StartPanelGUI() {
		int width = 550;
		int height = 250;
		setSize(width, height);
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());
		
		//Default stone count of 3
		startStoneCount = 3;
		//Default board color is orange
		startBoardColor = new AlterOrange();
		
		JPanel northPane = new JPanel();
		northPane.setLayout(new BoxLayout(northPane, BoxLayout.Y_AXIS));
		northPane.setBackground(Color.GRAY);
		JTextArea stonesTextArea = new JTextArea("Select the number of stones per pit: ");
		stonesTextArea.setEditable(false);
		stonesTextArea.setFocusable(false);
		JPanel stoneBtnPane = new JPanel();
		stoneBtnPane.setPreferredSize(new Dimension(width, height/2-70));
		threeStonesBtn = new JButton("3 Stones");
		threeStonesBtn.setPreferredSize(new Dimension(65, 45));
		threeStonesBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		fourStonesBtn = new JButton("4 Stones");
		fourStonesBtn.setPreferredSize(new Dimension(65, 45));
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
		
		JPanel southPane = new JPanel();
		southPane.setLayout(new BoxLayout(southPane, BoxLayout.Y_AXIS));
		southPane.setPreferredSize(new Dimension(width, height/2+20));
		//Creating wrapper panel for color selection prompt
		JPanel colorTextPane = new JPanel();
		colorTextPane.setBackground(Color.GRAY);
		southPane.add(colorTextPane);
		//Color selection prompt
		JTextArea colorTextArea = new JTextArea("Select your board color: ");
		colorTextArea.setEditable(false);
		colorTextArea.setFocusable(false);
		southPane.add(colorTextArea);
		//Creating color button panel
		JPanel colorBtnPane = new JPanel();
		southPane.add(colorBtnPane);
		//Creating color buttons
		redBtn = new JButton("Red");
		redBtn.setPreferredSize(new Dimension(65, 45));
		redBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		orangeBtn = new JButton("Orange");        
		orangeBtn.setPreferredSize(new Dimension(65, 45));
		orangeBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		yellowBtn = new JButton("Yellow");
		yellowBtn.setPreferredSize(new Dimension(65, 45));
		yellowBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		greenBtn = new JButton("Green");
		greenBtn.setPreferredSize(new Dimension(65, 45));
		greenBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		blueBtn = new JButton("Blue");
		blueBtn.setPreferredSize(new Dimension(65, 45));
		blueBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		purpleBtn = new JButton("Purple");
		purpleBtn.setPreferredSize(new Dimension(65, 45));
		purpleBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		//Adding color button listeners
		redBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		selectColorButton(redBtn);
        		startBoardColor = new AlterRed();
        	}
        });
		orangeBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		selectColorButton(orangeBtn);
        		startBoardColor = new AlterOrange();
        	}
        });
		yellowBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		selectColorButton(yellowBtn);
        		startBoardColor = new AlterYellow();
        	}
        });
		greenBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		selectColorButton(greenBtn);
        		startBoardColor = new AlterGreen();
        	}
        });
		blueBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		selectColorButton(blueBtn);
        		startBoardColor = new AlterBlue();
        	}
        });
		purpleBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e)
        	{
        		selectColorButton(purpleBtn);
        		startBoardColor = new AlterPurple();
        	}
        });
		
		colorBtnPane.add(redBtn);
		colorBtnPane.add(orangeBtn);
		colorBtnPane.add(yellowBtn);
		colorBtnPane.add(greenBtn);
		colorBtnPane.add(blueBtn);
		colorBtnPane.add(purpleBtn);
		
		//Creating play game button to start game after selections made
		JPanel playBtnPanel = new JPanel();
		playBtnPanel.setPreferredSize(new Dimension(width, 60));
		playBtn = new JButton("Play Game");
		playBtn.setPreferredSize(new Dimension(80, 45));
		playBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		playBtnPanel.add(playBtn);
		southPane.add(playBtnPanel);
		
		this.add(northPane, BorderLayout.NORTH);
		this.add(southPane, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	
	private void selectStoneButton(JButton stoneBtn) {
		if(selectedStoneBtn != null)
			selectedStoneBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		selectedStoneBtn = stoneBtn;
		stoneBtn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, false));
	}
	
	private void selectColorButton(JButton colorBtn) {
		if(selectedColorBtn != null)
			selectedColorBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		selectedColorBtn = colorBtn;
		colorBtn.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2, false));
	}
	
	public JButton getPlayBtn() {
		return playBtn;
	}

	public int getStartStoneCount() {
		return startStoneCount;
	}

	public MancalaAlter getStartBoardColor() {
		return startBoardColor;
	}
}