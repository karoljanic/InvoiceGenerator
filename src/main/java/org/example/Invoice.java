package org.example;

import java.util.ArrayList;
import java.util.HashMap;

public class Invoice {
    private final Company company;
    private final Customer customer;
    private final ArrayList<InvoicePart> productsList;
    private final int invoiceNumber;
    private static int invoicesCounter = 0;
    private static final String INVOICE_SERIES = "ZH-KP-";
    private static final double VAT_PERCENTAGE = 0.23;

    Invoice(Company company, Customer customer) {
        this.company = company;
        this.customer = customer;
        productsList = new ArrayList<>();
        invoiceNumber = Invoice.invoicesCounter;

        Invoice.invoicesCounter++;
    }

    void addProducts(String productName, double productPrice, int productAmount) {
        productsList.add(new InvoicePart(productName, productPrice, productAmount));
    }

    double getCost() {
        double sum = 0.0;
        for(InvoicePart part: productsList) {
            sum += part.getCost();
        }

        return round2decimal(sum);
    }

    String getCompanyName() { return company.getName(); }
    String getCompanyAddress() { return company.getAddress(); }
    String getCompanyZipCode() { return company.getZipCode(); }
    String getCompanyEmail() { return company.getEmail(); }
    String getCompanyNIP() { return company.getIdentifier(); }

    String getCustomerName() { return customer.getName(); }
    String getCustomerFirstName() { return  customer.getFirstName(); }
    String getCustomerSecondName() { return  customer.getSecondName(); }
    String getCustomerAddress() { return customer.getAddress(); }
    String getCustomerZipCode() { return customer.getZipCode(); }
    String getCustomerEmail() { return customer.getEmail(); }
    String getCustomerID() { return customer.getIdentifier(); }

    String getIdentifier() { return Invoice.INVOICE_SERIES + invoiceNumber; }
    double getVatPercentage() { return Invoice.VAT_PERCENTAGE; }

    ArrayList<HashMap<String, String>> getProducts() {
        ArrayList<HashMap<String, String>> result = new ArrayList<>();

        for(InvoicePart product: productsList) {
            HashMap<String, String> productMap = new HashMap<>();
            productMap.put("name", product.getName());
            productMap.put("price", String.format("%.2f", product.getProductPrice()));
            productMap.put("amount", Integer.toString(product.getAmount()));
            productMap.put("net", String.format("%.2f", (1.0 - VAT_PERCENTAGE) * product.getAmount() * product.getProductPrice()));
            productMap.put("vat", String.format("%.2f", VAT_PERCENTAGE * product.getAmount() * product.getProductPrice()));
            productMap.put("gross", String.format("%.2f", product.getAmount() * product.getProductPrice()));
            result.add(productMap);
        }

        return result;
    }

    private static double round2decimal(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
