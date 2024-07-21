package org.example;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.*;

public class WomanTest {

    @Test(dataProvider = "provideRetirementData")
    void testIsRetired(int age, boolean expectedRetirementStatus) {
        Woman woman = new Woman("FirstName", "LastName", age, 1000.0);
        assertEquals(expectedRetirementStatus, woman.isRetired());
    }

    @DataProvider
    public Object[][] provideRetirementData() {
        return new Object[][] {
                {60, false},
                {61, true},
                {65, true}
        };
    }

    @Test(dataProvider = "provideRegisterPartnershipData")
    void testRegisterPartnership(String womanLastName, String manLastName, String expectedWomanLastName) {
        Woman woman = new Woman("FirstName", womanLastName, 30, 1000.0);
        Man man = new Man("ManFirstName", manLastName, 30, 2000.0);
        woman.registerPartnership(man);

        assertEquals(man, woman.getPartner());
        assertEquals(woman, man.getPartner());
        assertEquals(expectedWomanLastName, woman.getLastName());
        assertEquals(womanLastName, woman.getMaidenName());
    }

    @DataProvider
    public Object[][] provideRegisterPartnershipData() {
        return new Object[][] {
                {"Smith", "Johnson", "Johnson"},
                {"Doe", "Brown", "Brown"}
        };
    }

    @Test(dataProvider = "provideDeregisterPartnershipData")
    void testDeregisterPartnership(String initialLastName, String maidenName, boolean revertLastName, String expectedLastName) {
        Woman woman = new Woman("FirstName", initialLastName, 30, 1000.0);
        Man man = new Man("ManFirstName", "Johnson", 30, 2000.0);
        woman.registerPartnership(man);
        woman.deregisterPartnership(revertLastName);

        assertNull(woman.getPartner());
        assertNull(man.getPartner());
        assertEquals(expectedLastName, woman.getLastName());
    }

    @DataProvider
    public Object[][] provideDeregisterPartnershipData() {
        return new Object[][] {
                {"Smith", "Smith", true, "Smith"},
                {"Doe", "Doe", false, "Johnson"}
        };
    }

    @Test(dataProvider = "provideDividePossessionsData")
    void testDividePossessions(double womanPossessions, double manPossessions, double expectedPossessions) {
        Woman woman = new Woman("FirstName", "LastName", 30, womanPossessions);
        Man man = new Man("ManFirstName", "Johnson", 30, manPossessions);
        woman.registerPartnership(man);
        woman.dividePossessions();

        assertEquals(expectedPossessions, woman.getPossessions());
        assertEquals(expectedPossessions, man.getPossessions());
    }

    @DataProvider
    public Object[][] provideDividePossessionsData() {
        return new Object[][] {
                {1000.0, 2000.0, 1500.0},
                {3000.0, 3000.0, 3000.0}
        };
    }
}
