import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Chooser {
    private JFrame frame;
    private JButton openButton;
    private JTextField filePathField;
    private String filePath;
    private boolean isFile;
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
                JFileChooser fileChooser = new JFileChooser();
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
                }
            }
        });

        // Add components to the frame
        frame.add(openButton);
        frame.add(filePathField);

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to get the file path attribute
    public String getFilePath() {
        return filePath;
    }
}
