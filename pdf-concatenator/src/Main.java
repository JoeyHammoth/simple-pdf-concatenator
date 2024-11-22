import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDPageTree;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        String inputPdfEvenPages = "./PDFs/even.pdf"; // Even pages PDF
        String inputPdfOddPages = "./PDFs/odd.pdf"; // Odd pages PDF
        String outputPdf = "./Output/output.pdf"; // Output merged PDF

        try {
            // Load the even-pages PDF
            PDDocument evenPdfDoc = PDDocument.load(new File(inputPdfEvenPages));
            // Load the odd-pages PDF
            PDDocument oddPdfDoc = PDDocument.load(new File(inputPdfOddPages));

            // Create a new PDF document to merge pages into
            PDDocument mergedPdfDoc = new PDDocument();


            PDPageTree evenPages = evenPdfDoc.getPages();
            int evenPageCount = evenPages.getCount();

            PDPageTree oddPages = oddPdfDoc.getPages();
            int oddPageCount = oddPages.getCount();

            int totalPageCount = evenPageCount + oddPageCount;
            int oddPageCounter = 0;
            int evenPageCounter = 0;
            for (int i = 1; i <= totalPageCount; i++) {
                if (i % 2 == 0) {
                    PDPage page = evenPages.get(evenPageCounter);
                    mergedPdfDoc.addPage(page);
                    evenPageCounter++;
                } else {
                    PDPage page = oddPages.get(oddPageCounter);
                    mergedPdfDoc.addPage(page);
                    oddPageCounter++;
                }
            }

            // Save the merged document
            mergedPdfDoc.save(outputPdf);
            mergedPdfDoc.close();
            evenPdfDoc.close();
            oddPdfDoc.close();

            System.out.println("PDFs merged successfully!");

        } catch (IOException e) {
            System.err.println("Error occurred while merging PDFs: " + e.getMessage());
        }
    }
}