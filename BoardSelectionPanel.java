import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

/**
 * JPanel containing alternate board selection UI. Encapsulates all necessary
 * components and listeners for color selection. Selected buttons are highlighted
 * when clicked and the corresponding MancalaAlter value is stored.
 * 
 * @author Team 7
 * 
 */
public class BoardSelectionPanel extends JPanel {
	private JButton redBtn;
	private JButton orangeBtn;
	private JButton yellowBtn;
	private JButton greenBtn;
	private JButton blueBtn;
	private JButton purpleBtn;
	private JButton selectedColorBtn;
	private MancalaAlter startBoardColor;
	
	/**
	 * Initializes a new BoardSelectionPanel with text prompt and
	 * six color selection buttons.
	 */
	public BoardSelectionPanel() {
		this.setBackground(Color.DARK_GRAY);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		//Creating wrapper panel for color selection prompt
		JPanel colorTextPane = new JPanel();
		colorTextPane.setBackground(Color.DARK_GRAY);
		this.add(colorTextPane);
		//Color selection prompt
		JTextArea colorTextArea = new JTextArea("Select your board color: ");
		colorTextArea.setBackground(Color.DARK_GRAY);
		colorTextArea.setForeground(Color.WHITE);
		colorTextArea.setEditable(false);
		colorTextArea.setFocusable(false);
		this.add(colorTextArea);
		//Creating color button panel
		JPanel colorBtnPane = new JPanel();
		colorBtnPane.setBackground(Color.DARK_GRAY);
		this.add(colorBtnPane);
		//Creating color buttons
		redBtn = new JButton("Red");
		redBtn.setPreferredSize(new Dimension(65, 45));
		redBtn.setFocusable(false);
		redBtn.setBackground(Color.DARK_GRAY);
		redBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		orangeBtn = new JButton("Orange");        
		orangeBtn.setPreferredSize(new Dimension(65, 45));
		orangeBtn.setFocusable(false);
		orangeBtn.setBackground(Color.DARK_GRAY);
		orangeBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		yellowBtn = new JButton("Yellow");
		yellowBtn.setPreferredSize(new Dimension(65, 45));
		yellowBtn.setFocusable(false);
		yellowBtn.setBackground(Color.DARK_GRAY);
		yellowBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		greenBtn = new JButton("Green");
		greenBtn.setPreferredSize(new Dimension(65, 45));
		greenBtn.setFocusable(false);
		greenBtn.setBackground(Color.DARK_GRAY);
		greenBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		blueBtn = new JButton("Blue");
		blueBtn.setPreferredSize(new Dimension(65, 45));
		blueBtn.setFocusable(false);
		blueBtn.setBackground(Color.DARK_GRAY);
		blueBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		purpleBtn = new JButton("Purple");
		purpleBtn.setPreferredSize(new Dimension(65, 45));
		purpleBtn.setFocusable(false);
		purpleBtn.setBackground(Color.DARK_GRAY);
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
	}
	
	/**
	 * Highlights clicked button with a blue border.
	 * 
	 * @param colorBtn		JButton to be highlighted.
	 */
	private void selectColorButton(JButton colorBtn) {
		if(selectedColorBtn != null)
			selectedColorBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
		selectedColorBtn = colorBtn;
		colorBtn.setBorder(BorderFactory.createLineBorder(new Color(94,223,255), 2, false));
	}
	
	/**
	 * Gets the MancalaAlter corresponding to the selected button.
	 * 
	 * @return				MancalaAlter object corresponding to selected button.
	 */
	public MancalaAlter getBoardSelection() {
		return startBoardColor;
	}
}
