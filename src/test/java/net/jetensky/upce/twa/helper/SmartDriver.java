package net.jetensky.upce.twa.helper;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void clickElement(By elementBy, boolean waitForPageToLoad) {
        WebDriver driverToUse = this.driver;
        clickElement(elementBy, driverToUse, waitForPageToLoad);
    }
    public static void clickElement(WebElement element, WebDriver driverToUse, boolean waitForPageToLoad) {
        // Sometimes, this causes following exception:
        //  Element is not clickable at point (507, 25.783340454101562). Other element would receive the click: <div class="navbar-header"></div>
        //  element.click();
        // So using javascript click instead

        ((JavascriptExecutor) driverToUse).executeScript("arguments[0].click();", element);

        if (waitForPageToLoad) {
            WebElement finalElement = element;
            waitUntil(input -> {
                try {
                    finalElement.findElement(By.id("does_not_matter"));
                    return false;
                } catch (StaleElementReferenceException e) {
                    return true;
                } catch (NoSuchElementException e) {
                    return false;
                }
            }, 20, driverToUse);
        }
    }

    public void waitUntil(ExpectedCondition<Boolean> conditionToMeet) {
        WebDriver driverToUse = this.driver;
        waitUntil(conditionToMeet, 10, driverToUse);
    }

    public void waitUntil(ExpectedCondition<Boolean> conditionToMeet, int timeOutInSeconds) {
        (new WebDriverWait(this.driver, timeOutInSeconds)).until(conditionToMeet);
    }

    protected static void waitUntil(ExpectedCondition<Boolean> conditionToMeet, int timeOutInSeconds, WebDriver driver) {
        (new WebDriverWait(driver, timeOutInSeconds)).until(conditionToMeet);
    }

    public static void clickElement(By elementBy, WebDriver driverToUse, boolean waitForPageToLoad) {
        // For Send Request link, if we do not scroll page first to this button, first click does nothing only scrolls,
        // second works, so to avoid double clicking, we need to scroll to button first here
        WebElement element = scrollToElement(elementBy, driverToUse);

        clickElement(element, driverToUse, waitForPageToLoad);
    }

    public static WebElement scrollToElement(By elementBy, WebDriver driverToUse) {
        WebElement webElement = waitForElement(elementBy, driverToUse);
        ((JavascriptExecutor) driverToUse).executeScript("arguments[0].scrollIntoView(true);", webElement);
        return webElement;
    }

    protected static WebElement waitForElement(final By by, WebDriver driverToUse) {
        return waitForElement(by, 10, driverToUse);
    }

    protected static WebElement waitForElement(By by, int timeoutInSeconds, WebDriver driverToUse) {
        int attemptsRemaining = 10;
        try {
            WebElement element = waitForElementPresenceOnPage(by, timeoutInSeconds, driverToUse);

            ExpectedCondition<Boolean> displayedCondition = e -> element.isDisplayed();
            (new WebDriverWait(driverToUse, timeoutInSeconds)).until(displayedCondition);

            return element;
        } catch (UnreachableBrowserException e) {
            if (attemptsRemaining>0) {
                attemptsRemaining--;
                return waitForElement(by, timeoutInSeconds, driverToUse);
            } else {
                throw new IllegalStateException("Cannot finish wait element because of " + e.getClass() + " occured too many times", e);
            }
        }

    }


    /**
     * Waits until element appears in the page DOM (no matter if it is displayed or not)
     */
    public WebElement waitForElementPresenceOnPage(By by, int timeoutInSeconds) {
        return waitForElementPresenceOnPage(by, timeoutInSeconds, driver);
    }
    public static WebElement waitForElementPresenceOnPage(By by, int timeoutInSeconds, WebDriver driverToUse) {
        ExpectedCondition<WebElement> elementCondition = d -> d.findElement(by);
        return (new WebDriverWait(driverToUse, timeoutInSeconds)).until(elementCondition);
    }


}
