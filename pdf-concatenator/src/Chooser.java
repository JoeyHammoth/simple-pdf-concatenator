import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Chooser {
    private JFrame frame;
    private JButton openButton;
    private JTextField filePathField;
    private String filePath;
    public Chooser(JFrame frame) {
        this.frame = frame;
    }
    public void createChooser() {
        // Initialize the open button
        openButton = new JButton("Open File");

        // Initialize the text field to display file path
        filePathField = new JTextField(30);
        filePathField.setEditable(false); // Make it non-editable

        // Add an action listener to the open button
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open the file chooser
                JFileChooser fileChooser = new JFileChooser();
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
