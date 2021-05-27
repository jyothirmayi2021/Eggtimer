package com.eggtimer.stepdefinitions;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.eggtimer.webpages.CountDownPage;
import com.eggtimer.webpages.HomePage;

import io.cucumber.java.en.And;
import util.DriverBase;

public class CountDownPageStepDefinitions {
    private static final Logger logger = LogManager.getLogger(HomePage.class);
    private DriverBase driverBase;
    private CountDownPage countDownPage;


    public CountDownPageStepDefinitions(DriverBase driverBase, CountDownPage countDownPage) {
        this.driverBase = driverBase;
        this.countDownPage = countDownPage;
    }

    private String getNextSecondsValue(String seconds) {
//        if (seconds.equals("2 seconds"))
//            return "1 second";
        seconds = seconds.replaceAll("[^\\d]", "");
        seconds = seconds.trim();
        int secondsNumber = Integer.parseInt(seconds);
        secondsNumber = secondsNumber - 1;
        if (secondsNumber == 1 || secondsNumber == 0) return secondsNumber + " second";
        else seconds = secondsNumber + " seconds";
        return seconds;
    }

    @And("Get count down values")
    public void getCountDownValues() {
        driverBase.webDriverWait = new WebDriverWait(driverBase.webDriver, Duration.ofSeconds(5));
        driverBase.webDriverWait.until(ExpectedConditions.visibilityOf(countDownPage.getSecondsCountWebElement()));
        int counter=driverBase.counter;
        for (; counter != 0; counter--) {
            logger.info("counter increment value is " + counter);
            driverBase.webDriverWait.until(ExpectedConditions.textToBePresentInElement(countDownPage.getSecondsCountWebElement(), getNextSecondsValue(countDownPage.getSecondsCount())));
            logger.info("count down in seconds " + countDownPage.getSecondsCount());
        }
    }
}