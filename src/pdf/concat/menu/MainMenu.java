package pdf.concat.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements Interactable {
    private JButton concatButton = new JButton("Concatenate");
    private JButton revButton = new JButton("Reverse");
    private JButton mergeButton = new JButton("Even/Odd Merge");
    private JButton exitButton = new JButton("Exit");
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
        exitButton.setBounds(150, 250, 220, 50);
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
                }
                reverseMenu.setVisibility(true);
            }
        });

        mergeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisibility(false);
                if (!containsMergeMen) {
                    containsMergeMen = true;
                    mergeMenu.setMainMenu(self);
                }
                mergeMenu.setVisibility(true);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Interactable.frame.add(concatButton);
        Interactable.frame.add(revButton);
        Interactable.frame.add(mergeButton);
        Interactable.frame.add(exitButton);
        Interactable.frame.add(text);
        Interactable.frame.setSize(500, 800);
        Interactable.frame.setLayout(null);
        Interactable.frame.setVisible(true);
    }

    public void setVisibility(boolean input) {
        if (input) {
            exitButton.setVisible(true);
            concatButton.setVisible(true);
            revButton.setVisible(true);
            mergeButton.setVisible(true);
            text.setVisible(true);
        } else {
            exitButton.setVisible(false);
            concatButton.setVisible(false);
            revButton.setVisible(false);
            mergeButton.setVisible(false);
            text.setVisible(false);
        }
    }
}