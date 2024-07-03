package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseTableViewPage<T extends BaseTableViewPage> extends WebPage {

    @FindBy(xpath = "//table")
    protected WebElement tableContainer;

    @FindBy(xpath = "//th[text()='Name']")
    protected WebElement nameColumn;

    public BaseTableViewPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public T isAt() {
        nameColumn.isDisplayed();
        return (T) this;
    }

    protected T getContainter() {
        return (T) this;
    }

    abstract protected WebElement getContainer();

}
