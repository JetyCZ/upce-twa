package cz.digitalcz.stormont.system.test.helper;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class SmartDriver {
    private WebDriver driver;

    public void get(String url) {
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public List<WebElement> findElements(By by) {
        return driver.findElements(by);
    }

    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    public String getPageSource() {
        return driver.getPageSource();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    public WebDriver.Navigation navigate() {
        return driver.navigate();
    }

    public WebDriver.Options manage() {
        return driver.manage();
    }

    public SmartDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void write(By elementBy, String value) {
        driver.findElements(elementBy).get(0).sendKeys(value);
    }

    public void click(By elementBy) {
        driver.findElements(elementBy).get(0).click();
    }

    public WebElement findElementByXpath(String xpathExpression) {
        return driver.findElements(By.xpath(xpathExpression)).get(0);
    }

    public void assertTitle(String přihlášení) {
        Assert.assertEquals(driver.getTitle(), přihlášení);
    }

}
