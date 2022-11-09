package org.example;

// Cel klasy: reprezentwowanie czesci faktury
public class InvoicePart {
    private final Product product;
    private final int amount;

    InvoicePart(String productName, double productPrice, int productAmount) {
        product = new Product(productName, productPrice);
        amount = productAmount;
    }

    String getName() { return product.getName(); }

    int getAmount() { return amount; }

    double getProductPrice() {
        return product.getPrice();
    }

    double getCost() {
        return amount * product.getPrice();
    }
}
