package common.utils;

import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebElementParser {

    public static String getLocator(WebElement webElement) {
        String locator = webElement.toString();
        Pattern pattern = Pattern.compile("(->)(.*)", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(locator);

        boolean matchFound = matcher.find();
        if (matchFound){
            StringBuilder sb = new StringBuilder(matcher.group(2));
            sb.insert(0, "(").append(")");
            return sb.toString();
        } else {
            return locator;
        }
    }
}
