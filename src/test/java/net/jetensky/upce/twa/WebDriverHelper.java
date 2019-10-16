package net.jetensky.upce.twa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverHelper {


    public static WebDriver getWebDriver() {
        WebDriver driver;
        // driver = setupRemoteWebDriver(OperaDriver.class);
        driver = setupRemoteWebDriver(ChromeDriver.class);
        //driver = setupFirefox();

        return driver;

    }

    protected static WebDriver setupFirefox() {
        WebDriver driver;
        System.setProperty("webdriver.firefox.bin", "/usr/bin/firefox54");
        WebDriverManager instance = WebDriverManager.getInstance(OperaDriver.class);
        instance.setup();
        driver = new FirefoxDriver();
        return driver;
    }

    private static RemoteWebDriver setupRemoteWebDriver(Class driverClass) {
        RemoteWebDriver driver;
        WebDriverManager instance = WebDriverManager.getInstance(driverClass);
        instance.setup();
        try {
            driver = (RemoteWebDriver) driverClass.newInstance();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return driver;
    }
}
