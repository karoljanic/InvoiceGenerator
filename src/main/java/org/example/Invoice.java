package org.example;

import java.util.ArrayList;
import java.util.Calendar;

public class Invoice {
    private final Company company;
    private final Person customer;
    private final ArrayList<InvoicePart> productsList;
    private final int invoiceNumber;
    private static int invoicesCounter = 0;
    private final String invoiceSeries;
    private static final float vatPercentage = 0.23F;

    Invoice(Company company, Person customer, String invoiceSeries) {
        this.company = company;
        this.customer = customer;
        this.invoiceSeries = invoiceSeries;
        productsList = new ArrayList<>();
        invoiceNumber = Invoice.invoicesCounter;

        invoicesCounter++;
    }

    void addProducts(String productName, float productPrice, int productAmount) {
        productsList.add(new InvoicePart(productName, productPrice, productAmount));
    }

    float getCost() {
        float sum = 0.0F;
        for(InvoicePart part: productsList) {
            sum += part.getCost();
        }

        return sum;
    }

    static String getCurrentDate() {
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        return Integer.toString(day) + '.' + month + '.' + year;
     }

    String generatePdf() {
        final String invoiceName = "Invoice " + invoiceSeries + invoiceNumber;

        try {
            PdfCreator pdfCreator = new PdfCreator(invoiceName);

            pdfCreator.addRow(new String[]{invoiceName}, new boolean[]{true}, true);
            pdfCreator.addEmptyLines(1);
            pdfCreator.addRow(new String[]{"Date of issue:", getCurrentDate()}, new boolean[]{true, false}, true);
            pdfCreator.addEmptyLines(2);
            pdfCreator.addRow(new String[]{"Company:", "Customer:"}, new boolean[]{true, true}, true);
            pdfCreator.addRow(new String[]{company.getName(), customer.getName()}, new boolean[]{false, false}, true);
            pdfCreator.addRow(new String[]{company.getAddress(), customer.getAddress()}, new boolean[]{false, false}, true);
            pdfCreator.addRow(new String[]{company.getZipCode(), customer.getZipCode()}, new boolean[]{false, false}, true);
            pdfCreator.addRow(new String[]{company.getIdentifier(), customer.getIdentifier()}, new boolean[]{false, false}, true);
            pdfCreator.addRow(new String[]{company.getEmail(), customer.getEmail()}, new boolean[]{false, false}, true);
            pdfCreator.addEmptyLines(2);
            pdfCreator.addRow(new String[]{"No.", "Product Name", "Product Price", "Amount", "Net", "VAT(23%)", "Gross"}, new boolean[]{true, true, true, true, true, true, true}, false);

            int iter = 1;
            for(InvoicePart part: productsList) {
                pdfCreator.addRow(new String[]{Integer.toString(iter), part.getName(), Float.toString(round2decimal(part.getProductPrice())), Integer.toString(part.getAmount()), Float.toString(round2decimal(part.getCost())), Float.toString(round2decimal(Invoice.vatPercentage * part.getCost())), Float.toString(round2decimal((1.0F + Invoice.vatPercentage) * part.getCost()))}, new boolean[]{true, false, false, false, false, false, false}, false);
                iter++;
            }

            pdfCreator.addEmptyLines(2);
            pdfCreator.addRow(new String[]{"Total price:", Float.toString(round2decimal(getCost()))}, new boolean[]{true, false}, true);

            pdfCreator.saveAndClose();
        }
        catch (Exception ignored) { }

        return invoiceName + ".pdf";
    }

    private float round2decimal(float value) {
        return Math.round(value * 100.0F) / 100.0F;
    }
}
