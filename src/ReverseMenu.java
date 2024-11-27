import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReverseMenu implements Interactable {
    private Chooser inputChooser;
    private Chooser outputChooser;
    private JButton rev = new JButton("Reverse PDF");
    private JLabel warning = new JLabel("Please choose your pdfs and name.");
    private JLabel finish = new JLabel("Reversal completed.");
    private JButton back = new JButton("Go back");
    private JTextField field = new JTextField();
    private JLabel title = new JLabel("Reverse Order of Pages for a PDF.");

    public ReverseMenu() {
        frame.getContentPane().removeAll();
        frame.repaint();
        inputChooser = new Chooser(frame, true);
        outputChooser = new Chooser(frame, false);
    }
    public void createMenu() {
        title.setBounds(150, 0, 300, 50);
        inputChooser.createChooser(25, 50, 180, 50, "Choose PDF");
        outputChooser.createChooser(25, 100, 180, 100, "Choose Folder");
        field.setBounds(50, 150, 400, 30);
        field.setToolTipText("Fill in name of the file");
        rev.setBounds(150, 200, 220, 50);
        back.setBounds(150, 300, 220, 50);
        warning.setBounds(150, 250, 300, 50);
        finish.setBounds(150, 250, 220, 50);
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
                MainMenu mainMenu = new MainMenu();
                mainMenu.createMenu();
            }
        });

        frame.add(rev);
        frame.add(back);
        frame.add(warning);
        frame.add(finish);
        frame.add(field);
        frame.add(title);
        frame.setVisible(true);
    }
}
