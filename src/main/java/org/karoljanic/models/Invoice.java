package org.karoljanic.models;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

// Cel klasy: reprezentowanie danych faktury
public class Invoice {
    private final Company company;
    private final Customer customer;
    private final ArrayList<InvoicePart> productsList;
    private final int invoiceNumber;
    private static int invoicesCounter = 0;
    private static final String INVOICE_SERIES = "ZH-KP-";
    private static final float VAT_PERCENTAGE = 0.23F;

    private final DecimalFormat plnFormat = new DecimalFormat("#.00 PLN");

    public Invoice(Company company, Customer customer, ArrayList<InvoicePart> productsList) {
        this.company = company;
        this.customer = customer;
        this.productsList = productsList;
        invoiceNumber = Invoice.invoicesCounter;

        Invoice.invoicesCounter++;
    }

    public float getCost() {
        float sum = 0.0F;
        for(InvoicePart part: productsList) {
            sum += part.getCost();
        }

        return sum;
    }

    public String getCompanyName() { return company.getName(); }
    public String getCompanyAddress() { return company.getAddress(); }
    public String getCompanyZipCode() { return company.getZipCode(); }
    public String getCompanyEmail() { return company.getEmail(); }
    public String getCompanyNIP() { return company.getIdentifier(); }

    public String getCustomerName() { return customer.getName(); }
    public String getCustomerFirstName() { return  customer.getFirstName(); }
    public String getCustomerSecondName() { return  customer.getSecondName(); }
    public String getCustomerAddress() { return customer.getAddress(); }
    public String getCustomerZipCode() { return customer.getZipCode(); }
    public String getCustomerEmail() { return customer.getEmail(); }
    public String getCustomerID() { return customer.getIdentifier(); }

    public String getIdentifier() { return Invoice.INVOICE_SERIES + invoiceNumber; }
    public float getVatPercentage() { return Invoice.VAT_PERCENTAGE; }

    public ArrayList<HashMap<String, String>> getProducts() {
        ArrayList<HashMap<String, String>> result = new ArrayList<>();

        for(InvoicePart product: productsList) {
            HashMap<String, String> productMap = new HashMap<>();
            productMap.put("name", product.getName());
            productMap.put("price", plnFormat.format(product.getProductPrice()));
            productMap.put("amount", Integer.toString(product.getAmount()));
            productMap.put("net", plnFormat.format((1.0 - VAT_PERCENTAGE) * product.getAmount() * product.getProductPrice()));
            productMap.put("vat", plnFormat.format(VAT_PERCENTAGE * product.getAmount() * product.getProductPrice()));
            productMap.put("gross", plnFormat.format(product.getAmount() * product.getProductPrice()));
            result.add(productMap);
        }

        return result;
    }
}
