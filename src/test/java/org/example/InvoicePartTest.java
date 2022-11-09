package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InvoicePartTest {
    private InvoicePart invoicePart;

    private static String name = "Product Name";
    private static double price = 9.99;
    private static int amount = 7;

    private static double cost = 69.93;

    @Before
    public void initializeInvoicePart() { invoicePart = new InvoicePart(name, price, amount); }

    @Test
    public void testGetters() {
        assertEquals(invoicePart.getName(), name);
        assertEquals(invoicePart.getProductPrice(), price);
        assertEquals(invoicePart.getAmount(), amount);
    }

    @Test
    public void testCostCalculating() {
        assertEquals(invoicePart.getCost(), cost);
    }
}