package org.example;

public class Person extends Entity implements EntityI {
    private final String firstName;
    private final String secondName;
    private final String id;

    Person(String firstName, String secondName, String id, String address, String zipCode, String email) {
        super(address, zipCode, email);

        this.firstName = firstName;
        this.secondName = secondName;
        this.id = id;
    }

    @Override
    public String getName() {
        return firstName + " " + secondName;
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
        return "ID: " + id;
    }
}
