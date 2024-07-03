package tests;

import common.model.Employee;
import common.providers.DataProvider;
import common.utils.ApiUtils;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import pages.employeemanagement.components.employeeManagementPage.modal.AddEmployeeSection;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddEmployeeTests extends BaseTest {

    String employeeId;

    @Test
    public void testAddingEmployee() {
        Employee employee = DataProvider.getEmployee();

        AddEmployeeSection addEmployeeSection = new AddEmployeeSection(driver);
        addEmployeeSection
                .fillNameWith(employee.getName())
                .fillSurnameWith(employee.getSurname())
                .fillPositionWith(employee.getPosition())
                .fillSalaryWith(String.valueOf(employee.getSalary()))
                .clickAddEmployeeBtn();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void cleanup() {
        Response deleteResponse = ApiUtils.deleteEmployee(managerUser, employeeId);
        assertEquals(204, deleteResponse.getStatusCode());
    }
}
