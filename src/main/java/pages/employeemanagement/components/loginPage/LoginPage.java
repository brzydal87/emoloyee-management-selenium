package pages.employeemanagement.components.loginPage;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @FindBy(id = "username")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage isAt() {
        return this;
    }

    @Step("User enters username: - '{0}'")
    public LoginPage enterUsername(String username){
        fillFieldWithText(usernameInput, username);
        return this;
    }
    @Step("User enters password: - '{0}'")
    public LoginPage enterPassword(String password){
        fillFieldWithText(passwordInput, password);
        return this;
    }

    @Step("User clicks Login button")
    public LoginPage clickLogin(){
        clickElement(loginButton);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this; //should be EmpoloyeeManagement.isAT()
    }

}
