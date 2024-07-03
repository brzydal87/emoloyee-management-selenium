package common.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.module.Input;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class DatePicker {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    public Input input;

    public DatePicker(WebDriver driver, WebElement container) {

    }

    public static String formatDate(LocalDate date){
        return date.format(DateTimeFormatter.ofPattern(DATE_PATTERN));
    }

    public void setValue(LocalDate localDate) {
        setValue(formatDate(localDate));
    }

    public DatePicker setValue(String date) {
        return this;
    }
}
