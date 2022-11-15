package org.karoljanic.services;

import org.karoljanic.models.Product;
import org.karoljanic.services.interfaces.IProductRepository;

import java.util.List;

// Cel klasy: zarzadzanie danymi o produktach
public class ProductService {
    private final IProductRepository _productRepository;

    public ProductService(IProductRepository productRepository) {
        _productRepository = productRepository;
    }

    public List<Product> getAll() { return _productRepository.getAll(); }
    public Product getByIdentifier(String productIdentifier) { return _productRepository.getByIdentifier(productIdentifier); }
    public void save(Product product) { _productRepository.save(product); }
    public void update(Product product) { _productRepository.update(product); }
    public void delete(Product product) { _productRepository.delete(product); }
}
