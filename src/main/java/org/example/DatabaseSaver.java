package org.example;

public class DatabaseSaver {
    IDatabase database;

    DatabaseSaver(IDatabase database) {
        this.database = database;
    }

    void save(Invoice invoice) {
        database.addCompany(invoice.getCompanyNIP(), invoice.getCompanyName(), invoice.getCompanyAddress(), invoice.getCompanyZipCode(), invoice.getCompanyEmail());
        database.addCustomer(invoice.getCustomerID(), invoice.getCustomerFirstName(), invoice.getCustomerSecondName(), invoice.getCustomerAddress(), invoice.getCustomerZipCode(), invoice.getCustomerID());
        database.addInvoice(invoice.getIdentifier(), invoice.getCompanyNIP(), invoice.getCustomerID(), invoice.getCost());
    }
}
