package net.jetensky.upce.twa;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverHelper {

    public static WebDriver getWebDriver() {
        WebDriver driver = null;

        // driver = setupChrome();
        driver = setupFirefox();

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

    protected static WebDriver setupChrome() {
        WebDriver driver;
        WebDriverManager instance = WebDriverManager.getInstance(ChromeDriver.class);
        instance.setup();
        driver = new ChromeDriver();
        return driver;
    }
}
