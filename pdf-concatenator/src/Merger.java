import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;

import java.io.File;
import java.io.IOException;

public class Merger {
    private String inputPdfEvenPages;
    private String inputPdfOddPages;
    private String outputPdf;
    public Merger(String inputPdfEvenPages, String inputPdfOddPages, String outputPdf) {
        this.inputPdfEvenPages = inputPdfEvenPages;
        this.inputPdfOddPages = inputPdfOddPages;
        this.outputPdf = outputPdf;
    }
    public void merge() {
        try {
            // Load the even-pages PDF
            PDDocument evenPdfDoc = PDDocument.load(new File(inputPdfEvenPages));
            // Load the odd-pages PDF
            PDDocument oddPdfDoc = PDDocument.load(new File(inputPdfOddPages));

            // Create a new PDF document to merge pages into
            PDDocument mergedPdfDoc = getPdDocument(evenPdfDoc, oddPdfDoc);

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

    private static PDDocument getPdDocument(PDDocument evenPdfDoc, PDDocument oddPdfDoc) {
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
        return mergedPdfDoc;
    }
}
