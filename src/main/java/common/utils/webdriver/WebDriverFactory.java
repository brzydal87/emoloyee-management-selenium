package common.utils.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class WebDriverFactory {

    private static WebDriver driver;
    private static Properties properties;
    private static boolean reuseWebDriver;

    static {
        loadProperties();
    }

    public static WebDriver createWebDriver() {
        if (driver == null || !reuseWebDriver) {
            String browser = properties.getProperty("browser");
            if (browser == null) {
                throw new IllegalArgumentException("Browser property is not specified in configuration.properties");
            }

            boolean isRemote = Boolean.parseBoolean(properties.getProperty("remote"));
            String remoteUrl = properties.getProperty("remoteUrl");
            reuseWebDriver = Boolean.parseBoolean(properties.getProperty("reusewebdriver"));

            DriverFactory driverFactory = DriverFactoryProvider.getDriverFactory(browser);

            if (isRemote) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(browser);
                driver = driverFactory.createRemoteDriver(remoteUrl, capabilities);
            } else {
                driver = driverFactory.createDriver();
            }
        }
        return driver;
    }

    private static void loadProperties() {
        properties = new Properties();
        try (InputStream input = WebDriverFactory.class.getClassLoader().getResourceAsStream("configuration.properties")) {
            if (input == null) {
                throw new IllegalArgumentException("File configuration.properties not found in classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void quitWebDriver() {
        if (driver != null && !reuseWebDriver) {
            driver.quit();
            driver = null;
        }
    }

    public static void forceQuitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}