package org.karoljanic;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.karoljanic.models.*;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class InvoiceTest {
    private Company company;
    private Customer customer;
    private ArrayList<InvoicePart> invoiceParts;
    private Invoice invoice;

    private final static String comName = "COMPANY-NAME";
    private final static String comNip  = "5329229530";
    private final static String comAddress = "Street 1";
    private final static String comZipCode = "12-345";
    private final static String comEmail = "company@email.com";

    private final static String cusForeName = "CustomerForename";
    private final static String cusSurname = "CustomerSurname";
    private final static String cusId  = "10241426831";
    private final static String cusAddress = "Street 2";
    private final static String cusZipCode = "56-789";
    private final static String cusEmail = "customer@email.com";
    private final static String identifier = "ZH-KP-0";
    private final static float vat = 0.23F;

    private static final String[] productNames = new String[]{"Product 1 Name", "Product 2 Name", "Product 3 Name"};
    private static final float[] productPrices = new float[]{9.99F, 19.49F, 39.79F};
    private static final int[] productAmounts = new int[]{7, 3, 1};

    private static final float cost = 168.19F;

    private final DecimalFormat plnFormat = new DecimalFormat("#.00 PLN");

    @Before
    public void initializeInvoice() {
        company = new Company(comName, comNip, comAddress, comZipCode, comEmail);
        customer = new Customer(cusForeName, cusSurname, cusId, cusAddress, cusZipCode, cusEmail);
        invoiceParts = new ArrayList<>();
        for(int i = 0; i < 3; i++) {
            invoiceParts.add(new InvoicePart(new Product(productNames[i], productPrices[i]), productAmounts[i]));
        }

        invoice = new Invoice(company, customer, invoiceParts);
    }

    @Test
    public void testGetters() {
        assertEquals(invoice.getCompanyName(), comName);
        assertEquals(invoice.getCompanyAddress(), comAddress);
        assertEquals(invoice.getCompanyZipCode(), comZipCode);
        assertEquals(invoice.getCompanyEmail(), comEmail);
        assertEquals(invoice.getCompanyNIP(), "NIP: " + comNip);
        assertEquals(invoice.getCustomerName(), cusForeName + " " + cusSurname);
        assertEquals(invoice.getCustomerFirstName(), cusForeName);
        assertEquals(invoice.getCustomerSecondName(), cusSurname);
        assertEquals(invoice.getCustomerAddress(), cusAddress);
        assertEquals(invoice.getCustomerZipCode(), cusZipCode);
        assertEquals(invoice.getCustomerEmail(), cusEmail);
        assertEquals(invoice.getCustomerID(), "ID: " + cusId);
        assertEquals(invoice.getIdentifier(), identifier);
        assertEquals(0, Float.compare(invoice.getVatPercentage(), vat));
    }

    @Test
    public void testCostCalculating() {
        assertEquals(invoice.getCost(), cost);
    }

    @Test
    public void productsListGetting() {
        var result = invoice.getProducts();
        assertEquals(result.size(), 3);

        for(int i = 0; i < 3; i++) {
            assertEquals(result.get(i).get("name"), productNames[i]);
            assertEquals(result.get(i).get("price"), plnFormat.format(productPrices[i]));
            assertEquals(result.get(i).get("amount"), Integer.toString(productAmounts[i]));
            assertEquals(result.get(i).get("net"), plnFormat.format((1.0 - vat) * productAmounts[i] * productPrices[i]));
            assertEquals(result.get(i).get("vat"), plnFormat.format(vat * productAmounts[i] * productPrices[i]));
            assertEquals(result.get(i).get("gross"), plnFormat.format(productAmounts[i] * productPrices[i]));
        }
    }

    @After
    public void deletingInvoiceInstance() {
        invoice = null;
    }
}