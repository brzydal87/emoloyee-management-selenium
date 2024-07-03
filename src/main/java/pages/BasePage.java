package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage<T extends BasePage<T>> {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @SuppressWarnings("unchecked")
    protected T get() {
        return (T) this;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public T clickElement(WebElement webElement) {
        webElement.click();
        return (T) this;
    }

    public T fillFieldWithText(WebElement webElement, String text){
        webElement.sendKeys(text);
        return (T) this;
    }

    // Add more common methods for all pages here
}