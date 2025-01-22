package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePOM extends CommonMethods {
    @FindBy(css = "div.head h1")
    public WebElement pageVerificationElement;

    @FindBy(css = "input#firstName")
    public WebElement firstNameAddEmplForm;

    @FindBy(css = "input#middleName")
    public WebElement middleNameAddEmplForm;

    @FindBy(css = "input#lastName")
    public WebElement lastNameAddEmplForm;

    @FindBy(css = "input#employeeId")
    public WebElement emplIDAddEmplForm;

    @FindBy(css = "a#menu_pim_addEmployee")
    public WebElement addEmplBtnAddEmplForm;

    @FindBy(css = "input#btnSave")
    public WebElement saveBtnAddEmplForm;

    public AddEmployeePOM() {
        PageFactory.initElements(driver, this);
    }

}
