package net.jetensky.upce.twa;

import net.jetensky.upce.twa.helper.SmartDriver;
import net.jetensky.upce.twa.testframework.SeleniumTestCaseContext;
import net.jetensky.upce.twa.testframework.SeleniumTestExecutionListener;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.concurrent.TimeUnit;


/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SeleniumTestCaseContext.class)
@TestExecutionListeners({ SeleniumTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class })*/
public abstract class AbstractUITest {
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
