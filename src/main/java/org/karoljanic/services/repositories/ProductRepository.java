package org.karoljanic.services.repositories;

import org.karoljanic.models.Product;
import org.karoljanic.services.interfaces.IProductRepository;

import java.util.List;

// Cel klasy: implementacja magazynu danych o produktach
public class ProductRepository implements IProductRepository {
    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product getByIdentifier(String productIdentifier) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
