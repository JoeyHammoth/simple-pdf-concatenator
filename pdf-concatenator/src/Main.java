import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDPageTree;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import java.io.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton concatButton = new JButton("Concatenate");
        JButton revButton = new JButton("Reverse");
        JButton mergeButton = new JButton("Even/Odd Merge");
        JLabel text = new JLabel("Select a PDF action.");
        concatButton.setBounds(150, 200, 220, 50);
        revButton.setBounds(150, 150, 220, 50);
        mergeButton.setBounds(150, 100, 220, 50);
        text.setBounds(150, 50, 220, 50);
        frame.add(concatButton);
        frame.add(revButton);
        frame.add(mergeButton);
        frame.add(text);
        frame.setSize(500, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}