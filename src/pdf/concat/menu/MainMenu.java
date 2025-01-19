package pdf.concat.menu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * MainMenu class is the main menu for the PDF concatenation program.
 * It contains buttons for concatenation, reversing, merging, and exiting the program.
 * It also contains the MultiConcatMenu, MultiReverseMenu, and MergeMenu classes.
 * The MultiConcatMenu class is for concatenating multiple PDFs.
 * The MultiReverseMenu class is for reversing the order of multiple PDFs.
 * The MergeMenu class is for merging two PDFs together.
 */
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

    /**
     * Sets the MainMenu object to itself.
     */
    public void setSelf(MainMenu self) {
        this.self = self;
    }

    /**
     * Constructor for the MainMenu class.
     */
    public MainMenu() {
    }

    /**
     * Creates the main menu for the PDF concatenation program.
     * The main menu contains buttons for concatenation, reversing, merging, and exiting the program.
     * The main menu also contains the MultiConcatMenu, MultiReverseMenu, and MergeMenu classes.
     * The MultiConcatMenu class is for concatenating multiple PDFs.
     * The MultiReverseMenu class is for reversing the order of multiple PDFs.
     * The MergeMenu class is for merging two PDFs together.
     * The main menu is displayed on the screen.
     * The main menu is not visible by default.
     * The main menu is set to visible when the program is run.
     * The main menu is set to invisible when the program is exited.
     * The main menu is set to invisible when the MultiConcatMenu, MultiReverseMenu, or MergeMenu is displayed.
     * The main menu is set to visible when the MultiConcatMenu, MultiReverseMenu, or MergeMenu is exited.
     *
     *
     */
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


    /**
     * Sets the visibility of the main menu.
     *
     * @param input boolean value to set the visibility of the main menu
     */
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