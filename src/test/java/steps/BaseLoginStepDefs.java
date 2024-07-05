package steps;

import app.credential_service.UserEntity;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import pages.employeemanagement.components.employeeManagementPage.modal.EmployeeManagementPage;
import pages.employeemanagement.components.loginPage.LoginPage;

public class BaseLoginStepDefs {

    protected final WebDriver driver;

    public BaseLoginStepDefs(WebDriver driver) {
        this.driver = driver;
    }

    @Step("User logs in into the Employee-Management application by username with role '{user.role}'")
    public EmployeeManagementPage signInToApplication(UserEntity user) {
        //TODO add hiding credentials
        new LoginPage(driver)
                .enterUsername(user.getUsername())
                .enterPassword(user.getPassword())
                .clickLogin();
        return new EmployeeManagementPage(driver).isAt();
    }

    @Step("User logs out form application")
    public LoginPage logOutFromApplication() {
        new EmployeeManagementPage(driver).clickLogOut();
        return new LoginPage(driver).isAt();
    }
}
