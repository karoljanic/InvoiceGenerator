package org.karoljanic.services.repositories;

import org.karoljanic.models.Customer;
import org.karoljanic.services.interfaces.ICustomerRepository;

import java.util.List;

// Cel klasy: implementacja magazynu danych o klientach
public class CustomerRepository implements ICustomerRepository {
    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Customer getByIdentifier(String customerIdentifier) {
        return null;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void update(Customer customer) {

    }

    @Override
    public void delete(Customer customer) {

    }
}
