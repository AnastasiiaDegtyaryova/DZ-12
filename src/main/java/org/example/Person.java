package org.example;

public class Person {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected Person partner;
    protected double possessions;

    public Person(String firstName, String lastName, int age, double possessions) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.possessions = possessions;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getPartner() {
        return partner;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    public double getPossessions() {
        return possessions;
    }

    public void setPossessions(double possessions) {
        this.possessions = possessions;
    }
}

