import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class MancalaGUI {
    private JButton[] pitButtons;
    private JButton opponentScore;
    private JButton playerScore;

    public MancalaGUI() {
        //Global Pit Buttons Array
        pitButtons = new JButton[12];
        //Global Player Score Button
        playerScore = new JButton("0");
        playerScore.setEnabled(false);
        playerScore.setBorder(new EmptyBorder(10, 10, 10, 10));
        //Global Opponent Score Button
        opponentScore = new JButton("0");
        opponentScore.setEnabled(false);
        opponentScore.setBorder(new EmptyBorder(10, 10, 10, 10));
		JPanel pitPanel = new JPanel();
		pitPanel.setLayout(new GridLayout(2, 6));
		pitPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton tmpBtn;
        for(int i = 0; i < pitButtons.length; i++) {
			tmpBtn = new JButton("0");
            if(i < 6)
                tmpBtn.setEnabled(false);
			tmpBtn.setBorderPainted(false);
			tmpBtn.setFocusPainted(false);
            tmpBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
			pitButtons[i] = tmpBtn;
			pitPanel.add(pitButtons[i]);
		}

        JFrame mancalaFrame = new JFrame();
		mancalaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mancalaFrame.setSize(200, 400);
		mancalaFrame.add(pitPanel, BorderLayout.CENTER);
        mancalaFrame.add(playerScore, BorderLayout.EAST);
        mancalaFrame.add(opponentScore, BorderLayout.WEST);
		mancalaFrame.setVisible(true);
		mancalaFrame.setResizable(false);
		mancalaFrame.pack();
    }

    public JButton[] getPits() {
        return pitButtons;
    }

    public JButton getScore(String i) {
        if(i.equals("player"))
            return playerScore;
        else if(i.equals("opponent"))
            return opponentScore;
        else return null;
    }
}