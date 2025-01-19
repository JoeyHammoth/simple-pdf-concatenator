package pdf.concat.function;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * MultiConcat class is used to concatenate multiple PDF files into a single PDF file.
 * The input is a list of PDF files and the output is a single PDF file.
 */
public class MultiConcat {
    private List<String> inputList;
    private String outputPdf;
    public MultiConcat(List<String> list, String outputPdf, String name) {
        this.inputList = list;
        this.outputPdf = outputPdf + "/" + name + ".pdf";
    }

    /**
     * Concatenate the PDF files.
     *
     * @throws FileNotFoundException if the file is not found
     *
     */
    public void concatenate() throws FileNotFoundException {
        PDFMergerUtility pdfMerger = new PDFMergerUtility();
        for (String file : inputList) {
            pdfMerger.addSource(new File(file));
        }
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
