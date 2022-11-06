package org.example;

public class Company extends Entity implements EntityI {
    private final String name;
    private final String nip;

    Company(String name, String nip, String address, String zipCode, String email) {
        super(address, zipCode, email);

        this.name = name;
        this.nip = nip;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getContact() {
        return getEmail();
    }

    @Override
    public String getAddress() {
        return getCurrentAddress();
    }

    @Override
    public String getZipCode() {
        return getCurrentZipCode();
    }

    @Override
    public String getIdentifier() {
        return "NIP: " + nip;
    }
}
