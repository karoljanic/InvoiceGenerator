package org.example;

public interface IDatabase {
    boolean addCompany(String identifier, String name, String address, String zipCode, String email);
    boolean addCustomer(String identifier, String firstName, String secondName, String address, String zipCode, String email);
    boolean addInvoice(String invoiceIdentifier, String companyIdentifier, String customerIdentifier, double cost);
}
