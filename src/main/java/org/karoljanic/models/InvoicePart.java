package org.karoljanic.models;

// Cel klasy: reprezentwowanie danych czesci faktury
public class InvoicePart {
    private final Product product;
    private final int amount;

    public InvoicePart(Product product, int productAmount) {
        this.product = product;
        amount = productAmount;
    }

    public String getName() { return product.getName(); }

    public int getAmount() { return amount; }

    public float getProductPrice() {
        return product.getPrice();
    }

    public float getCost() {
        return amount * product.getPrice();
    }

    public String getText() { return product.getText() + "  " + amount; }
}
