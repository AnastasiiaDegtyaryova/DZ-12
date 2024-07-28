package org.example;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PersonTest {

    private Person person;

    @BeforeMethod
    public void setUp() {
        person = new Person("John", "Doe", 30, 50000);
    }

    @Test
    public void testGetFirstName() {
        Assert.assertEquals(person.getFirstName(), "John", "Expected first name to be 'John'");
    }

    @Test
    public void testSetFirstName() {
        person.setFirstName("Jane");
        Assert.assertEquals(person.getFirstName(), "Jane", "Expected first name to be 'Jane'");
    }

    @Test
    public void testGetLastName() {
        Assert.assertEquals(person.getLastName(), "Doe", "Expected last name to be 'Doe'");
    }

    @Test
    public void testSetLastName() {
        person.setLastName("Smith");
        Assert.assertEquals(person.getLastName(), "Smith", "Expected last name to be 'Smith'");
    }

    @Test
    public void testGetAge() {
        Assert.assertEquals(person.getAge(), 30, "Expected age to be 30");
    }

    @Test
    public void testSetAge() {
        person.setAge(35);
        Assert.assertEquals(person.getAge(), 35, "Expected age to be 35");
    }

    @Test
    public void testGetPartner() {
        Person partner = new Person("Jane", "Doe", 28, 40000);
        person.setPartner(partner);
        Assert.assertEquals(person.getPartner(), partner, "Expected partner to be set correctly");
    }

    @Test
    public void testSetPartner() {
        Person partner = new Person("Jane", "Doe", 28, 40000);
        person.setPartner(partner);
        Assert.assertEquals(person.getPartner(), partner, "Expected partner to be set correctly");
    }

    @Test
    public void testGetPossessions() {
        Assert.assertEquals(person.getPossessions(), 50000.0, "Expected possessions to be 50000");
    }

    @Test
    public void testSetPossessions() {
        person.setPossessions(60000);
        Assert.assertEquals(person.getPossessions(), 60000.0, "Expected possessions to be 60000");
    }
}


