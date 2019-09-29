package cz.digitalcz.stormont.system.test;

import cz.digitalcz.stormont.system.test.helper.SmartDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class AbstractUITest {
    protected static WebDriver webDriver;
    protected static SmartDriver driver;


    @BeforeClass
    public static void openBrowser(){
        webDriver = WebDriverHelper.getWebDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver = new SmartDriver(webDriver);
    }

    @AfterClass
    public static void closeBrowser(){
        webDriver.quit();
    }

}
