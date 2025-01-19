package pdf.concat.function;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;

import java.io.File;
import java.io.IOException;

/**
 * This class is responsible for merging two PDFs into one.
 * The even pages of the first PDF are merged with the odd pages of the second PDF.
 * The merged PDF is saved to the output directory.
 *
  */
public class Merger {
    private String inputPdfEvenPages;
    private String inputPdfOddPages;
    private String outputPdf;

    /**
     * Constructor to initialize the input PDFs and the output PDF.
     *
     * @param inputPdfEvenPages The path to the PDF containing even pages.
     * @param inputPdfOddPages The path to the PDF containing odd pages.
     * @param outputPdf The path to save the merged PDF.
     * @param name The name of the merged PDF.
     */
    public Merger(String inputPdfEvenPages, String inputPdfOddPages, String outputPdf, String name) {
        this.inputPdfEvenPages = inputPdfEvenPages;
        this.inputPdfOddPages = inputPdfOddPages;
        this.outputPdf = outputPdf + "/" + name;
    }

    /**
     * Merges the even pages of the first PDF with the odd pages of the second PDF.
     * The merged PDF is saved to the output directory.
     */
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

    /**
     * Merges the even pages of the first PDF with the odd pages of the second PDF.
     *
     * @param evenPdfDoc The PDF containing even pages.
     * @param oddPdfDoc The PDF containing odd pages.
     * @return The merged PDF.
     */
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
