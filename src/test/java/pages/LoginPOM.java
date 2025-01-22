package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPOM extends CommonMethods {
    @FindBy(id = "txtUsername")
    public WebElement usernameLoginForm;

    @FindBy(id = "txtPassword")
    public WebElement passwordLoginForm;

    @FindBy(id = "btnLogin")
    public WebElement submitBtnLoginForm;

    @FindBy(css = "span#spanMessage")
    public WebElement errorMsgLoginForm;

    public LoginPOM() {
        PageFactory.initElements(driver, this);
    }

}
