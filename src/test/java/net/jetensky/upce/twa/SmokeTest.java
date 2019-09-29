package net.jetensky.upce.twa;

import org.junit.Test;
import org.openqa.selenium.By;


public class SmokeTest extends AbstractUITest{

    @Test()
    public void googleHello() {
        driver.get("http://www.google.com");
        driver.write(By.name("q"), "Univerzita Pardubice");
        driver.findElement(By.name("btnK")).click();
        driver.findElementByXpath("//div[text()='Univerzita Pardubice – Wikipedie']");
    }


}
