package org.karoljanic;

import org.junit.Before;
import org.junit.Test;
import org.karoljanic.models.Entity;

import static org.junit.jupiter.api.Assertions.*;

public class EntityTest {
    private Entity entity;

    private final static String address = "Street 1";
    private final static String zipCode = "12-345";
    private final static String email = "company@email.com";

    @Before
    public void initializeEntity() { entity = new Entity(address, zipCode, email); }

    @Test
    public void testGetters()  {
        assertEquals(entity.getAddress(), address);
        assertEquals(entity.getZipCode(), zipCode);
        assertEquals(entity.getEmail(), email);
    }

}