package pages;

import common.utils.WebElementUtils;
import common.utils.WebWaitsUtils;
import org.openqa.selenium.*;

import java.time.Duration;

public abstract class WebPage extends AbstractObject {

    public final WebWaitsUtils webWaitsUtils;
    public final WebElementUtils webelementUtils;

    public WebPage(WebDriver driver){
        this(driver, false);
    }

    public WebPage(WebDriver driver, boolean isSilent){
        super(driver, isSilent);
        this.webelementUtils = new WebElementUtils(driver);
        this.webWaitsUtils = new WebWaitsUtils(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public boolean isDisplayedWithWait(WebElement webElement, Duration timeout) {
        try {
            webWaitsUtils.waitForElementToBeVisible(webElement, timeout);
            return WebElementUtils.isDisplayed(webElement);
            //return isDisplayed(webElement);
        } catch (NoSuchElementException | TimeoutException e) {
            //log.info("WebElement is not present in the DOM");
            return false;
        }
    }

    public void waitFor(int timeout) {
        //log.warn("Static wait for: {} ms", timeout);
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            //log.error("Sleep exception", e);
        }
    }

    public void clickElement(WebElement element) {
        WebElementUtils.click(driver, element);
    }

}
