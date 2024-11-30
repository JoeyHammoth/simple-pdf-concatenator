import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements Interactable{
    private JButton concatButton = new JButton("Concatenate");
    private JButton revButton = new JButton("Reverse");
    private JButton mergeButton = new JButton("Even/Odd Merge");
    private JLabel text = new JLabel("Select a PDF action.");
    private MultiConcatMenu concatMenu = new MultiConcatMenu();
    private MultiReverseMenu reverseMenu = new MultiReverseMenu();
    private MergeMenu mergeMenu = new MergeMenu();
    private boolean containsConMen = false;
    private boolean containsRevMen = false;
    private boolean containsMergeMen = false;
    private MainMenu self;

    public void setSelf(MainMenu self) {
        this.self = self;
    }
    public MainMenu() {
    }
    public void createMenu() {
        concatButton.setBounds(150, 200, 220, 50);
        revButton.setBounds(150, 150, 220, 50);
        mergeButton.setBounds(150, 100, 220, 50);
        text.setBounds(150, 50, 220, 50);

        concatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisibility(false);
                if (!containsConMen) {
                    containsConMen = true;
                    concatMenu.setMainMenu(self);
                }
                concatMenu.setVisibility(true);
            }
        });

        revButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisibility(false);
                if (!containsRevMen) {
                    containsRevMen = true;
                    reverseMenu.setMainMenu(self);
                    reverseMenu.createMenu();
                } else {
                    reverseMenu.setVisibility(true);
                }
            }
        });

        mergeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisibility(false);
                if (!containsMergeMen) {
                    containsMergeMen = true;
                    mergeMenu.setMainMenu(self);
                    mergeMenu.createMenu();
                } else {
                    mergeMenu.setVisibility(true);
                }
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

    public void setVisibility(boolean input) {
        if (input) {
            concatButton.setVisible(true);
            revButton.setVisible(true);
            mergeButton.setVisible(true);
            text.setVisible(true);
        } else {
            concatButton.setVisible(false);
            revButton.setVisible(false);
            mergeButton.setVisible(false);
            text.setVisible(false);
        }
    }
}
