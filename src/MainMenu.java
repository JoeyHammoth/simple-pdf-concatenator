import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements Interactable{
    private JButton concatButton = new JButton("Concatenate");
    private JButton revButton = new JButton("Reverse");
    private JButton mergeButton = new JButton("Even/Odd Merge");
    private JLabel text = new JLabel("Select a PDF action.");
    public MainMenu() {
        frame.getContentPane().removeAll();
        frame.repaint();
    }
    public void createMenu() {
        concatButton.setBounds(150, 200, 220, 50);
        revButton.setBounds(150, 150, 220, 50);
        mergeButton.setBounds(150, 100, 220, 50);
        text.setBounds(150, 50, 220, 50);

        concatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConcatMenu concatMenu = new ConcatMenu();
                concatMenu.createMenu();
            }
        });

        revButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MultiReverseMenu reverseMenu = new MultiReverseMenu();
                reverseMenu.createMenu();
            }
        });

        mergeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MergeMenu mergeMenu = new MergeMenu();
                mergeMenu.createMenu();
            }
        });

        frame.add(concatButton);
        frame.add(revButton);
        frame.add(mergeButton);
        frame.add(text);
        frame.setSize(500, 800);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
