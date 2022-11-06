package org.example;

public class Company extends Entity {
    private final String name;
    private final String nip;

    Company(String name, String nip, String address, String zipCode, String email) {
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
}
