import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Concat {
    private String inputPdf1;
    private String inputPdf2;
    private String outputPdf;
    public Concat(String inputPdf1, String inputPdf2, String outputPdf) {
        this.inputPdf1 = inputPdf1;
        this.inputPdf2 = inputPdf2;
        this.outputPdf = outputPdf;
    }
    public void concatenate() throws FileNotFoundException {
        PDFMergerUtility pdfMerger = new PDFMergerUtility();
        pdfMerger.addSource(new File(inputPdf1));
        pdfMerger.addSource(new File(inputPdf2));
        pdfMerger.setDestinationFileName(outputPdf);

        try {
            // Merge the PDFs
            pdfMerger.mergeDocuments(null);
            System.out.println("PDF files merged successfully!");
        } catch (IOException e) {
            System.err.println("Error occurred while merging PDFs: " + e.getMessage());
        }
    }
}
