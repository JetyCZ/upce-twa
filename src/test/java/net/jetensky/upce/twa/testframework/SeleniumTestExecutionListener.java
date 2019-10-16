package net.jetensky.upce.twa.testframework;

import org.openqa.selenium.WebDriver;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

public class SeleniumTestExecutionListener extends AbstractTestExecutionListener {
 
 @Override
 public void beforeTestMethod(TestContext testContext) throws Exception {
  testContext.getApplicationContext().getBean(TestScope.class).reset();
 }
 
}