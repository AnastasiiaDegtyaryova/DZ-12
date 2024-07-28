package org.example;


import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class ManTest {

    private static final Logger logger = LogManager.getLogger(ManTest.class);


    @DataProvider(name = "retirementData")
    public Object[][] retirementData() {
        logger.info("Set up Man objects for testing");
        return new Object[][]{
                {new Man("John", "Doe", 70, 100000), true},
                {new Man("Paul", "Smith", 60, 50000), false}
        };
    }

    @Test(dataProvider = "retirementData")
    @Description("This test attempts to log into the website using a login and a password. Fails if any error happens.\n\nNote that this test does not test 2-Factor Authentication.")
    @Severity(CRITICAL)
    @Owner("John Doe")
    @Link(name = "Website", url = "https://dev.example.com/")
    @Issue("AUTH-123")
    @TmsLink("TMS-456")
    public void testIsRetired(Man man, boolean expected) {
        logger.info("Testing man is retired started");
        Assert.assertEquals(man.isRetired(), expected, "Retirement status does not match");
        logger.info("Testing man is retired finished");
    }

    @DataProvider(name = "partnershipData")
    public Object[][] partnershipData() {
        return new Object[][]{
                {new Man("John", "Doe", 50, 100000), new Woman("Jane", "Doe", 65, 80000)}
        };

    }

    @Test(dataProvider = "partnershipData")
    public void testRegisterPartnership(Man man, Woman woman) {
        logger.info("Testing register partnership started");
        man.registerPartnership(woman);
        Assert.assertEquals(man.getPartner(), woman, "Partner should be set correctly");
        Assert.assertEquals(woman.getLastName(), "Doe", "Last name should be set to man's last name");
        Assert.assertEquals(woman.getPartner(), man, "Partner reference in woman should point to man");
        logger.info("Testing register partnership finished");
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
        logger.info("Testing divide possessions started");
        man.registerPartnership(woman);
        man.dividePossessions();
        Assert.assertEquals(man.getPossessions(), 90000.0, "Man's possessions should be divided correctly");
        Assert.assertEquals(woman.getPossessions(), 90000.0, "Woman's possessions should be divided correctly");
        logger.info("Testing divide possessions finished");
    }

}
