package org.example;

// Cel klasy: reprezentowanie danych klienta
public class Customer extends Entity {
    private final String firstName;
    private final String secondName;
    private final String id;

    Customer(String firstName, String secondName, String id, String address, String zipCode, String email) {
        super(address, zipCode, email);

        this.firstName = firstName;
        this.secondName = secondName;
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getName() {
        return firstName + " " + secondName;
    }

    public String getIdentifier() {
        return "ID: " + id;
    }
}
