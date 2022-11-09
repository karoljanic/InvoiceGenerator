package org.example;

import javafx.beans.binding.DoubleExpression;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DatabaseSaverTest {
    private Company company;
    private Customer customer;
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

    private static String[] productNames = new String[]{"Product 1 Name", "Product 2 Name", "Product 3 Name"};
    private static double[] productPrices = new double[]{9.99, 19.49, 39.79};
    private static int[] productAmounts = new int[]{7, 3, 1};

    @Mock IDatabase database = mock(IDatabase.class);

    @Before
    public void initializeInvoice() {
        company = new Company(comName, comNip, comAddress, comZipCode, comEmail);
        customer = new Customer(cusForeName, cusSurname, cusId, cusAddress, cusZipCode, cusEmail);
        invoice = new Invoice(company, customer);

        for(int i = 0; i < 3; i++) {
            invoice.addProducts(productNames[i], productPrices[i], productAmounts[i]);
        }
    }

    @Test
    public void saveDataToDatabaseAnyErrors() {
        DatabaseSaver databaseSaver = new DatabaseSaver(database);

        when(database.addCompany(any(String.class), any(String.class), any(String.class), any(String.class), any(String.class))).thenReturn(true);
        when(database.addCustomer(any(String.class), any(String.class), any(String.class), any(String.class), any(String.class), any(String.class))).thenReturn(true);
        when(database.addInvoice(any(String.class), any(String.class), any(String.class), any(Double.class))).thenReturn(true);

        boolean saveCompleted = databaseSaver.save(invoice);
        assertTrue(saveCompleted);
    }

    @Test
    public void saveDataToDatabaseErrorInFirst() {
        DatabaseSaver databaseSaver = new DatabaseSaver(database);

        when(database.addCompany(any(String.class), any(String.class), any(String.class), any(String.class), any(String.class))).thenReturn(false);
        when(database.addCustomer(any(String.class), any(String.class), any(String.class), any(String.class), any(String.class), any(String.class))).thenReturn(true);
        when(database.addInvoice(any(String.class), any(String.class), any(String.class), any(Double.class))).thenReturn(true);

        boolean saveCompleted = databaseSaver.save(invoice);
        assertFalse(saveCompleted);
    }

    @Test
    public void saveDataToDatabaseErrorInSecond() {
        DatabaseSaver databaseSaver = new DatabaseSaver(database);

        when(database.addCompany(any(String.class), any(String.class), any(String.class), any(String.class), any(String.class))).thenReturn(true);
        when(database.addCustomer(any(String.class), any(String.class), any(String.class), any(String.class), any(String.class), any(String.class))).thenReturn(false);
        when(database.addInvoice(any(String.class), any(String.class), any(String.class), any(Double.class))).thenReturn(true);

        boolean saveCompleted = databaseSaver.save(invoice);
        assertFalse(saveCompleted);
    }

    @Test
    public void saveDataToDatabaseErrorInThird() {
        DatabaseSaver databaseSaver = new DatabaseSaver(database);

        when(database.addCompany(any(String.class), any(String.class), any(String.class), any(String.class), any(String.class))).thenReturn(true);
        when(database.addCustomer(any(String.class), any(String.class), any(String.class), any(String.class), any(String.class), any(String.class))).thenReturn(false);
        when(database.addInvoice(any(String.class), any(String.class), any(String.class), any(Double.class))).thenReturn(false);

        boolean saveCompleted = databaseSaver.save(invoice);
        assertFalse(saveCompleted);
    }

    @After
    public void deletingInvoiceInstance() {
        invoice = null;
    }
}