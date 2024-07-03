package common.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CustomExpectedConditions {

    public static ExpectedCondition<WebElement> visibilityOf(final WebElement element) {
        return new ExpectedCondition<>() {
            public WebElement apply(WebDriver driver){
                try {
                    return element.isDisplayed() ? element : null;
                } catch (NotFoundException | StaleElementReferenceException | ElementNotInteractableException e) {
                    return null;
                }
            }
            public String toString(){
                return "Wait for WebElement to be displayed";
            }
        };
    }
}
