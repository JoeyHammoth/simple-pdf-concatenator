package pdf.concat.menu;

import pdf.concat.function.*;
import pdf.concat.Chooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents the menu for concatenating multiple pdfs.
 * It allows the user to choose multiple pdfs, a location and a name for the concatenated pdf.
 * It also allows the user to go back to the main menu.
 * It has a title, a warning label, a finish label, a back button, a wrong label, a text field, a wrong warning label,
 * a concatenate button, an add button, two input choosers and a folder chooser.
 * It has a main menu object to go back to the main menu.
 * It has a list of input choosers to allow the user to choose multiple pdfs.
 * It has a boolean to show the wrong warning label.
 * It has a method to set the main menu object.
 * It has a constructor to create the menu.
 * It has a method to set the visibility of the menu.
 * It has a method to concatenate the pdfs.
 * It has a method to go back to the main menu.
 * It has a method to add an input chooser.
 * It has a method to check the type of the pdfs.
 * It has a method to change the colors of the fields.
 *
 */
public class MultiConcatMenu extends AbstractMenu implements Interactable {
    private Chooser inputChooser1;
    private Chooser inputChooser2;
    private List<Chooser> inputList = new ArrayList<>();
    private Chooser folderChooser = new Chooser(Interactable.frame, false);
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

    /**
     * Sets the main menu object.
     * @param mainMenu the main menu object
     */
    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    /**
     * Creates the menu.
     */
    public MultiConcatMenu() {
        inputChooser1 = new Chooser(Interactable.frame, true, warning, finish, wrong, wrongWarning);
        inputChooser2 = new Chooser(Interactable.frame, true, warning, finish, wrong, wrongWarning);

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
        Interactable.frame.add(add);
        setVisibility(false);
    }

    /**
     * Sets the visibility of the menu.
     * @param input the list of pdfs
     */
    public void setVisibility(boolean input) {
        setVisibility(input, inputChooser1, inputChooser2, folderChooser, con, warning, finish, back, wrong, add,
                field, title, wrongWarning, inputList);
    }
}