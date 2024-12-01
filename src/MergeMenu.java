import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MergeMenu implements Interactable {
    private Chooser inputChooser1;
    private Chooser inputChooser2;
    private Chooser folderChooser = new Chooser(frame, false);
    private JButton merge = new JButton("Merge PDF");
    private JLabel wrong = new JLabel("Selected file is not a pdf.");
    private JLabel warning = new JLabel("Please choose your pdfs and name.");
    private JLabel wrongWarning = new JLabel("Files are not pdfs. Choose " +
            "at least two pdfs, a location and a name.");
    private JLabel finish = new JLabel("Merger completed.");
    private JButton back = new JButton("Go back");
    private JTextField field = new JTextField();
    private JLabel title = new JLabel("Merge Even and Odd Pages of PDF Files.");
    private MainMenu mainMenu;
    private boolean showWrong = false;

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public MergeMenu() {
        inputChooser1 = new Chooser(frame, true, warning, finish, wrong, wrongWarning);
        inputChooser2 = new Chooser(frame, true, warning, finish, wrong, wrongWarning);

        title.setBounds(150, 0, 300, 50);
        inputChooser1.createChooser(25, 50, 180, 50, "Choose Even PDF");
        inputChooser2.createChooser(25, 100, 180, 100, "Choose Odd PDF");
        folderChooser.createChooser(25, 150, 180, 150, "Choose Folder");
        field.setBounds(50, 200, 400, 30);
        field.setToolTipText("Fill in name of the file");
        merge.setBounds(150, 250, 220, 50);
        back.setBounds(150, 350, 220, 50);
        wrong.setBounds(150, 300, 600, 50);
        warning.setBounds(150, 300, 300, 50);
        wrongWarning.setBounds(50, 300, 1000, 50);
        finish.setBounds(150, 300, 220, 50);
        wrong.setForeground(Color.RED);
        warning.setForeground(Color.RED);
        wrongWarning.setForeground(Color.RED);
        finish.setVisible(false);
        warning.setVisible(false);
        wrong.setVisible(false);
        wrongWarning.setVisible(false);

        merge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path1 = inputChooser1.getFilePath();
                String path2 = inputChooser2.getFilePath();
                String outputPath = folderChooser.getFilePath();
                checkType();
                if (path1 == null || path2 == null || outputPath == null) {
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
                        Merger merger = new Merger(path1, path2, outputPath, "output.pdf");
                        merger.merge();
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

        frame.add(merge);
        frame.add(back);
        frame.add(warning);
        frame.add(finish);
        frame.add(field);
        frame.add(title);
        frame.add(wrong);
        frame.add(wrongWarning);
        setVisibility(false);
    }
    public void setVisibility(boolean input) {
        if (input) {
            inputChooser1.setVisibility(true);
            inputChooser2.setVisibility(true);
            folderChooser.setVisibility(true);
            merge.setVisible(true);
            back.setVisible(true);
            field.setVisible(true);
            title.setVisible(true);
        } else {
            inputChooser1.setVisibility(false);
            inputChooser2.setVisibility(false);
            folderChooser.setVisibility(false);
            merge.setVisible(false);
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
            inputChooser1.changeColors(true);
            inputChooser2.changeColors(true);
            folderChooser.changeColors(true);
            field.setBackground(Color.RED);
        } else {
            inputChooser1.changeColors(false);
            inputChooser2.changeColors(false);
            folderChooser.changeColors(false);
            field.setBackground(Color.WHITE);
        }
    }
    public void checkType() {
        boolean isWrong = false;
        if (!inputChooser1.getFilled()) {
            inputChooser1.changeColors(true);
            isWrong = true;
        }
        if (!inputChooser2.getFilled()) {
            inputChooser2.changeColors(true);
            isWrong = true;
        }
        showWrong = isWrong;
    }
}
