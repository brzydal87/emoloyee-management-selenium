package pages;

import groovy.util.logging.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public abstract class AbstractObject {

    protected WebDriver driver;

    public AbstractObject(WebDriver driver) {
        this(driver, false);
    }

    public AbstractObject(WebDriver driver, boolean isSilent) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
/*        if(!isSilent)
            log.info("'{}' - Page class was instantiated", this.getClass().getSimpleName());*/
    }
}
