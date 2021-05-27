package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;

public class DriverBase {
    public WebDriver webDriver;
    public WebDriverWait webDriverWait;
    private static boolean initialized = false;
    public int counter;

    @Before
    public void setUp() {
        if (!initialized) {
            // initialize the driver
            System.setProperty("webdriver.chrome.driver", ProjectPropertyUtil.getValue("chromedriver.path"));
            webDriver = new ChromeDriver();
            initialized = true;
        }
    }

    public WebDriver getDriver() {
        return webDriver;
    }
}
