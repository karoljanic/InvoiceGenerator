package org.karoljanic;

import org.karoljanic.models.Invoice;
import org.karoljanic.pdf.IPdfCreator;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import javafx.application.HostServices;


// Cel klasy: wyswietlanie faktury w formie PDF
public class InvoiceViewer {
    IPdfCreator _pdfCreator;
    HostServices hosts;

    InvoiceViewer(IPdfCreator pdfCreator, HostServices hostServices) {
        _pdfCreator = pdfCreator;
        hosts = hostServices;
    }
    public void show(Invoice invoice) {
        _pdfCreator.addTextLine(new String[]{invoice.getIdentifier()}, new boolean[]{true}, true);
        _pdfCreator.addEmptyLines(1);
        _pdfCreator.addTextLine(new String[]{"Date of issue:", getCurrentDate()}, new boolean[]{true, false}, true);
        _pdfCreator.addEmptyLines(2);
        _pdfCreator.addTextLine(new String[]{"Company:", "Customer:"}, new boolean[]{true, true}, true);
        _pdfCreator.addTextLine(new String[]{invoice.getCompanyName(), invoice.getCustomerName()}, new boolean[]{false, false}, true);
        _pdfCreator.addTextLine(new String[]{invoice.getCompanyAddress(), invoice.getCustomerAddress()}, new boolean[]{false, false}, true);
        _pdfCreator.addTextLine(new String[]{invoice.getCompanyZipCode(), invoice.getCustomerZipCode()}, new boolean[]{false, false}, true);
        _pdfCreator.addTextLine(new String[]{invoice.getCompanyNIP(), invoice.getCustomerID()}, new boolean[]{false, false}, true);
        _pdfCreator.addTextLine(new String[]{invoice.getCompanyEmail(), invoice.getCustomerEmail()}, new boolean[]{false, false}, true);
        _pdfCreator.addEmptyLines(2);
        _pdfCreator.addTextLine(new String[]{"No.", "Product Name", "Product Price", "Amount", "Net", "VAT(" + String.format("%.2f", invoice.getVatPercentage() * 100.0) + "%)", "Gross"}, new boolean[]{true, true, true, true, true, true, true}, false);

        int iter = 1;
        for(HashMap<String, String> part: invoice.getProducts()) {
            _pdfCreator.addTextLine(new String[]{Integer.toString(iter), part.get("name"), part.get("price"), part.get("amount"), part.get("net"), part.get("vat"), part.get("gross")}, new boolean[]{true, false, false, false, false, false, false}, false);
            iter++;
        }

        _pdfCreator.addEmptyLines(2);
        _pdfCreator.addTextLine(new String[]{"Total price:", String.format("%.2f", invoice.getCost())}, new boolean[]{true, false}, true);

        String resultFileName = _pdfCreator.save(invoice.getIdentifier());

        File file = new File(resultFileName);
        hosts.showDocument(file.getAbsolutePath());
    }

    private static String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return Integer.toString(day) + '.' + month + '.' + year;
    }
}
