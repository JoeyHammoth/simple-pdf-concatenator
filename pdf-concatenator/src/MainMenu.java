import java.io.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu {
    private JFrame frame = new JFrame("PDF Concatenator");
    private JButton concatButton = new JButton("Concatenate");
    private JButton revButton = new JButton("Reverse");
    private JButton mergeButton = new JButton("Even/Odd Merge");
    private JLabel text = new JLabel("Select a PDF action.");
    public MainMenu() {

    }
    public JFrame getFrame() {
        return this.frame;
    }
    public void createMenu() {
        concatButton.setBounds(150, 200, 220, 50);
        revButton.setBounds(150, 150, 220, 50);
        mergeButton.setBounds(150, 100, 220, 50);
        text.setBounds(150, 50, 220, 50);

        concatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConcatMenu concatMenu = new ConcatMenu(frame);
            }
        });

        revButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReverseMenu reverseMenu = new ReverseMenu(frame);
            }
        });

        mergeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MergeMenu mergeMenu = new MergeMenu(frame);
            }
        });

        frame.add(concatButton);
        frame.add(revButton);
        frame.add(mergeButton);
        frame.add(text);
        frame.setSize(500, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
