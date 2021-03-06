package com.eggtimer.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.DriverBase;

public class CountDownPage {

    private DriverBase driverBase;

    //Constructor
    public CountDownPage(DriverBase driverBase) {
        this.driverBase = driverBase;
        PageFactory.initElements(driverBase.webDriver, this);
    }

    @FindBy(xpath = "//p[@class='ClassicTimer-time']//child::span[1]")
    WebElement secondsCount;

    public String getSecondsCount() {
        return secondsCount.getText();
    }

    public WebElement getSecondsCountWebElement() {
        return secondsCount;
    }

}
