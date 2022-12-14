package org.karoljanic;


import org.junit.Before;
import org.junit.Test;
import org.karoljanic.models.Company;

import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {
    private Company company;
    private final static String name = "COMPANY-NAME";
    private final static String nip  = "5329229530";
    private final static String address = "Street 1";
    private final static String zipCode = "12-345";
    private final static String email = "company@email.com";
    private final static String text = "COMPANY-NAME\nNIP: 5329229530\nStreet 1\n12-345\ncompany@email.com";

    @Before
    public void initializeCompany() {
        company = new Company(name, nip, address, zipCode, email);
    }

    @Test
    public void testGetters() {
        assertEquals(company.getName(), name);
        assertEquals(company.getIdentifier(), "NIP: " + nip);
        assertEquals(company.getAddress(), address);
        assertEquals(company.getZipCode(), zipCode);
        assertEquals(company.getEmail(), email);
        assertEquals(company.getText(), text);
    }
}