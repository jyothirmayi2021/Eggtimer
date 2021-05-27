package com.eggtimer.stepdefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.eggtimer.webpages.HomePage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import util.DriverBase;
import util.ProjectPropertyUtil;

public class HomePageStepDefinitions {
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    private DriverBase driverBase;
    private HomePage homePage;

    public HomePageStepDefinitions(DriverBase driverBase, HomePage homePage) {
        this.driverBase = driverBase;
        this.homePage = homePage;
    }

    @Given("Navigate to eggtimer application")
    public void navigateToEggtimerApplication() throws InterruptedException {
        driverBase.webDriver.get(ProjectPropertyUtil.getValue("eggtimer.page.url"));
        driverBase.webDriver.manage().window().maximize();
        Thread.sleep(2000);
    }

    @And("Set counter to {string} {string}")
    public void setCounterTo(String counterValue, String timeUnit) {
        homePage.setCounterValue(counterValue);
        homePage.clickOnStartButton();
    }

}
