package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonMethods extends PagesInit {
    public static WebDriver driver;

    public static void openHRMSPortal() {
        String browserFromConfig = ConfigReader.getProperty("browser");
        if (browserFromConfig == null) browserFromConfig = "chrome";
        switch (browserFromConfig) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-gpu");
                driver = new ChromeDriver(options);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name: " + browserFromConfig);
        }
//    driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        String url = ConfigReader.getProperty("hrms.url");
        if (url != null) driver.get(url);
        else driver.get("/non-existent-page");

        initPageObjects();
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.close();
        }
    }

    public static WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitForElementToBeVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void clickOnElement(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }
    public static void sendTextToElement(String text, WebElement element) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

}
