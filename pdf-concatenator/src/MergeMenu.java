import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class MergeMenu implements Interactable {
    private JFrame frame;
    private Chooser inputChooser1;
    private Chooser inputChooser2;
    private Chooser folderChooser;
    private JButton merge = new JButton("Merge PDF");
    private JLabel warning = new JLabel("Please choose your pdfs.");
    private JLabel finish = new JLabel("Merger completed.");
    private JButton back = new JButton("Go back");

    public MergeMenu(JFrame frame) {
        this.frame = frame;
        frame.getContentPane().removeAll();
        frame.repaint();
        inputChooser1 = new Chooser(frame, true);
        inputChooser2 = new Chooser(frame, true);
        folderChooser = new Chooser(frame, false);
    }
    public void createMenu() {
        inputChooser1.createChooser(25, 50, 180, 50, "Choose Even PDF");
        inputChooser2.createChooser(25, 100, 180, 100, "Choose Odd PDF");
        folderChooser.createChooser(25, 150, 180, 150, "Choose Folder");
        merge.setBounds(150, 200, 220, 50);
        back.setBounds(150, 300, 220, 50);
        warning.setBounds(150, 250, 220, 50);
        finish.setBounds(150, 250, 220, 50);
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
                MainMenu mainMenu = new MainMenu(frame);
                mainMenu.createMenu();
            }
        });

        frame.add(merge);
        frame.add(back);
        frame.add(warning);
        frame.add(finish);
        frame.setVisible(true);
    }
}
