package net.jetensky.upce.twa;// Generated by Selenium IDE
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
public class PCEPRAHATest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;

  @Before
  public void setUp() {
    WebDriverManager instance = WebDriverManager.getInstance(OperaDriver.class);
    instance.setup();
    driver = new OperaDriver();
    vars = new HashMap<String, Object>();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @Test
  public void pCEPRAHA() {
    driver.get("https://idos.idnes.cz/vlakyautobusymhdvse/spojeni/");
      typeFromAndTo();
      driver.findElement(By.cssSelector(".btn-small")).click();
  }

    protected void typeFromAndTo() {
        driver.findElement(By.id("From")).sendKeys("Pardubice");
        driver.findElement(By.id("To")).sendKeys("Praha");
    }
}