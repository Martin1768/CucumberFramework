package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.CommonMethods;

public class Hooks extends CommonMethods {
    @Before
    public void beforeTest(Scenario scenario) {
        openHRMSPortal();
        System.out.println("\nScenario: " + scenario.getName());
    }

    @After
    public void afterTest() {
        closeBrowser();
    }
}
