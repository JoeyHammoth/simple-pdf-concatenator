import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends AbstractMenu implements Interactable {
    private static MainMenu instance = new MainMenu();
    private JButton concatButton = new JButton("Concatenate");
    private JButton revButton = new JButton("Reverse");
    private JButton mergeButton = new JButton("Even/Odd Merge");
    private JLabel text = new JLabel("Select a PDF action.");

    private MainMenu() {
    }
    public static MainMenu getInstance() {
        return instance;
    }
    public static MainMenu getInstance(int count) {
        if (count >= MAX_ACCESS_COUNT) {
            instance = new MainMenu();
        }
        return instance;
    }
    public JFrame getFrame() {
        return this.frame;
    }
    public void createMenu() {
        super.clearFrame(frame);
        super.checkAccessCount(MAX_INSTANCE_COUNT);
        concatButton.setBounds(150, 200, 220, 50);
        revButton.setBounds(150, 150, 220, 50);
        mergeButton.setBounds(150, 100, 220, 50);
        text.setBounds(150, 50, 220, 50);

        concatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConcatMenu concatMenu = ConcatMenu.getInstance(MainMenu.super.getConCount());
                concatMenu.createMenu();
            }
        });

        revButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReverseMenu reverseMenu = ReverseMenu.getInstance(MainMenu.super.getRevCount());
                reverseMenu.createMenu();
            }
        });

        mergeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MergeMenu mergeMenu = MergeMenu.getInstance(MainMenu.super.getMergeCount());
                mergeMenu.createMenu();
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
