import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MultiReverseMenu implements Interactable {
    private Chooser inputChooser;
    private List<Chooser> inputList = new ArrayList<>();
    private Chooser outputChooser;
    private JButton add = new JButton("+");
    private JButton rev = new JButton("Reverse PDF");
    private JLabel warning = new JLabel("Please choose at least one pdf, a location and a name.");
    private JLabel finish = new JLabel("Reversal completed.");
    private JButton back = new JButton("Go back");
    private JTextField field = new JTextField();
    private JLabel title = new JLabel("Reverse Order of Pages for Multiple PDF Files.");

    public MultiReverseMenu() {
        frame.getContentPane().removeAll();
        frame.repaint();
        inputChooser = new Chooser(frame, true);
        outputChooser = new Chooser(frame, false);
    }
    public void moveButtons() {
        if (inputList.size() > 6) {
            add.setVisible(false);
        } else {
            add.setBounds(150, add.getBounds().y + 50, 220, 50);
            outputChooser.modifyChooser(25, outputChooser.getChooserButton().y + 50, 180,
                    outputChooser.getChooserField().y + 50);
            field.setBounds(50, field.getBounds().y + 50, 400, 30);
            rev.setBounds(150, rev.getBounds().y + 50, 220, 50);
            back.setBounds(150, back.getBounds().y + 50, 220, 50);
            warning.setBounds(100, warning.getBounds().y + 50, 600, 50);
            finish.setBounds(150, finish.getBounds().y + 50, 220, 50);
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
    public void createMenu() {
        title.setBounds(150, 0, 300, 50);
        inputChooser.createChooser(25, 50, 180, 50, "Choose PDF");
        add.setBounds(150, 100, 220, 50);
        outputChooser.createChooser(25, 150, 180, 150, "Choose Folder");
        field.setBounds(50, 200, 400, 30);
        field.setToolTipText("Fill in name of the file");
        rev.setBounds(150, 250, 220, 50);
        back.setBounds(150, 350, 220, 50);
        warning.setBounds(100, 300, 600, 50);
        finish.setBounds(150, 300, 220, 50);
        warning.setVisible(false);
        finish.setVisible(false);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createInput();
                moveButtons();
            }
        });

        rev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputPathOne = inputChooser.getFilePath();
                List<String> list = new ArrayList<>();
                list.add(inputPathOne);
                String outputPath = outputChooser.getFilePath();
                String name = field.getText();
                if (inputPathOne == null || outputPath == null || name.isEmpty()) {
                    warning.setVisible(true);
                    finish.setVisible(false);
                } else {
                    MultiReverser reverser = new MultiReverser(list, outputPath, name);
                    reverser.reverse();
                    finish.setVisible(true);
                    warning.setVisible(false);
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu mainMenu = new MainMenu();
                mainMenu.createMenu();
            }
        });

        frame.add(rev);
        frame.add(back);
        frame.add(warning);
        frame.add(finish);
        frame.add(field);
        frame.add(title);
        frame.add(add);
        frame.setVisible(true);
    }
}
