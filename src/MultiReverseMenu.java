import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MultiReverseMenu extends AbstractMenu implements Interactable {
    private Chooser inputChooser;
    private List<Chooser> inputList = new ArrayList<>();
    private Chooser outputChooser = new Chooser(frame, false);
    private JButton add = new JButton("+");
    private JButton rev = new JButton("Reverse PDF");
    private JLabel wrong = new JLabel("Selected file is not a pdf.");
    private JLabel warning = new JLabel("Please choose at least one pdf, a location and a name.");
    private JLabel wrongWarning = new JLabel("Files are not pdfs. Choose " +
            "at least two pdfs, a location and a name.");
    private JLabel finish = new JLabel("Reversal completed.");
    private JButton back = new JButton("Go back");
    private JTextField field = new JTextField();
    private JLabel title = new JLabel("Reverse Order of Pages for Multiple PDF Files.");
    private MainMenu mainMenu;
    private boolean showWrong = false;

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public MultiReverseMenu() {
        inputChooser = new Chooser(frame, true, warning, finish, wrong, wrongWarning);

        title.setBounds(150, 0, 300, 50);
        inputChooser.createChooser(25, 50, 180, 50, "Choose PDF");
        add.setBounds(150, 100, 220, 50);
        outputChooser.createChooser(25, 150, 180, 150, "Choose Folder");
        setImportantBounds(false, rev, warning, finish, back, wrong, field, wrongWarning);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createInput(true, inputChooser, warning, finish, wrong, wrongWarning, inputList);
                moveButtons(6, outputChooser, rev, warning, finish, back, wrong, add, field, wrongWarning,
                        inputList);
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
                showWrong = checkType(inputChooser, inputList);
                if (inputPathOne == null || outputPath == null || name.isEmpty()) {
                    changeFieldColors(true, inputChooser, outputChooser, field, inputList);
                    if (showWrong) {
                        wrongWarningSetVisible(wrongWarning, finish, warning, wrong);
                    } else {
                        warningSetVisible(wrongWarning, finish, warning, wrong);
                    }
                } else {
                    if (showWrong) {
                        wrongSetVisible(wrongWarning, finish, warning, wrong);
                    } else {
                        MultiReverser reverser = new MultiReverser(list, outputPath, name);
                        reverser.reverse();
                        changeFieldColors(false, inputChooser, outputChooser, field, inputList);
                        finishSetVisible(wrongWarning, finish, warning, wrong);
                    }
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFieldColors(false, inputChooser, outputChooser, field, inputList);
                setVisibility(false);
                mainMenu.setVisibility(true);
            }
        });

        super.addToFrame(rev, warning, finish, back, wrong, field, title, wrongWarning);
        frame.add(add);
        setVisibility(false);
    }
    public void setVisibility(boolean input) {
        setVisibility(input, inputChooser, outputChooser, rev, warning, finish, back, wrong, add, field, title,
                wrongWarning, inputList);
    }
}