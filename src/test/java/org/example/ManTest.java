package org.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ManTest {

    @DataProvider(name = "retirementData")
    public Object[][] retirementData() {
        return new Object[][]{
                {new Man("John", "Doe", 70, 100000), true},
                {new Man("Paul", "Smith", 60, 50000), false}
        };
    }

    @Test(dataProvider = "retirementData")
    public void testIsRetired(Man man, boolean expected) {
        Assert.assertEquals(man.isRetired(), expected, "Retirement status does not match");
    }

    @DataProvider(name = "partnershipData")
    public Object[][] partnershipData() {
        return new Object[][]{
                {new Man("John", "Doe", 70, 100000), new Woman("Jane", "Doe", 65, 80000)}
        };
    }

    @Test(dataProvider = "partnershipData")
    public void testRegisterPartnership(Man man, Woman woman) {
        man.registerPartnership(woman);
        Assert.assertEquals(man.getPartner(), woman, "Partner should be set correctly");
        Assert.assertEquals(woman.getLastName(), "Doe", "Last name should be set to man's last name");
        Assert.assertEquals(woman.getPartner(), man, "Partner reference in woman should point to man");
    }

    @Test(dataProvider = "partnershipData")
    public void testDeregisterPartnership(Man man, Woman woman) {
        man.registerPartnership(woman);
        man.deregisterPartnership(true); // Revert last name
        Assert.assertNull(man.getPartner(), "Partner should be null after deregistering partnership");
        Assert.assertEquals(woman.getLastName(), "Doe", "Last name should be reverted back to maiden name");
    }

    @Test(dataProvider = "partnershipData")
    public void testDividePossessions(Man man, Woman woman) {
        man.registerPartnership(woman);
        man.dividePossessions();
        Assert.assertEquals(man.getPossessions(), 90000.0, "Man's possessions should be divided correctly");
        Assert.assertEquals(woman.getPossessions(), 90000.0, "Woman's possessions should be divided correctly");
    }
}
