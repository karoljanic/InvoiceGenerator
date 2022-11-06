package org.example;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class PdfCreator {
    final private Document document;
    final private OutputStream outputStream;
    private static final Font boldFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    private static final Font normalFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

    PdfCreator(String fileName) throws Exception {
        document = new Document(PageSize.A4);
        outputStream = new FileOutputStream(fileName + ".pdf");
        PdfWriter.getInstance(document, outputStream);
        document.open();
    }

    void addEmptyLines(int number) throws Exception {
        PdfPTable table = new PdfPTable(1);
        PdfPCell cell = new PdfPCell(new Paragraph("   "));
        cell.setBorder(0);

        for(int i = 0; i < number; i++) {
            table.addCell(cell);
        }

        document.add(table);
    }

    void addRow(String[] texts, boolean[] bolds, boolean disableBorder) throws Exception {
        if(texts.length != bolds.length) { throw new Exception("Given arrays must have equal lengths!"); }

        int n = texts.length;
        PdfPTable table = new PdfPTable(n);
        for(int i = 0; i < n; i++) {
            PdfPCell cell = new PdfPCell(
                    new Paragraph(texts[i], bolds[i] ? PdfCreator.boldFont : PdfCreator.normalFont));
            cell.setBorder(disableBorder ? 0 : 15);
            table.addCell(cell);
        }

        document.add(table);
    }

    void saveAndClose() throws Exception {
        document.close();
        outputStream.close();
    }

}
