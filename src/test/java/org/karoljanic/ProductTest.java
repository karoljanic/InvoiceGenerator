package org.karoljanic;

import org.junit.Before;
import org.junit.Test;
import org.karoljanic.models.Product;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private Product product;

    private static final String name = "Product Name";
    private static final float price = 9.99F;
    private static final String text = "Product Name  9.99 PLN";

    @Before
    public void initializeProduct() { product = new Product(name, price); }

    @Test
    public void testGetters() {
        assertEquals(product.getName(), name);
        assertEquals(product.getPrice(), price);
        assertEquals(product.getText(), text);
    }
}