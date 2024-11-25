import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class ConcatMenu implements Interactable {
    private JFrame frame;
    private Chooser inputChooser1;
    private Chooser inputChooser2;
    private Chooser folderChooser;
    private JButton con = new JButton("Concatenate PDF");
    private JLabel warning = new JLabel("Please choose your pdfs.");
    private JLabel finish = new JLabel("Concatenation completed.");
    private JButton back = new JButton("Go back");


    public ConcatMenu(JFrame frame) {
        this.frame = frame;
        frame.getContentPane().removeAll();
        frame.repaint();
        inputChooser1 = new Chooser(frame, true);
        inputChooser2 = new Chooser(frame, true);
        folderChooser = new Chooser(frame, false);
    }
    public void createMenu() {
        inputChooser1.createChooser(50, 50, 180, 50, "Choose PDF 1");
        inputChooser2.createChooser(50, 100, 180, 100, "Choose PDF 2");
        folderChooser.createChooser(50, 150, 180, 150, "Choose Folder");
        con.setBounds(150, 200, 220, 50);
        back.setBounds(150, 300, 220, 50);
        warning.setBounds(150, 250, 220, 50);
        finish.setBounds(150, 250, 220, 50);
        finish.setVisible(false);
        warning.setVisible(false);

        con.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String path1 = inputChooser1.getFilePath();
                String path2 = inputChooser2.getFilePath();
                String outputPath = folderChooser.getFilePath();
                if (path1 == null || path2 == null || outputPath == null) {
                    finish.setVisible(false);
                    warning.setVisible(true);
                } else {
                    Concat concat = new Concat(path1, path2, outputPath, "output.pdf");
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
                MainMenu mainMenu = new MainMenu(frame);
                mainMenu.createMenu();
            }
        });

        frame.add(con);
        frame.add(back);
        frame.add(warning);
        frame.add(finish);
        frame.setVisible(true);
    }


}
