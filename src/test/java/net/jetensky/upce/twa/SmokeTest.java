package net.jetensky.upce.twa;

import net.jetensky.upce.twa.helper.SmartDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SmokeTest extends AbstractUITest{

    @Test()
    public void googleHello() throws InterruptedException {
        driver.get("http://www.google.com");
        driver.write(By.name("q"), "Univerzita Pardubice");
        By btnK = By.name("btnK");

        ExpectedCondition<WebElement> elementCondition = d -> d.findElement(btnK);
        WebElement element = (new WebDriverWait(webDriver, 10)).until(elementCondition);

        ExpectedCondition<Boolean> displayedCondition = e -> element.isDisplayed();
        (new WebDriverWait(webDriver, 10)).until(displayedCondition);


        driver.click(btnK);
        driver.findElementByXpath("//div[text()='Univerzita Pardubice – Wikipedie']");
    }


}
