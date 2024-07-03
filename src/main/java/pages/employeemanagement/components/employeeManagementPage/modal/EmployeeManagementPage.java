package pages.employeemanagement.components.employeeManagementPage.modal;

import common.utils.WebElementUtils;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BaseTableViewPage;

public class EmployeeManagementPage extends BaseTableViewPage<EmployeeManagementPage> {

    @Getter
    @FindBy(xpath = "//h1")
    private WebElement pageTitle;

    @Getter
    @FindBy(xpath = "//button[text()='Add Employee']")
    private WebElement addEmployeeBtn;

    @Getter
    @FindBy(className = "edit-btn")
    private WebElement editBtn;

    @Getter
    @FindBy(className = "delete-btn")
    private WebElement deleteBtn;

    @FindBy(id = "logoutBtn")
    private WebElement logOutBtn;

    //TODO Refactor class to use proper table handling
    @FindBy(xpath = "employeeTable")
    private WebElement container;

    public EmployeeManagementPage(WebDriver driver) {
        super(driver);
    }

    public EmployeeManagementPage isAt() {
        webWaitsUtils.waitForElementToBeVisible(pageTitle);
        return this;
    }

    public EmployeeManagementPage clickLogOut() {
        clickElement(logOutBtn);
        return this;
    }

    @Override
    protected WebElement getContainer() {
        return container;
    }
}
