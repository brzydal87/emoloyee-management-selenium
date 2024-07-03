package steps;

import pages.employeemanagement.components.employeeManagementPage.modal.AddEmployeeSection;


public class EmployeeManagementSteps {

    AddEmployeeSection addEmployeeSection;

    public EmployeeManagementSteps() {
        super();
    }

    public EmployeeManagementSteps addEmployee() {
        addEmployeeSection
                .fillNameWith("ASD")
                .fillSurnameWith("SUR")
                .fillPositionWith("DEV")
                .fillSalaryWith("10000")
                .clickAddEmployeeBtn();
        return this;
    }
}
