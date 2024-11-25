import javax.swing.*;

public class ReverseMenu {
    private JFrame frame;

    public ReverseMenu(JFrame frame) {
        this.frame = frame;
        frame.getContentPane().removeAll();
        frame.repaint();
    }
}
