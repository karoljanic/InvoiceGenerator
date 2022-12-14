package org.karoljanic;

import org.junit.Before;
import org.junit.Test;
import org.karoljanic.models.Customer;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    private Customer customer;
    private final static String foreName = "CustomerForename";
    private final static String surname = "CustomerSurname";
    private final static String id  = "10241426831";
    private final static String address = "Street 1";
    private final static String zipCode = "12-345";
    private final static String email = "customer@email.com";

    private final static String text = "CustomerForename CustomerSurname\nID: 10241426831\nStreet 1\n12-345\ncustomer@email.com";

    @Before
    public void initializeCustomer() { customer = new Customer(foreName,surname, id, address, zipCode, email); }

    @Test
    public void testGetters() {
        assertEquals(customer.getFirstName(), foreName);
        assertEquals(customer.getSecondName(), surname);
        assertEquals(customer.getName(), foreName + " " + surname);
        assertEquals(customer.getIdentifier(), "ID: " + id);
        assertEquals(customer.getAddress(), address);
        assertEquals(customer.getZipCode(), zipCode);
        assertEquals(customer.getEmail(), email);
        assertEquals(customer.getText(), text);
    }
}