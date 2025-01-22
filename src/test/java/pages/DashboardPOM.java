package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboardPOM extends CommonMethods {
    @FindBy(css = "div.head h1")
    public WebElement pageVerificationElement;

    @FindBy(css = "a.firstLevelMenu#menu_pim_viewPimModule")
    public WebElement menuItemPIM;

    public DashboardPOM() {
        PageFactory.initElements(driver, this);
    }

}
