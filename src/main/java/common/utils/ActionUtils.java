package common.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtils {

    public static void pressKey(WebDriver driver, Keys keys) {
        new Actions(driver).sendKeys(keys)
                .build()
                .perform();
    }

    public static void pressEscapeKey (WebDriver driver) {
        pressKey(driver, Keys.ESCAPE);
    }

    public static void moveToElement (WebDriver driver, WebElement webElement) {
        new Actions(driver).moveToElement(webElement)
                .build()
                .perform();
    }

    public static void moveByOffset (WebDriver driver, int xOffset, int yOffset) {
        new Actions(driver).moveByOffset(xOffset, yOffset)
                .build()
                .perform();
    }
}
