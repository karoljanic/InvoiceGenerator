package org.example;

public class Person extends Entity {
    private final String firstName;
    private final String secondName;
    private final String id;

    Person(String firstName, String secondName, String id, String address, String zipCode, String email) {
        super(address, zipCode, email);

        this.firstName = firstName;
        this.secondName = secondName;
        this.id = id;
    }

    public String getName() {
        return firstName + " " + secondName;
    }

    public String getIdentifier() {
        return "ID: " + id;
    }
}
