package steps;

import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonMethods;
import utils.ConfigReader;
import utils.Constants;

import java.util.List;
import java.util.Map;

public class LoginToHRMS extends CommonMethods {
    @Given("user can access the login page of hrms application")
    public void user_can_access_the_login_page_of_hrms_application() {
//        method from CommonMethods inits driver and opens hrms login page
        openHRMSPortal();
    }

    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() {
        String user, pwd;
//        if getProperty fails user and pwd will be set to specific value because null is exception
        if ((user = ConfigReader.getProperty("hrms.admin")) == null) user = "unknown user";
        if ((pwd = ConfigReader.getProperty("hrms.adminpassword")) == null) pwd = "";
        sendTextToElement(user, loginPage.usernameLoginForm);
        sendTextToElement(pwd, loginPage.passwordLoginForm);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        clickOnElement(loginPage.submitBtnLoginForm);
    }

    @Then("user will be redirected to dashboard page")
    public void user_will_be_redirected_to_dashboard_page() {
        if ("Dashboard".equals(dashboardPage.pageVerificationElement.getText()))
            System.out.println(Constants.greenText + "Login to HRSM portal: PASSED" + Constants.nocolorText);
        else
            System.out.println(Constants.redText + "Login to HRSM portal: FAILED" + Constants.nocolorText);
    }

    @When("user enters invalid username or password")
    public void user_enters_invalid_username_or_password(io.cucumber.datatable.DataTable dataTable) {
        List<Map<String, String>> loginCases = dataTable.asMaps();
        for (Map<String, String> loginCase : loginCases) {
            sendTextToElement(loginCase.get("username") == null ? "" : loginCase.get("username"), loginPage.usernameLoginForm);
            sendTextToElement(loginCase.get("password") == null ? "" : loginCase.get("password"), loginPage.passwordLoginForm);
            clickOnElement(loginPage.submitBtnLoginForm);
            String msg = loginPage.errorMsgLoginForm.getText();
            if (loginCase.get("errmsg").equals(msg))
                System.out.println(Constants.greenText + "Expected: '" + loginCase.get("errmsg") + "', Displayed: '" + msg + "' PASSED" + Constants.nocolorText);
            else
                System.out.println(Constants.redText + "Expected: '" + loginCase.get("errmsg") + "', Displayed: '" + msg + "' FAILED" + Constants.nocolorText);
        }
    }

    @Then("error message will be displayed")
    public void error_message_will_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
