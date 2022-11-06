package org.example;

public class Entity {
    private final String address;
    private final String zipCode;
    private final String email;

    Entity(String address, String zipCode, String email) {
        this.address = address;
        this.zipCode = zipCode;
        this.email = email;
    }

    String getAddress() {
        return address;
    }

    String getZipCode() {
        return zipCode;
    }

    String getEmail() {
        return email;
    }
}
