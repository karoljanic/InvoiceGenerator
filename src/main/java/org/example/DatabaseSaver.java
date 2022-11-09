package org.example;

// Cel klasy: Zapisywanie danych do bazy danych
public class DatabaseSaver {
    IDatabase database;

    DatabaseSaver(IDatabase database) {
        this.database = database;
    }

    boolean save(Invoice invoice) {
        if(!database.addCompany(invoice.getCompanyNIP(), invoice.getCompanyName(), invoice.getCompanyAddress(), invoice.getCompanyZipCode(), invoice.getCompanyEmail())) {
            return false;
        }

        if(!database.addCustomer(invoice.getCustomerID(), invoice.getCustomerFirstName(), invoice.getCustomerSecondName(), invoice.getCustomerAddress(), invoice.getCustomerZipCode(), invoice.getCustomerID())) {
            return false;
        }

        return database.addInvoice(invoice.getIdentifier(), invoice.getCompanyNIP(), invoice.getCustomerID(), invoice.getCost());
    }
}
