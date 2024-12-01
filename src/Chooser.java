import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    public boolean getFilled() {
        return filled;
    }
    public Chooser(JFrame frame, boolean isFile, JLabel warning, JLabel finish, JLabel wrong, JLabel wrongWarning) {
        this.frame = frame;
        this.isFile = isFile;
        this.warning = warning;
        this.finish = finish;
        this.wrong = wrong;
        this.wrongWarning = wrongWarning;
        this.usePdfChecker = true;
    }
    public Chooser(JFrame frame, boolean isFile) {
        this.frame = frame;
        this.isFile = isFile;
    }
    public void modifyChooser(int x1, int y1, int x2, int y2) {
        openButton.setBounds(x1, y1, 150, 30);
        filePathField.setBounds(x2, y2, 280, 30);
    }
    public Rectangle getChooserButton() {
        return openButton.getBounds();
    }
    public Rectangle getChooserField() {
        return filePathField.getBounds();
    }
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
    public String getFilePath() {
        return filePath;
    }
    public void setVisibility(boolean input) {
        if (input) {
            openButton.setVisible(true);
            filePathField.setVisible(true);
        } else {
            openButton.setVisible(false);
            filePathField.setVisible(false);
        }
    }
    public void changeColors(boolean input) {
        if (input) {
            openButton.setForeground(Color.RED);
            filePathField.setBackground(Color.RED);
        } else {
            openButton.setForeground(Color.BLACK);
            filePathField.setBackground(Color.WHITE);
        }
    }
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
