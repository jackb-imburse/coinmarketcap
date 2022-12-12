package coinmarketcap.stepDefinitions;

import coinmarketcap.pageObjects.ToolTip;
import cucumber.TestContext;
import io.cucumber.java.en.*;
import managers.FileReaderManager;

public class AccessCoinMarketCapDotComSteps {
    TestContext testContext;
    ToolTip toolTip;

    public AccessCoinMarketCapDotComSteps(TestContext context) {
        testContext = context;
        toolTip = testContext.getPageObjectManager().getToolTip();
    }

    protected void access_url(String url) {
        testContext.getWebDriverManager().getDriver().get(url);
    }

    @Given("I access coinmarketcap.com")
    public void accessCoinMarketCapDotCom() {
       access_url(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
       toolTip.closeToolTip();
    }
}
