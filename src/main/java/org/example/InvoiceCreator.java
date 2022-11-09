package org.example;

import java.util.Calendar;
import java.util.HashMap;

// Cel klasy: generowanie faktur
public class InvoiceCreator {
    final private IPdfCreator pdfCreator;
    private Invoice invoice;
    InvoiceCreator(IPdfCreator pdfCreator) {
        this.pdfCreator = pdfCreator;
    }

    void create(Invoice invoice) {
        this.invoice = invoice;

        pdfCreator.addTextLine(new String[]{invoice.getIdentifier()}, new boolean[]{true}, true);
        pdfCreator.addEmptyLines(1);
        pdfCreator.addTextLine(new String[]{"Date of issue:", getCurrentDate()}, new boolean[]{true, false}, true);
        pdfCreator.addEmptyLines(2);
        pdfCreator.addTextLine(new String[]{"Company:", "Customer:"}, new boolean[]{true, true}, true);
        pdfCreator.addTextLine(new String[]{invoice.getCompanyName(), invoice.getCustomerName()}, new boolean[]{false, false}, true);
        pdfCreator.addTextLine(new String[]{invoice.getCompanyAddress(), invoice.getCustomerAddress()}, new boolean[]{false, false}, true);
        pdfCreator.addTextLine(new String[]{invoice.getCompanyZipCode(), invoice.getCustomerZipCode()}, new boolean[]{false, false}, true);
        pdfCreator.addTextLine(new String[]{invoice.getCompanyNIP(), invoice.getCustomerID()}, new boolean[]{false, false}, true);
        pdfCreator.addTextLine(new String[]{invoice.getCompanyEmail(), invoice.getCustomerEmail()}, new boolean[]{false, false}, true);
        pdfCreator.addEmptyLines(2);
        pdfCreator.addTextLine(new String[]{"No.", "Product Name", "Product Price", "Amount", "Net", "VAT(" + String.format("%.2f", invoice.getVatPercentage() * 100.0) + "%)", "Gross"}, new boolean[]{true, true, true, true, true, true, true}, false);

        int iter = 1;
        for(HashMap<String, String> part: invoice.getProducts()) {
            pdfCreator.addTextLine(new String[]{Integer.toString(iter), part.get("name"), part.get("price"), part.get("amount"), part.get("net"), part.get("vat"), part.get("gross")}, new boolean[]{true, false, false, false, false, false, false}, false);
            iter++;
        }

        pdfCreator.addEmptyLines(2);
        pdfCreator.addTextLine(new String[]{"Total price:", String.format("%.2f", invoice.getCost())}, new boolean[]{true, false}, true);
    }

    String save() {
        return pdfCreator.save(invoice.getIdentifier());
    }

    private static String getCurrentDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH) + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return Integer.toString(day) + '.' + month + '.' + year;
    }
}
