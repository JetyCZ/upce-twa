package cz.digitalcz.stormont.system.test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverHelper {

    public static WebDriver getWebDriver() {
        // WebDriverManager instance = WebDriverManager.getInstance(ChromeDriver.class);
        WebDriverManager instance = WebDriverManager.getInstance(OperaDriver.class);
        instance.setup();
        return new OperaDriver();

    }
}
