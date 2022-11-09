package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    private Product product;

    private static String name = "Product Name";
    private static double price = 9.99;

    @Before
    public void initializeProduct() { product = new Product(name, price); }

    @Test
    public void testGetters() {
        assertEquals(product.getName(), name);
        assertEquals(product.getPrice(), price);
    }
}