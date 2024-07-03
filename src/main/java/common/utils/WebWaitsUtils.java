package common.utils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class WebWaitsUtils {

    private static final Logger log = LoggerFactory.getLogger(WebWaitsUtils.class);
    private final WebDriver driver;

    public WebWaitsUtils(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement waitForElementToBeVisible(WebElement webElement) {
        return waitForElementToBeVisible(webElement, Duration.ofSeconds(30));
    }

    public WebElement waitForElementToBeVisible(WebElement webElement, Duration timeout) {
        return new WebDriverWait(driver, timeout)
                .ignoring(NoSuchWindowException.class)
                .until(CustomExpectedConditions.visibilityOf(webElement));
    }

    public WebElement waitForElementToBeClickable(WebElement webElement, Duration timeout){
        log.info("Waiting for WebElement to be clickable within {} seconds.", timeout.getSeconds());
        return new WebDriverWait(driver, timeout)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public <T> T waitUntil (Duration timeout, ExpectedCondition<T> expactedCondition) {
        log.info("Wait for expected condition '{}' within '{}' seconds.", timeout.getSeconds());
        return new WebDriverWait(driver, timeout).until(expactedCondition);
    }
}
