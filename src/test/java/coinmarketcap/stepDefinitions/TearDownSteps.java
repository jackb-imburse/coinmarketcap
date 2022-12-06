package coinmarketcap.stepDefinitions;

import cucumber.TestContext;
import io.cucumber.java.After;

public class TearDownSteps {

    TestContext testContext;

    public TearDownSteps(TestContext context) {
        testContext = context;
    }
    @After("@UI")
    public void closeDriver() {
        testContext.getWebDriverManager().closeDriver();
    }
}
