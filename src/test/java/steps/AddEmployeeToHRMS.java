package steps;

import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.CommonMethods;
import utils.Constants;

import java.util.List;
import java.util.Map;

public class AddEmployeeToHRMS extends CommonMethods {
    @When("user clicks on PIM menu item")
    public void user_clicks_on_pim_menu_item() {
        clickOnElement(dashboardPage.menuItemPIM);
//        stops test because we are not on the correct page
        waitForElementToBeVisible(addEmployeePage.pageVerificationElement);
        Assert.assertEquals("Employee Information", addEmployeePage.pageVerificationElement.getText());
    }

    @When("user clicks on Add Employee menu item")
    public void user_clicks_on_add_employee_menu_item() {
        clickOnElement(addEmployeePage.addEmplBtnAddEmplForm);
    }

    @When("user enters firstname and middlename and lastname")
    public void user_enters_firstname_and_middlename_and_lastname(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> newEmplNames = dataTable.asMaps();
        for (Map<String, String> newEmploee : newEmplNames) {
            sendTextToElement(newEmploee.get("firstname") == null ? ""+Keys.ESCAPE : newEmploee.get("firstname"), addEmployeePage.firstNameAddEmplForm);
            sendTextToElement(newEmploee.get("middlename") == null ? "" : newEmploee.get("middlename"), addEmployeePage.middleNameAddEmplForm);
            sendTextToElement(newEmploee.get("lastname") == null ? ""+Keys.ESCAPE : newEmploee.get("lastname"), addEmployeePage.lastNameAddEmplForm);
            //waitForElementToBeVisible(addEmployeePage.requiredFirstName);
//            clickOnElement(addEmployeePage.saveBtnAddEmplForm);
//            WebElement verificationElement = driver.findElement(By.cssSelector("div.head h1"));
            boolean firstNameEmpty = addEmployeePage.firstNameAddEmplForm.getAttribute("value").isEmpty();
            boolean lastNameEmpty = addEmployeePage.lastNameAddEmplForm.getAttribute("value").isEmpty();
            if (firstNameEmpty) {
                WebElement requiredFirstName = driver.findElement(By.cssSelector("span.validation-error[for='firstName']"));
                System.out.print("Add Employee: the 'firstname' is empty, ");
                if (requiredFirstName.isDisplayed()) System.out.println(Constants.greenText + "'Required' is displayed (PASSED)" + Constants.nocolorText);
                else System.out.println(Constants.redText + "'Required' is not displayed (FAILED)" + Constants.nocolorText);
            }
            if (lastNameEmpty) {
                WebElement requiredLastName = driver.findElement(By.cssSelector("span.validation-error[for='lastName']"));
                System.out.print("Add Employee: the 'lastname' is empty, ");
                if (requiredLastName.isDisplayed()) System.out.println(Constants.greenText + "'Required' is displayed (PASSED)" + Constants.nocolorText);
                else System.out.println(Constants.redText + "'Required' is not displayed (FAILED)" + Constants.nocolorText);
            }
            Thread.sleep(3000);
            if (!(firstNameEmpty || lastNameEmpty)) {
                clickOnElement(addEmployeePage.saveBtnAddEmplForm);
                clickOnElement(addEmployeePage.addEmplBtnAddEmplForm);
            }
        }
    }

}
