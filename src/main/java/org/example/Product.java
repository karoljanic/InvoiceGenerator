package org.example;

public class Product {
    private final String name;
    private final float price;

    Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    float getPrice() {
        return price;
    }

    String getName() {
        return name;
    }
}
