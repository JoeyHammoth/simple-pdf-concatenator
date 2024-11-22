import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        String inputPdf = "./PDFs/test.pdf";  // Path to the input PDF
        String outputPdf = "./Output/output.pdf"; // Path to the reversed PDF

        try (PDDocument document = PDDocument.load(new File(inputPdf))) {
            System.out.println("PDF loaded successfully!");

            // Step 1: Convert PDPageTree to a List<PDPage>
            List<PDPage> pageList = new ArrayList<>();
            for (PDPage page : document.getPages()) {
                pageList.add(page);
            }

            // Step 2: Create a new document and add pages in reverse order
            PDDocument reversedDocument = new PDDocument();
            for (int i = pageList.size() - 1; i >= 0; i--) {
                reversedDocument.addPage(pageList.get(i));
            }

            // Step 3: Save the reversed PDF
            reversedDocument.save(outputPdf);
            reversedDocument.close();

            System.out.println("Reversed PDF saved successfully at: " + outputPdf);
        } catch (IOException e) {
            System.err.println("Error occurred while reversing PDF pages: " + e.getMessage());
        }
    }
}