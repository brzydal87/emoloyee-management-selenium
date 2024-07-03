package common.utils.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface DriverFactory {

    WebDriver createDriver();
    WebDriver createRemoteDriver(String remoteUrl, DesiredCapabilities capabilities);

}