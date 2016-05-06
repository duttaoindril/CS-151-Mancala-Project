import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StartPanelGUI extends JPanel {
	private JButton threeStonesBtn;
	private JButton fourStonesBtn;
	private JButton playBtn;
	private JButton selectedStoneBtn;
	private int startStoneCount;
	private BoardSelectionPanel boardSelectionPanel;
	
	public StartPanelGUI() {
		int width = 550;
		int height = 250;
		setSize(width, height);
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());
		
		//Default stone count of 3
		startStoneCount = 3;
		
		JPanel northPane = new JPanel();
		northPane.setBackground(Color.DARK_GRAY);
		northPane.setLayout(new BoxLayout(northPane, BoxLayout.Y_AXIS));
		JTextArea stonesTextArea = new JTextArea("Select the number of stones per pit: ");
		stonesTextArea.setBackground(Color.DARK_GRAY);
		stonesTextArea.setForeground(Color.WHITE);
		stonesTextArea.setEditable(false);
		stonesTextArea.setFocusable(false);
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
	
	private void selectStoneButton(JButton stoneBtn) {
		if(selectedStoneBtn != null)
			selectedStoneBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		selectedStoneBtn = stoneBtn;
		stoneBtn.setBorder(BorderFactory.createLineBorder(new Color(94,223,255), 2, false));
	}
	
	public JButton getPlayBtn() {
		return playBtn;
	}

	public int getStartStoneCount() {
		return startStoneCount;
	}

	public MancalaAlter getStartBoardColor() {
		return boardSelectionPanel.getBoardSelection();
	}
}