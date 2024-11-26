import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class ConcatMenu extends AbstractMenu implements Interactable {
    private static ConcatMenu instance = new ConcatMenu();
    private Chooser inputChooser1;
    private Chooser inputChooser2;
    private Chooser folderChooser;
    private JButton con = new JButton("Concatenate PDF");
    private JLabel warning = new JLabel("Please choose your pdfs and name.");
    private JLabel finish = new JLabel("Concatenation completed.");
    private JButton back = new JButton("Go back");
    private JTextField field = new JTextField();
    private JLabel title = new JLabel("A Simple PDF Concatenator.");

    private ConcatMenu() {
        inputChooser1 = new Chooser(frame, true);
        inputChooser2 = new Chooser(frame, true);
        folderChooser = new Chooser(frame, false);
    }
    public static ConcatMenu getInstance() {
        return instance;
    }
    public static ConcatMenu getInstance(int count) {
        if (count >= MAX_ACCESS_COUNT) {
            instance = new ConcatMenu();
        }
        return instance;
    }
    public void createMenu() {
        super.clearFrame(frame);
        super.checkAccessCount(MAX_INSTANCE_COUNT);
        title.setBounds(150, 0, 220, 50);
        inputChooser1.createChooser(25, 50, 180, 50, "Choose PDF 1");
        inputChooser2.createChooser(25, 100, 180, 100, "Choose PDF 2");
        folderChooser.createChooser(25, 150, 180, 150, "Choose Folder");
        field.setBounds(50, 200, 400, 30);
        field.setToolTipText("Fill in name of the file");
        con.setBounds(150, 250, 220, 50);
        back.setBounds(150, 350, 220, 50);
        warning.setBounds(150, 300, 300, 50);
        finish.setBounds(150, 300, 220, 50);
        finish.setVisible(false);
        warning.setVisible(false);

        con.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path1 = inputChooser1.getFilePath();
                String path2 = inputChooser2.getFilePath();
                String outputPath = folderChooser.getFilePath();
                String name = field.getText();
                if (path1 == null || path2 == null || outputPath == null || name.isEmpty()) {
                    finish.setVisible(false);
                    warning.setVisible(true);
                } else {
                    Concat concat = new Concat(path1, path2, outputPath, name);
                    try {
                        concat.concatenate();
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                    warning.setVisible(false);
                    finish.setVisible(true);
                }
            }
        });

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainMenu mainMenu = MainMenu.getInstance(ConcatMenu.super.getMainCount());
                mainMenu.createMenu();
            }
        });

        frame.add(con);
        frame.add(back);
        frame.add(warning);
        frame.add(finish);
        frame.add(field);
        frame.add(title);
        frame.setVisible(true);
    }


}
