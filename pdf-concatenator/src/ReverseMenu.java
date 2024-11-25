import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class ReverseMenu implements Interactable {
    private JFrame frame;
    private Chooser inputChooser;
    private Chooser outputChooser;
    private JButton rev = new JButton("Reverse PDF");
    private JLabel warning = new JLabel("Please choose your pdf.");
    private JLabel finish = new JLabel("Reversal completed.");
    private JButton back = new JButton("Go back");

    public ReverseMenu(JFrame frame) {
        this.frame = frame;
        frame.getContentPane().removeAll();
        frame.repaint();
        inputChooser = new Chooser(frame, true);
        outputChooser = new Chooser(frame, false);
    }
    public void createMenu() {
        inputChooser.createChooser(25, 50, 180, 50, "Choose PDF");
        outputChooser.createChooser(25, 100, 180, 100, "Choose Folder");
        rev.setBounds(150, 150, 220, 50);
        back.setBounds(150, 250, 220, 50);
        warning.setBounds(150, 200, 220, 50);
        finish.setBounds(150, 200, 220, 50);
        warning.setVisible(false);
        finish.setVisible(false);

        rev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputPath = inputChooser.getFilePath();
                String outputPath = outputChooser.getFilePath();
                if (inputPath == null || outputPath == null) {
                    warning.setVisible(true);
                    finish.setVisible(false);
                } else {
                    Reverser reverser = new Reverser(inputPath, outputPath, "output.pdf");
                    reverser.reverse();
                    finish.setVisible(true);
                    warning.setVisible(false);
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

        frame.add(rev);
        frame.add(back);
        frame.add(warning);
        frame.add(finish);
        frame.setVisible(true);
    }
}
