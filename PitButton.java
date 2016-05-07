import javax.swing.JButton;

/**
 * JButton representing a pit on the Mancala board.
 * 
 * @author Team 7
 *
 */
public class PitButton extends JButton {
    private int buttonIndex;

    /**
     * Initializes a new pit JButton with text and index.
     * 
     * @param s		String of text to draw on the button.
     * @param i		Index of the button in the pits array.
     */
    public PitButton(String s, int i) {
        super(s);
        buttonIndex = i;
    }

    /**
     * Gets the buttons index in the pits array.
     * 
     * @return		Index of the button in the pits array.
     */
    public int getIndex() {
        return buttonIndex;
    }
}