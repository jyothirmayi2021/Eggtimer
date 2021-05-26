package com.eggtimer.stepdefinitions;

import java.time.Duration;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
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
        seconds = seconds.replaceAll("[^\\d]", "");
        seconds = seconds.trim();
        int secondsNumber = Integer.parseInt(seconds);
        secondsNumber = secondsNumber - 1;
        seconds = secondsNumber + " seconds";
        if(seconds.equals("1 seconds"))
            return "59 seconds";
        return seconds;
    }

    @And("Get count down values")
    public void getCountDownValues() throws InterruptedException {
        driverBase.webDriverWait = new WebDriverWait(driverBase.webDriver, Duration.ofSeconds(5));
        driverBase.webDriverWait.until(ExpectedConditions.visibilityOf(countDownPage.getSecondsCountWebElement()));
//        String previousSecondsValue = countDownPage.getSecondsCount();
//        String previousMinuteValue = countDownPage.getMinuteCount();
//        logger.info("***********************  " + countDownPage.getMinuteCount() + "*******" + countDownPage.getSecondsCount());
        int counter = 1;
        while (counter <= 100) {
            if(countDownPage.getMinuteCount().equals("1 minute") && countDownPage.getSecondsCount().equals("2 seconds")){
                counter=counter+2;
                driverBase.webDriverWait.until(ExpectedConditions.textToBePresentInElement(countDownPage.getMinuteCountWebElement(),getNextSecondsValue(countDownPage.getMinuteCount())));
                    }
            else {
                driverBase.webDriverWait.until(ExpectedConditions.textToBePresentInElement(countDownPage.getSecondsCountWebElement(), getNextSecondsValue(countDownPage.getSecondsCount())));
                logger.info("***********************  " + countDownPage.getMinuteCount() + "*******" + countDownPage.getSecondsCount());
            }
            counter++;
            System.out.println("*************"+counter);
        }

    }
}