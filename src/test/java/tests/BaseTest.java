package tests;

import com.example.credential_service.UserEntity;
import common.configuration.Configuration;
import common.utils.AllureUtils;
import common.utils.ConfigurationUtils;
import io.restassured.internal.common.assertion.AssertionSupport;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import common.utils.webdriver.WebDriverFactory;
import pages.employeemanagement.components.employeeManagementPage.modal.EmployeeManagementPage;
import steps.BaseLoginStepDefs;


public abstract class BaseTest {

    protected static final Configuration configuration = ConfigurationUtils.configuration;
    protected WebDriver driver;
    private static final String CREDENTIAL_SERVICE_URL = "http://localhost:8081/api/users/";
    protected static UserEntity managerUser;
    protected static UserEntity regularUser;
    private static RestTemplate restTemplate;
    protected BaseLoginStepDefs baseLoginStepDefs;


    @BeforeEach
    public void setUp() {
        driver = WebDriverFactory.createWebDriver();
        driver.get("http://localhost:8080");
        restTemplate = new RestTemplate();
        managerUser = getCredentialsByRole("MANAGER");
        regularUser = getCredentialsByRole("REGULAR");
        baseLoginStepDefs = new BaseLoginStepDefs(driver);
    }

    @AfterEach
    public void tearDown() {
        if (!shouldReuseWebDriver()) {
            WebDriverFactory.quitWebDriver();
        }
    }

    private boolean shouldReuseWebDriver() {
        return Boolean.parseBoolean(System.getProperty("reusewebdriver", "false"));
    }

    public static class TestWatcher implements AfterTestExecutionCallback {
        @Override
        public void afterTestExecution(ExtensionContext context) throws Exception {
            if (context.getExecutionException().isPresent()) {
                WebDriverFactory.forceQuitWebDriver();
            }
        }
    }

    private UserEntity getCredentialsByRole(String role) {
        ResponseEntity<UserEntity> response = restTemplate.getForEntity(CREDENTIAL_SERVICE_URL + role, UserEntity.class);
        return response.getBody();
    }
//TODO handle proper allure configuration
/*    protected void executeConfiguration(Runnable runnable, String description) {
        if (status.executed){
            AllureUtils.setFixtureName(description);
        } else {
            status.executed = true;
            AllureUtils.setFixtureName(description);
            AllureUtils.takeScreenshotOnFail(runnable, driver);
            status.passed = true;
        }
        Assumptions.assumeTrue(status.passed, "Set up method failed");
    }

    private static class ConfigurationMethodStatus {
        boolean executed;
        boolean passed;
    }*/

}