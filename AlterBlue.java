import javax.swing.*;

import java.awt.*;

public class AlterBlue implements MancalaAlter {
	private Color color;

    public AlterBlue() {
    	color = new Color(33, 79, 219);
    }

    public void alter(MancalaGUI gui) {
        setColors(gui);
    }

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