import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMenu implements Interactable{
    private Chooser inputChooser;
    private List<Chooser> inputList = new ArrayList<>();
    private Chooser outputChooser;
    private JButton add = new JButton("+");
    private JButton back = new JButton("Go back");
    private JTextField field = new JTextField();
    public void moveButtons() {
        if (inputList.size() > 6) {
            add.setVisible(false);
        } else {
            add.setBounds(150, add.getBounds().y + 50, 220, 50);
            outputChooser.modifyChooser(25, outputChooser.getChooserButton().y + 50, 180,
                    outputChooser.getChooserField().y + 50);
            field.setBounds(50, field.getBounds().y + 50, 400, 30);
            back.setBounds(150, back.getBounds().y + 50, 220, 50);
        }
    }
    public void createInput() {
        Chooser input = new Chooser(frame, true);
        if (inputList.isEmpty()) {
            input.createChooser(25, inputChooser.getChooserButton().y + 50, 180,
                    inputChooser.getChooserField().y + 50, "Choose PDF");
        } else {
            input.createChooser(25, inputList.getLast().getChooserButton().y + 50, 180,
                    inputList.getLast().getChooserField().y + 50, "Choose PDF");
        }
        inputList.add(input);
    }
    public void setVisibility(boolean input) {
        if (input) {
            inputChooser.setVisibility(true);
            for (Chooser chooser : inputList) {
                chooser.setVisibility(true);
            }
            outputChooser.setVisibility(true);
            add.setVisible(true);
            back.setVisible(true);
            field.setVisible(true);
        } else {
            inputChooser.setVisibility(false);
            for (Chooser chooser : inputList) {
                chooser.setVisibility(false);
            }
            outputChooser.setVisibility(false);
            add.setVisible(false);
            back.setVisible(false);
            field.setVisible(false);
        }
    }
}
