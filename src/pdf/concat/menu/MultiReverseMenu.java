package pdf.concat.menu;

import pdf.concat.function.*;
import pdf.concat.Chooser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * A class that represents the menu for reversing the order of pages for multiple pdfs.
 * It allows the user to choose multiple pdfs, a location and a name for the reversed pdf.
 * It also allows the user to go back to the main menu.
 * It has a title, a warning label, a finish label, a back button, a wrong label, a text field, a wrong warning label,
 * a reverse button, an add button, two input choosers and a folder chooser.
 * It has a main menu object to go back to the main menu.
 * It has a list of input choosers to allow the user to choose multiple pdfs.
 * It has a boolean to show the wrong warning label.
 * It has a method to set the main menu object.
 * It has a constructor to create the menu.
 * It has a method to set the visibility of the menu.
 * It has a method to reverse the pdfs.
 * It has a method to go back to the main menu.
 * It has a method to add an input chooser.
 * It has a method to check the type of the pdfs.
 * It has a method to change the colors of the fields.
 *
 */
public class MultiReverseMenu extends AbstractMenu implements Interactable {
    private Chooser inputChooser;
    private List<Chooser> inputList = new ArrayList<>();
    private Chooser outputChooser = new Chooser(Interactable.frame, false);
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
    public MultiReverseMenu() {
        inputChooser = new Chooser(Interactable.frame, true, warning, finish, wrong, wrongWarning);

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
        Interactable.frame.add(add);
        setVisibility(false);
    }

    /**
     * Sets the visibility of the menu.
     * @param input the boolean to set the visibility
     */
    public void setVisibility(boolean input) {
        setVisibility(input, inputChooser, outputChooser, rev, warning, finish, back, wrong, add, field, title,
                wrongWarning, inputList);
    }
}