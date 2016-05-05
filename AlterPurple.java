import javax.swing.*;

import java.awt.*;

public class AlterPurple implements MancalaAlter {
	private Color color;

    public AlterPurple() {
    	color = new Color(102, 0, 102);
    }

    public void alter(MancalaGUI gui) {
        setColors(gui);
    }

    public void setColors(MancalaGUI gui) {
    	gui.getPanel("btns").setBackground(color);
    	gui.getPanel("menu").setBackground(color);
    	gui.getPanel("pits").setBackground(Color.DARK_GRAY);
    	
    	for(JButton pitBtn : gui.getPits()) {
    		pitBtn.setBackground(Color.LIGHT_GRAY);
    	}
    }
}