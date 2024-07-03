package pages.employeemanagement.components.employeeManagementPage.modal;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class AddEmployeeSection extends BasePage<AddEmployeeSection> {

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "surname")
    private WebElement surnameInput;

    @FindBy(name = "position")
    private WebElement positionInput;

    @FindBy(name = "salary")
    private WebElement salaryInput;

    @FindBy(name = "dayJoined")
    private WebElement dateJoinedPicker;

    @FindBy(name = "dateOfBirth")
    private WebElement dateJOfBirthPicker;

    @FindBy(xpath = "//button[text()='Add Employee']")
    private WebElement addEmployeeBtn;

    public AddEmployeeSection(WebDriver driver) {
        super(driver);
    }

    public AddEmployeeSection fillNameWith(String text) {
        fillFieldWithText(nameInput, text);
        return this;
    }

    public AddEmployeeSection fillSurnameWith(String text) {
        fillFieldWithText(surnameInput, text);
        return this;
    }

    public AddEmployeeSection fillPositionWith(String text) {
        fillFieldWithText(positionInput, text);
        return this;
    }

    public AddEmployeeSection fillSalaryWith(String text) {
        fillFieldWithText(salaryInput, text);
        return this;
    }

    public AddEmployeeSection clickAddEmployeeBtn() {
        clickElement(addEmployeeBtn);
        return this;
    }

}
