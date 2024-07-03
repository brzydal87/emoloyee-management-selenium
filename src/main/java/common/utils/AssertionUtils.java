package common.utils;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AssertionUtils {

    public static void verifyWebElementIsDisplayed(WebElement webElement) {
        Assertions.assertThat(WebElementUtils.isDisplayed(webElement))
                .as("Verify that WebElement with xpath: '%s' is displayed correctly".formatted(WebElementParser.getLocator(webElement)))
                .isTrue();
    }

    public static void verifyWebElementIsNotDisplayed(WebElement webElement) {
        Assertions.assertThat(WebElementUtils.isDisplayed(webElement))
                .as("Verify that WebElement with xpath: '%s' is displayed correctly".formatted(WebElementParser.getLocator(webElement)))
                .isFalse();
    }

    public static void verifyWebElementsAreDisplayed(List<WebElement> webElements) {
        SoftAssertions softAssertions = new SoftAssertions();
        webElements.forEach(e -> verifyWebElementIsDisplayed(e, softAssertions));
        softAssertions.assertAll();;
    }

    public static void verifyWebElementsAreNotDisplayed(List<WebElement> webElements) {
        SoftAssertions softAssertions = new SoftAssertions();
        webElements.forEach(e -> verifyWebElementIsNotDisplayed(e, softAssertions));
        softAssertions.assertAll();;
    }

    public static void verifyWebElementIsDisplayed(WebElement webElement, SoftAssertions softAssertions) {
        softAssertions.assertThat(WebElementUtils.isDisplayed(webElement))
                .as("Verify that WebElement with xpath: '%s' is displayed correctly".formatted(WebElementParser.getLocator(webElement)))
                .isTrue();
    }

    public static void verifyWebElementIsNotDisplayed(WebElement webElement, SoftAssertions softAssertions) {
        softAssertions.assertThat(WebElementUtils.isDisplayed(webElement))
                .as("Verify that WebElement with xpath: '%s' is displayed correctly".formatted(WebElementParser.getLocator(webElement)))
                .isFalse();
    }

    public static void verifyWebElementTextEqualsTo(WebElement webElement, String expectedText) {
        Assertions.assertThat(WebElementUtils.getText(webElement))
                .as("Verify that WebElement with xpath: '%s' is contains text".formatted(WebElementParser.getLocator(webElement)))
                .isEqualTo(expectedText);
    }
}
