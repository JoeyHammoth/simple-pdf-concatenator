package pdf.concat.menu;

import pdf.concat.Chooser;
import pdf.concat.function.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MergeMenu extends AbstractMenu implements Interactable {
    private Chooser inputChooser1;
    private Chooser inputChooser2;
    private Chooser folderChooser = new Chooser(Interactable.frame, false);
    private JButton merge = new JButton("Merge PDF");
    private JLabel wrong = new JLabel("Selected file is not a pdf.");
    private JLabel warning = new JLabel("Please choose your pdfs and name.");
    private JLabel wrongWarning = new JLabel("Files are not pdfs. Choose " +
            "at least two pdfs, a location and a name.");
    private JLabel finish = new JLabel("pdf.concat.function.Merger completed.");
    private JButton back = new JButton("Go back");
    private JTextField field = new JTextField();
    private JLabel title = new JLabel("Merge Even and Odd Pages of PDF Files.");
    private MainMenu mainMenu;
    private boolean showWrong = false;

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public MergeMenu() {
        inputChooser1 = new Chooser(Interactable.frame, true, warning, finish, wrong, wrongWarning);
        inputChooser2 = new Chooser(Interactable.frame, true, warning, finish, wrong, wrongWarning);

        title.setBounds(150, 0, 300, 50);
        inputChooser1.createChooser(25, 50, 180, 50, "Choose Even PDF");
        inputChooser2.createChooser(25, 100, 180, 100, "Choose Odd PDF");
        folderChooser.createChooser(25, 150, 180, 150, "Choose Folder");
        setImportantBounds(false, merge, warning, finish, back, wrong, field, wrongWarning);

        merge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path1 = inputChooser1.getFilePath();
                String path2 = inputChooser2.getFilePath();
                String outputPath = folderChooser.getFilePath();
                String name = field.getText();
                showWrong = checkType(inputChooser1, inputChooser2);
                if (path1 == null || path2 == null || outputPath == null || name.isEmpty()) {
                    changeFieldColors(true, inputChooser1, inputChooser2, folderChooser, field);
                    if (showWrong) {
                        wrongWarningSetVisible(wrongWarning, finish, warning, wrong);
                    } else {
                        warningSetVisible(wrongWarning, finish, warning, wrong);
                    }
                } else {
                    if (showWrong) {
                        wrongSetVisible(wrongWarning, finish, warning, wrong);
                    } else {
                        Merger merger = new Merger(path1, path2, outputPath, "output.pdf");
                        merger.merge();
                        changeFieldColors(false, inputChooser1, inputChooser2, folderChooser, field);
                        finishSetVisible(wrongWarning, finish, warning, wrong);
                    }
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeFieldColors(false, inputChooser1, inputChooser2, folderChooser, field);
                setVisibility(false);
                mainMenu.setVisibility(true);
            }
        });

        addToFrame(merge, warning, finish, back, wrong, field, title, wrongWarning);
        setVisibility(false);
    }

    public void setVisibility(boolean input) {
        setVisibility(input, inputChooser1, inputChooser2, folderChooser, merge, warning, finish, back, wrong,
                field, title, wrongWarning);
    }
}