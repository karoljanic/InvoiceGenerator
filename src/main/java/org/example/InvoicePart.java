package org.example;

public class InvoicePart {
    private final Product product;
    private final int amount;

    InvoicePart(String productName, float productPrice, int productAmount) {
        product = new Product(productName, productPrice);
        amount = productAmount;
    }

    String getName() { return product.getName(); }

    int getAmount() { return amount; }

    float getProductPrice() {
        return product.getPrice();
    }

    float getCost() {
        return amount * product.getPrice();
    }
}
