import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDPageTree;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import java.io.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.createMenu();
    }
}