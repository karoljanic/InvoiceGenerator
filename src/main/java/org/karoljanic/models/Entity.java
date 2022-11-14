package org.karoljanic.models;

// Cel klasy: reprezentowanie wspolnych danych firmy i klienta = reprezentoeanie adresu = klasa bazowa
public class Entity {
    private final String address;
    private final String zipCode;
    private final String email;

    public Entity(String address, String zipCode, String email) {
        this.address = address;
        this.zipCode = zipCode;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getEmail() {
        return email;
    }
}
