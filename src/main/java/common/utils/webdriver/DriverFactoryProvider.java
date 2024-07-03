package common.utils.webdriver;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class DriverFactoryProvider {

    public static DriverFactory getDriverFactory(String browserType) {
        String driverFactoryPackage = DriverFactory.class.getPackage().getName();
        Reflections reflections = new Reflections(driverFactoryPackage);
        Set<Class<? extends DriverFactory>> driverFactories = reflections.getSubTypesOf(DriverFactory.class);

        Class<? extends DriverFactory> driverClass = driverFactories
                .stream()
                .filter(driver -> driver.getSimpleName().toLowerCase().contains(browserType.toLowerCase()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Did not find driver class with name " + browserType));

        try {
            return driverClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new IllegalStateException(e);
        }
    }
}