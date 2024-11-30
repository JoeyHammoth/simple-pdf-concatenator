import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MergeMenu implements Interactable {
    private Chooser inputChooser1;
    private Chooser inputChooser2;
    private Chooser folderChooser;
    private JButton merge = new JButton("Merge PDF");
    private JLabel warning = new JLabel("Please choose your pdfs and name.");
    private JLabel finish = new JLabel("Merger completed.");
    private JButton back = new JButton("Go back");
    private JTextField field = new JTextField();
    private JLabel title = new JLabel("Merge Even and Odd Pages of PDF Files.");
    private MainMenu mainMenu;

    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }

    public MergeMenu() {
        inputChooser1 = new Chooser(frame, true);
        inputChooser2 = new Chooser(frame, true);
        folderChooser = new Chooser(frame, false);
    }
    public void createMenu() {
        title.setBounds(150, 0, 300, 50);
        inputChooser1.createChooser(25, 50, 180, 50, "Choose Even PDF");
        inputChooser2.createChooser(25, 100, 180, 100, "Choose Odd PDF");
        folderChooser.createChooser(25, 150, 180, 150, "Choose Folder");
        field.setBounds(50, 200, 400, 30);
        field.setToolTipText("Fill in name of the file");
        merge.setBounds(150, 250, 220, 50);
        back.setBounds(150, 350, 220, 50);
        warning.setBounds(150, 300, 300, 50);
        finish.setBounds(150, 300, 220, 50);
        finish.setVisible(false);
        warning.setVisible(false);

        merge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path1 = inputChooser1.getFilePath();
                String path2 = inputChooser2.getFilePath();
                String outputPath = folderChooser.getFilePath();
                if (path1 == null || path2 == null || outputPath == null) {
                    finish.setVisible(false);
                    warning.setVisible(true);
                } else {
                    Merger merger = new Merger(path1, path2, outputPath, "output.pdf");
                    merger.merge();
                    warning.setVisible(false);
                    finish.setVisible(true);
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
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
        frame.setVisible(true);
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
        }
    }
}
