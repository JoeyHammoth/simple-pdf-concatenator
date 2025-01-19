package pdf.concat.function;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * MultiReverser class is used to reverse the pages of multiple PDFs and save them in a new directory.
 * The output PDFs are named as per the input PDFs with an index appended to the name.
 */
public class MultiReverser {
    private String outputPdf;
    private String name;
    private List<String> pdfList;
    public MultiReverser(List<String> list, String outputPdf, String name) {
        this.pdfList = list;
        this.outputPdf = outputPdf + "/";
        this.name = name;
    }

    /**
     * Reverse the pages of multiple PDFs and save them in a new directory.
     * The output PDFs are named as per the input PDFs with an index appended to the name.
     *
     */
    public void reverse() {
        for (int i = 0; i < pdfList.size(); i++) {
            String outputPdfLoop = outputPdf + name + i + ".pdf";
            try (PDDocument document = PDDocument.load(new File(pdfList.get(i)))) {
                System.out.println("PDF loaded successfully!");

                // Step 1: Convert PDPageTree to a List<PDPage>
                List<PDPage> pageList = new ArrayList<>();
                for (PDPage page : document.getPages()) {
                    pageList.add(page);
                }

                // Step 2: Create a new document and add pages in reverse order
                PDDocument reversedDocument = new PDDocument();
                for (int j = pageList.size() - 1; j >= 0; j--) {
                    reversedDocument.addPage(pageList.get(j));
                }

                // Step 3: Save the reversed PDF
                reversedDocument.save(outputPdfLoop);
                reversedDocument.close();

                System.out.println("Reversed PDF saved successfully at: " + outputPdfLoop);
            } catch (IOException e) {
                System.err.println("Error occurred while reversing PDF pages: " + e.getMessage());
            }
        }
    }
}
