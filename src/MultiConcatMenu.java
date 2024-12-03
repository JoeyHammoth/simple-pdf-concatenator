import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class MultiConcatMenu extends AbstractMenu implements Interactable {
    private Chooser inputChooser1;
    private Chooser inputChooser2;
    private List<Chooser> inputList = new ArrayList<>();
    private Chooser folderChooser = new Chooser(frame, false);
    private JButton add = new JButton("+");
    private JButton con = new JButton("Concatenate PDF");
    private JLabel wrong = new JLabel("Selected file is not a pdf.");
    private JLabel warning = new JLabel("Please choose at least two pdfs, a location and a name.");
    private JLabel wrongWarning = new JLabel("Files are not pdfs. Choose " +
            "at least two pdfs, a location and a name.");
    private JLabel finish = new JLabel("Concatenation completed.");
    private JButton back = new JButton("Go back");
    private JTextField field = new JTextField();
    private JLabel title = new JLabel("A Simple PDF Concatenator.");
    private MainMenu mainMenu;
    private boolean showWrong = false;

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public MultiConcatMenu() {
        inputChooser1 = new Chooser(frame, true, warning, finish, wrong, wrongWarning);
        inputChooser2 = new Chooser(frame, true, warning, finish, wrong, wrongWarning);

        title.setBounds(150, 0, 220, 50);
        inputChooser1.createChooser(25, 50, 180, 50, "Choose PDF 1");
        inputChooser2.createChooser(25, 100, 180, 100, "Choose PDF 2");
        add.setBounds(150, 150, 220, 50);
        folderChooser.createChooser(25, 200, 180, 200, "Choose Folder");
        setImportantBounds(true, con, warning, finish, back, wrong, field, wrongWarning);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createInput(false, inputChooser2, warning, finish, wrong, wrongWarning, inputList);
                moveButtons(5, folderChooser, con, warning, finish, back, wrong, add, field, wrongWarning,
                        inputList);
            }
        });

        con.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path1 = inputChooser1.getFilePath();
                String path2 = inputChooser2.getFilePath();
                List<String> list = new ArrayList<>();
                list.add(path1);
                list.add(path2);
                String outputPath = folderChooser.getFilePath();
                String name = field.getText();
                showWrong = checkType(inputChooser1, inputChooser2, inputList);
                if (path1 == null || path2 == null || outputPath == null || name.isEmpty()) {
                    changeFieldColors(true, inputChooser1, inputChooser2, folderChooser, field, inputList);
                    if (showWrong) {
                        wrongWarningSetVisible(wrongWarning, finish, warning, wrong);
                    } else {
                        warningSetVisible(wrongWarning, finish, warning, wrong);
                    }
                } else {
                    if (showWrong) {
                        wrongSetVisible(wrongWarning, finish, warning, wrong);
                    } else {
                        MultiConcat concat = new MultiConcat(list, outputPath, name);
                        try {
                            concat.concatenate();
                        } catch (FileNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                        changeFieldColors(false, inputChooser1, inputChooser2, folderChooser, field, inputList);
                        finishSetVisible(wrongWarning, finish, warning, wrong);
                    }
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFieldColors(false, inputChooser1, inputChooser2, folderChooser, field, inputList);
                setVisibility(false);
                mainMenu.setVisibility(true);
            }
        });

        super.addToFrame(con, warning, finish, back, wrong, field, title, wrongWarning);
        frame.add(add);
        setVisibility(false);
    }

    public void setVisibility(boolean input) {
        setVisibility(input, inputChooser1, inputChooser2, folderChooser, con, warning, finish, back, wrong, add,
                field, title, wrongWarning, inputList);
    }
}