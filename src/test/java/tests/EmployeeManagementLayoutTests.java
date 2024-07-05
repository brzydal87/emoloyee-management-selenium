package tests;

import common.providers.DataProvider;
import common.utils.ApiUtils;
import common.utils.AssertionUtils;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.employeemanagement.components.employeeManagementPage.modal.EmployeeManagementPage;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(BaseTest.TestWatcher.class)
public class EmployeeManagementLayoutTests extends BaseTest {

    private EmployeeManagementPage employeeManagementPage;
    private final String appTitle = "Employee Management";
    private String employeeId;

    @Test
    @Step("Verify Employee management UI elements")
    @DisplayName("[TC] Verify Employee Management UI elements MANAGER")
    public void testEmployeeManagementPageElementsManagerUser() {
        createEmployee();

        baseLoginStepDefs.signInToApplication(managerUser);
        employeeManagementPage = new EmployeeManagementPage(driver);
        AssertionUtils.verifyWebElementTextEqualsTo(employeeManagementPage.getPageTitle(), appTitle);
        //wrapwithstep?
        AssertionUtils.verifyWebElementsAreDisplayed(List.of(employeeManagementPage.getAddEmployeeBtn(),
                employeeManagementPage.getEditBtn(), employeeManagementPage.getDeleteBtn()));
    }

    @Test
    @Step("Verify Employee management UI elements")
    @DisplayName("[TC] Verify Employee Management UI elements REGULAR")
    public void testEmployeeManagementPageElementsRegulaUser() {
        createEmployee();

        baseLoginStepDefs.signInToApplication(regularUser);
        employeeManagementPage = new EmployeeManagementPage(driver);
        AssertionUtils.verifyWebElementTextEqualsTo(employeeManagementPage.getPageTitle(), appTitle);
        AssertionUtils.verifyWebElementIsNotDisplayed(employeeManagementPage.getAddEmployeeBtn());
        //check buttons are locked
        //AssertionUtils.verifyWebElementsAreNotDisplayed(List.of(employeeManagementPage.getEditBtn(), employeeManagementPage.getDeleteBtn()));
    }

    @AfterEach
    public void cleanup() {
        baseLoginStepDefs.logOutFromApplication();
        Response deleteResponse = ApiUtils.deleteEmployee(managerUser, employeeId);
        assertEquals(204, deleteResponse.getStatusCode());
    }

    private String createEmployee() {
        Response response = ApiUtils.createEmployee(managerUser, DataProvider.getEmployee());
        assertEquals(201, response.getStatusCode());
        employeeId = response.jsonPath().getString("id");
        return employeeId;
    }
}
