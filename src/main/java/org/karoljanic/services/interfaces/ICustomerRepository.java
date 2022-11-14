package org.karoljanic.services.interfaces;

import org.karoljanic.models.Customer;

import java.util.List;

// Cel klasy: implementacja interface'u magazynu danych o klientach
public interface ICustomerRepository {
    List<Customer> getAll();
    Customer getByIdentifier(String customerIdentifier);
    void save(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
}
