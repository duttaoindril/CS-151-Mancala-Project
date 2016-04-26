import javax.swing.JButton;

public class MancalaGUI {
    private JButton[] pitButtons;
    private JButton opponentScore;
    private JButton playerScore;

    public MancalaGUI() {
        pitButtons = new JButton[12];

        playerScore = new JButton("0");
        playerScore.setEnabled(false);

        opponentScore = new JButton("0");
        opponentScore.setEnabled(false);

		JPanel pitPanel = new JPanel();
		pitPanel.setLayout(new GridLayout(12, 2));
		pitPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JButton tmpBtn;
        for(int i = 0; i < pitButtons.length; i++) {
			tmpBtn = new JButton();
			tmpBtn.setBorderPainted(false);
			tmpBtn.setFocusPainted(false);
            tmpBtn.setBorder(new EmptyBorder(10, 10, 10, 10));
			pitButtons[i] = tmpBtn;
			dateButtonPanel.add(pitButtons[i]);
		}

        JFrame mancalaFrame = new JFrame();
		mancalaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mancalaFrame.setSize(200, 400);
		mancalaFrame.add(monthDatePanel, BorderLayout.WEST);
		mancalaFrame.add(calViewPanel, BorderLayout.BEFORE_FIRST_LINE);
		mancalaFrame.add(tablePanel);
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