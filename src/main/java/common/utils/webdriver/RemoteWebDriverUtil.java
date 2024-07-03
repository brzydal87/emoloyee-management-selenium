package common.utils.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class RemoteWebDriverUtil {

    public static WebDriver createRemoteDriver(String remoteUrl, DesiredCapabilities capabilities) {
        try {
            return new RemoteWebDriver(new URL(remoteUrl), capabilities);
        } catch (MalformedURLException e) {
            throw new IllegalStateException("Invalid remote URL: " + remoteUrl, e);
        }
    }
}