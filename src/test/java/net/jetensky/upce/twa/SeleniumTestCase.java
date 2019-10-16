package net.jetensky.upce.twa;

import net.jetensky.upce.twa.testframework.SeleniumTestCaseContext;
import net.jetensky.upce.twa.testframework.SeleniumTestExecutionListener;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SeleniumTestCaseContext.class)
@TestExecutionListeners({ SeleniumTestExecutionListener.class,
 DependencyInjectionTestExecutionListener.class })
public abstract class SeleniumTestCase {

    @Autowired
    WebDriver webDriver;

    @After
    public void afterTestMethod() throws Exception {
        webDriver.quit();
    }
}