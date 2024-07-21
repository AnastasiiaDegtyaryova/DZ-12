package org.example;

public class Main {
    public static void main(String[] args) {
        Man man = new Man("John", "White", 68, 100000);
        Woman woman = new Woman("Ann", "Black", 58, 90000);

        System.out.println("John is retired: " + man.isRetired());
        System.out.println("Ann is retired: " + woman.isRetired());

        man.registerPartnership(woman);
        System.out.println("Ann's last name after partnership: " + woman.getLastName());

        man.dividePossessions();
        System.out.println("John's possessions after divorce: " + man.getPossessions());
        System.out.println("Ann's possessions after divorce: " + woman.getPossessions());

        man.deregisterPartnership(true);
        System.out.println("Ann's last name after divorce: " + woman.getLastName());
    }
}
