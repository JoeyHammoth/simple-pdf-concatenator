import javax.swing.*;
public abstract class AbstractMenu {
    private int mainCount = 0;
    private int revCount = 0;
    private int mergeCount = 0;
    private int conCount = 0;
    public int getMainCount() {
        return mainCount;
    }
    public int getRevCount() {
        return revCount;
    }
    public int getMergeCount() {
        return mergeCount;
    }
    public int getConCount() {
        return conCount;
    }
    public void checkAccessCount(int val) {
        if (mainCount >= val) {
            mainCount = 0;
        }
        if (revCount >= val) {
            revCount = 0;
        }
        if (mergeCount >= val) {
            mergeCount = 0;
        }
        if (conCount >= val) {
            conCount = 0;
        }
    }
    public void clearFrame(JFrame frame) {
        frame.getContentPane().removeAll();
        frame.repaint();
    }
}
