package org.karoljanic.services;

import org.karoljanic.models.Customer;
import org.karoljanic.services.interfaces.ICustomerRepository;

import java.util.List;

// Cel klasy: zarzadzanie danymi o klientach
public class CustomerService {
    private final ICustomerRepository _customerRepository;

    CustomerService(ICustomerRepository customerRepository) {
        _customerRepository = customerRepository;
    }

    public List<Customer> getAll() { return _customerRepository.getAll(); }
    public Customer getByIdentifier(String customerIdentifier) { return _customerRepository.getByIdentifier(customerIdentifier); }
    public void save(Customer customer) { _customerRepository.save(customer); }
    public void update(Customer customer) { _customerRepository.update(customer); }
    public void delete(Customer customer) { _customerRepository.delete(customer); }
}
