import java.awt.Color;

import javax.swing.JButton;

/**
 * Concrete strategy implementation of the MancalaAlter interface. 
 * Used to apply a yellow GUI variation to the game board.
 * 
 * @author Team 7
 *
 */
public class AlterYellow implements MancalaAlter {
	private Color color;

	/**
	 * Initializes a MancalaAlter for the color yellow: 227 191 0
	 */
    public AlterYellow() {
    	color = new Color(227, 191, 0);
    }

    /**
     * Method to be called by the strategy pattern's context.
     */
    public void alter(MancalaGUI gui) {
        setColors(gui);
    }
    
    /**
     * Sets colors for the given MacalaGUI's components.
     * 
     * @param gui		The MancalaGUI to be recolored.
     */
    public void setColors(MancalaGUI gui) {
    	gui.getPanel("btns").setBackground(color);
    	gui.getPanel("menu").setBackground(color);
    	gui.getPanel("pits").setBackground(Color.DARK_GRAY);
    	gui.getButton("undo").setBackground(color);
    	gui.getButton("end").setBackground(color);
    	gui.getButton("changeBoardBtn").setBackground(color);
    	gui.getButton("quit").setBackground(color);
    	
    	for(JButton pitBtn : gui.getPits()) {
    		pitBtn.setBackground(Color.LIGHT_GRAY);
    	}
    }
}