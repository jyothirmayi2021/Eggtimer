package com.eggtimer.webpages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.DriverBase;

public class HomePage {

private static final Logger logger = LogManager.getLogger(HomePage.class);
     private DriverBase driverBase;
    //Constructor
    public HomePage(DriverBase driverBase){
        this.driverBase=driverBase;
        PageFactory.initElements(driverBase.webDriver, this);    }

    @FindBy(id="EggTimer-start-time-input-text")
    WebElement counter;

    @FindBy(xpath = "//button[text()='Start']")
    WebElement startButton;

    public String getCounterValue(){
        return counter.getText();
    }
    public void setCounterValue(String seconds){
        counter.sendKeys(seconds);
    }
    public void clickOnStartButton(){
        startButton.click();
    }

}
