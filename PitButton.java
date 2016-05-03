import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class PitButton extends JButton {
    private int buttonIndex;

    public PitButton(String s, int i) {
        super(s);
        buttonIndex = i;
    }

    public int getIndex() {
        return buttonIndex;
    }
}