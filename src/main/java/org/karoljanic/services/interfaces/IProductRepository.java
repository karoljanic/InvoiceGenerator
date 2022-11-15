package org.karoljanic.services.interfaces;

import org.karoljanic.models.Product;

import java.util.List;

// Cel klasy: implementacja interface'u magazynu danych o produktach
public interface IProductRepository {
    List<Product> getAll();
    Product getByIdentifier(String productIdentifier);
    void save(Product product);
    void update(Product product);
    void delete(Product product);
}
