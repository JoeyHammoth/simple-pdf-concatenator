package pdf.concat;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class that represents a chooser for a file or folder. It allows the user to choose a file or folder
 * and displays the file path in a text field. It has a method to get the file path attribute. It has a
 * method to set the visibility of the chooser. It has a method to change the colors of the fields. It has
 * a method to check the type of the file.
 */
public class Chooser {
    private static String lastDirectory = System.getProperty("user.home");
    private JFrame frame;
    private JButton openButton;
    private JTextField filePathField;
    private String filePath;
    private boolean isFile;
    private JLabel wrong;
    private JLabel warning;
    private JLabel finish;
    private JLabel wrongWarning;
    private boolean usePdfChecker = false;
    private boolean filled = true;

    /**
     * Gets the filled attribute.
     * @return the filled attribute
     */
    public boolean getFilled() {
        return filled;
    }

    /**
     * Creates a chooser for a file or folder.
     * @param frame the frame to add the chooser to
     * @param isFile a boolean to determine if the chooser is for a file or folder
     * @param warning the warning label
     * @param finish the finish label
     * @param wrong the wrong label
     * @param wrongWarning the wrong warning label
     */
    public Chooser(JFrame frame, boolean isFile, JLabel warning, JLabel finish, JLabel wrong, JLabel wrongWarning) {
        this.frame = frame;
        this.isFile = isFile;
        this.warning = warning;
        this.finish = finish;
        this.wrong = wrong;
        this.wrongWarning = wrongWarning;
        this.usePdfChecker = true;
    }

    /**
     * Creates a chooser for a file or folder.
     * @param frame the frame to add the chooser to
     * @param isFile a boolean to determine if the chooser is for a file or folder
     */
    public Chooser(JFrame frame, boolean isFile) {
        this.frame = frame;
        this.isFile = isFile;
    }

    /**
     * Modifies the chooser's position.
     * @param x1 the x-coordinate of the open button
     * @param y1 the y-coordinate of the open button
     * @param x2 the x-coordinate of the file path field
     * @param y2 the y-coordinate of the file path field
     */
    public void modifyChooser(int x1, int y1, int x2, int y2) {
        openButton.setBounds(x1, y1, 150, 30);
        filePathField.setBounds(x2, y2, 280, 30);
    }

    /**
     * Gets the open button.
     * @return the open button
     */
    public Rectangle getChooserButton() {
        return openButton.getBounds();
    }

    /**
     * Gets the file path field.
     * @return the file path field
     */
    public Rectangle getChooserField() {
        return filePathField.getBounds();
    }

    /**
     * Creates a chooser for a file or folder.
     * @param x1 the x-coordinate of the open button
     * @param y1 the y-coordinate of the open button
     * @param x2 the x-coordinate of the file path field
     * @param y2 the y-coordinate of the file path field
     * @param text the text of the open button
     */
    public void createChooser(int x1, int y1, int x2, int y2, String text) {
        // Initialize the open button
        openButton = new JButton(text);
        openButton.setBounds(x1, y1, 150, 30);

        // Initialize the text field to display file path
        filePathField = new JTextField();
        filePathField.setBounds(x2, y2, 280, 30);
        filePathField.setEditable(false); // Make it non-editable

        // Add an action listener to the open button
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the file chooser
                JFileChooser fileChooser = new JFileChooser(lastDirectory);
                if (!isFile) {
                    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                }
                int result = fileChooser.showOpenDialog(frame);

                // If the user selects a file
                if (result == JFileChooser.APPROVE_OPTION) {
                    // Get the file's path
                    filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    // Set the file path to the text field
                    filePathField.setText(filePath);
                    if (usePdfChecker) {
                        pdfChecker();
                    }
                    lastDirectory = fileChooser.getSelectedFile().getParent();
                }
            }
        });

        // Add components to the frame
        frame.add(openButton);
        frame.add(filePathField);
    }

    // Method to get the file path attribute

    /**
     * Gets the file path attribute.
     * @return the file path attribute
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the visibility of the chooser.
     * @param input a boolean to determine if the chooser is visible
     */
    public void setVisibility(boolean input) {
        if (input) {
            openButton.setVisible(true);
            filePathField.setVisible(true);
        } else {
            openButton.setVisible(false);
            filePathField.setVisible(false);
        }
    }

    /**
     * Changes the colors of the fields.
     * @param input a boolean to determine if the colors should be changed
     */
    public void changeColors(boolean input) {
        if (input) {
            openButton.setForeground(Color.RED);
            filePathField.setBackground(Color.RED);
        } else {
            openButton.setForeground(Color.BLACK);
            filePathField.setBackground(Color.WHITE);
        }
    }

    /**
     * Checks the type of the file.
     */
    public void pdfChecker() {
        if (!filePath.substring(filePath.length() - 3).equals("pdf")) {
            changeColors(true);
            wrong.setVisible(true);
            warning.setVisible(false);
            finish.setVisible(false);
            wrongWarning.setVisible(false);
            filled = false;
        } else {
            changeColors(false);
            wrong.setVisible(false);
            filled = true;
        }
    }
}
