package org.example;

public interface IDatabase {
    void addCompany(String identifier, String name, String address, String zipCode, String email);
    void addCustomer(String identifier, String firstName, String secondName, String address, String zipCode, String email);
    void addInvoice(String invoiceIdentifier, String companyIdentifier, String customerIdentifier, double cost);
}
