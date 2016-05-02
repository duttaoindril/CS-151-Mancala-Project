import javax.swing.*;
import java.awt.*;

public class MancalaColored implements MancalaColor {
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
        g.getPanel().setForeground(c);
        g.getPanel().setBackground(c);
        //ADD MORE THINGS TO COLOR
    }
}