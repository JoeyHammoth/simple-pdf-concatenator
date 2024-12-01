import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MultiReverseMenu implements Interactable, MultiInteractable {
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
        field.setBounds(50, 200, 400, 30);
        field.setToolTipText("Fill in name of the file");
        rev.setBounds(150, 250, 220, 50);
        back.setBounds(150, 350, 220, 50);
        wrong.setBounds(150, 300, 600, 50);
        warning.setBounds(100, 300, 600, 50);
        wrongWarning.setBounds(50, 300, 1000, 50);
        finish.setBounds(150, 300, 220, 50);
        wrong.setForeground(Color.RED);
        warning.setForeground(Color.RED);
        wrongWarning.setForeground(Color.RED);
        warning.setVisible(false);
        wrong.setVisible(false);
        wrongWarning.setVisible(false);
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
                checkType();
                if (inputPathOne == null || outputPath == null || name.isEmpty()) {
                    changeFieldColors(true);
                    if (showWrong) {
                        wrongWarning.setVisible(true);
                        finish.setVisible(false);
                        warning.setVisible(false);
                        wrong.setVisible(false);
                    } else {
                        wrongWarning.setVisible(false);
                        finish.setVisible(false);
                        warning.setVisible(true);
                        wrong.setVisible(false);
                    }
                } else {
                    if (showWrong) {
                        wrongWarning.setVisible(false);
                        finish.setVisible(false);
                        warning.setVisible(false);
                        wrong.setVisible(true);
                    } else {
                        MultiReverser reverser = new MultiReverser(list, outputPath, name);
                        reverser.reverse();
                        changeFieldColors(false);
                        wrong.setVisible(false);
                        warning.setVisible(false);
                        finish.setVisible(true);
                        wrongWarning.setVisible(false);
                    }
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFieldColors(false);
                setVisibility(false);
                mainMenu.setVisibility(true);
            }
        });

        frame.add(rev);
        frame.add(back);
        frame.add(warning);
        frame.add(finish);
        frame.add(field);
        frame.add(title);
        frame.add(add);
        frame.add(wrong);
        frame.add(wrongWarning);
        setVisibility(false);
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
            wrong.setBounds(150, wrong.getBounds().y + 50, 600, 50);
            wrongWarning.setBounds(50, wrongWarning.getBounds().y + 50, 1000, 50);
        }
    }
    public void createInput() {
        Chooser input = new Chooser(frame, true, warning, finish, wrong, wrongWarning);
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
            rev.setVisible(true);
            back.setVisible(true);
            field.setVisible(true);
            title.setVisible(true);
            add.setVisible(inputList.size() <= 6);
        } else {
            inputChooser.setVisibility(false);
            for (Chooser chooser : inputList) {
                chooser.setVisibility(false);
            }
            outputChooser.setVisibility(false);
            add.setVisible(false);
            rev.setVisible(false);
            warning.setVisible(false);
            finish.setVisible(false);
            back.setVisible(false);
            field.setVisible(false);
            title.setVisible(false);
            wrong.setVisible(false);
            wrongWarning.setVisible(false);
        }
    }
    public void changeFieldColors(boolean input) {
        if (input) {
            inputChooser.changeColors(true);
            outputChooser.changeColors(true);
            field.setBackground(Color.RED);
        } else {
            for (Chooser chooser : inputList) {
                chooser.changeColors(false);
            }
            inputChooser.changeColors(false);
            outputChooser.changeColors(false);
            field.setBackground(Color.WHITE);
        }
    }
    public void checkType() {
        boolean isWrong = false;
        if (!inputChooser.getFilled()) {
            inputChooser.changeColors(true);
            isWrong = true;
        }
        for (Chooser chooser : inputList) {
            if (!chooser.getFilled()) {
                chooser.changeColors(true);
                isWrong = true;
            }
        }
        showWrong = isWrong;
    }
}
