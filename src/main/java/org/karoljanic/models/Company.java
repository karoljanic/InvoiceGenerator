package org.karoljanic.models;

// Cel klasy: reprezentowanie danych firmy
public class Company extends Entity {
    private final String name;
    private final String nip;

    public Company(String name, String nip, String address, String zipCode, String email) {
        super(address, zipCode, email);

        this.name = name;
        this.nip = nip;
    }

    public String getName() {
        return name;
    }

    public String getIdentifier() {
        return "NIP: " + nip;
    }

    public String getText() {
        return getName() + '\n' + getIdentifier() + '\n' + getAddress() + '\n' + getZipCode() + '\n' + getEmail();
    }
}
