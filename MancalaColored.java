import javax.swing.*;
import java.awt.*;

public class MancalaColored implements MancalaAlter {
    private Color color;

    public MancalaColored(Color c) {
        color = c;
    }

    public void alter(MancalaGUI g) {
        setColors(g);
    }

    public void setColors(MancalaGUI g) {
        setColors(g, color);
    }

    public void setColors(MancalaGUI g, Color c) {
        g.getPanel("btns").setForeground(c);
        g.getPanel("btns").setBackground(c);
        //ADD MORE THINGS TO COLOR
    }
}