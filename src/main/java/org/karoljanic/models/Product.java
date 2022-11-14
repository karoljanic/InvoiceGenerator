package org.karoljanic.models;

import java.text.DecimalFormat;

// Cel klasy: reprezentowanie danych produktu
public class Product {
    private final String name;
    private final float price;

    private final DecimalFormat plnFormat = new DecimalFormat("#.00 PLN");

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
    public String getText() { return name + "  " + plnFormat.format(price); }
}
