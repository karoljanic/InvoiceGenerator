package org.example;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

// Cel klasy: przejscie pomiedzy biblioteka tworzaca PDFy a interfejsem kreator PDFow
public class PdfCreatorAdapter implements IPdfCreator {
    private Document document;
    private PdfWriter writer;
    private static final Font boldFont = new Font(Font.FontFamily.HELVETICA, 10, Font.BOLD);
    private static final Font normalFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);

    PdfCreatorAdapter()  {
        try {
            document = new Document(PageSize.A4);
            writer = PdfWriter.getInstance(document, new FileOutputStream("tmp.pdf"));
            document.open();
        }
        catch (Exception ignored) { }
    }

    @Override
    public void addEmptyLines(int number) {
        try {
            PdfPTable table = new PdfPTable(1);
            PdfPCell cell = new PdfPCell(new Paragraph("   "));
            cell.setBorder(0);

            for (int i = 0; i < number; i++) {
                table.addCell(cell);
            }

            document.add(table);
        }
        catch (Exception ignored) { }
    }

    @Override
    public void addTextLine(String[] texts, boolean[] bolds, boolean disableBorder) {
        try {
            int n = texts.length;
            PdfPTable table = new PdfPTable(n);
            for (int i = 0; i < n; i++) {
                PdfPCell cell = new PdfPCell(
                        new Paragraph(texts[i], bolds[i] ? PdfCreatorAdapter.boldFont : PdfCreatorAdapter.normalFont));
                cell.setBorder(disableBorder ? 0 : 15);
                table.addCell(cell);
            }

            document.add(table);
        }
        catch (Exception ignored) { }
    }

    @Override
    public String save(String fileName) {
        document.close();
        writer.close();

        String resultFileName = fileName + ".pdf";
        File oldNameFile = new File("tmp.pdf");
        File newNameFiles = new File(resultFileName);
        oldNameFile.renameTo(newNameFiles);

        return resultFileName;
    }
}
