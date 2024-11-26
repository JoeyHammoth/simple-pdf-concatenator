import javax.swing.*;
public interface Interactable {
    int MAX_ACCESS_COUNT = 1;
    int MAX_INSTANCE_COUNT = 5;
    JFrame frame = new JFrame("PDF Concatenator");
    void createMenu();
}
