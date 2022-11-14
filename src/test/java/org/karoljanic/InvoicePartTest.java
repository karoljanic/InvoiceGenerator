package org.karoljanic;

import org.junit.Before;
import org.junit.Test;
import org.karoljanic.models.InvoicePart;
import org.karoljanic.models.Product;

import static org.junit.jupiter.api.Assertions.*;

public class InvoicePartTest {
    private InvoicePart invoicePart;

    private static final String name = "Product Name";
    private static final float price = 9.99F;
    private static final int amount = 7;

    private static final String text = "Product Name  9.99 PLN  7";

    private static final float cost = 69.93F;

    @Before
    public void initializeInvoicePart() { invoicePart = new InvoicePart(new Product(name, price), amount); }

    @Test
    public void testGetters() {
        assertEquals(invoicePart.getName(), name);
        assertEquals(invoicePart.getProductPrice(), price);
        assertEquals(invoicePart.getAmount(), amount);
        assertEquals(invoicePart.getText(), text);
    }

    @Test
    public void testCostCalculating() {
        assertEquals(invoicePart.getCost(), cost);
    }
}