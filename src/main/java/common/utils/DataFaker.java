package common.utils;

import com.github.javafaker.Faker;
import lombok.Getter;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataFaker {

    @Getter
    private static final String SUFFIX = "UI-TEST";
    private static final int MINIMAL_Value = 1;
    private static final int MAX_VALUE = 100000000;
    private static final Faker FAKER = new Faker();

    public static String getName() {
        return FAKER.name().firstName()  + " " + SUFFIX;
    }

    public static String getLastName() {
        return FAKER.name().lastName()  + " " + SUFFIX;
    }

    public static String getPosition() {
        return FAKER.job().position();
    }

    public static String getNumberBetween (int MINIMAL_Value, int MAX_VALUE) {
        return String.valueOf(getNumberBetween(MINIMAL_Value, MAX_VALUE));
    }

    public static int getRandomNumber (int min, int max) {
        return FAKER.number().numberBetween(min, max);
    }

}
