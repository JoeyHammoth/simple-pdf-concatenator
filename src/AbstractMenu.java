import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu implements Interactable {
    public void clearFrame() {
        frame.getContentPane().removeAll();
        frame.repaint();
    }
}
