package common.utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class WebElementUtils {

    private final WebDriver driver;

    public WebElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static void click (WebDriver driver, WebElement webElement) {
        webElement.click();
    }

    public static String getText(WebElement webElement) {
        return getText(webElement, false, null);
    }

    public static String getText(WebElement webElement, boolean returnIfAbsent, String returnValue) {
        try {
            String text = webElement.getText();
            return (StringUtils.isBlank(text) && returnIfAbsent) ? returnValue : text;
        } catch (NoSuchElementException e) {
            if (returnIfAbsent) {
                return returnValue;
            }
            throw e;
        }
    }

    public static boolean isDisplayed(WebElement webElement) {
        //log.info("");
        try {
            boolean isDisplayed = webElement.isDisplayed();
            //log.info("WebElement is " + (isDisplayed ? "displayed" : "not displayed"));
            return isDisplayed;
        } catch (NotFoundException | StaleElementReferenceException | ElementNotInteractableException e) {
            //log.info("WebElement is not present in the DOM");
            return false;
        }
    }


    private static ExpectedCondition<Boolean> tryToClick(WebElement webElement) {
        return new ExpectedCondition<>() {
            public Boolean apply(WebDriver driver) {
                try {
                    click(driver, webElement);
                } catch (StaleElementReferenceException e) {
                    return false;
                }
                return true;
            }
            public String toString() {
                return "Wait for element to be clicked";
            }
        };
    }


}
