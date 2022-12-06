package coinmarketcap.stepDefinitions;

import coinmarketcap.pageObjects.CryptocurrenciesRankingPage.CryptocurrenciesRankingPage;
import cucumber.TestContext;
import io.cucumber.java.en.*;
import managers.FileReaderManager;

import static org.assertj.core.api.Assertions.assertThat;

public class AccessCoinMarketCapDotComSteps {
    TestContext testContext;
    CryptocurrenciesRankingPage cryptocurrenciesRankingPage;

    public AccessCoinMarketCapDotComSteps(TestContext context) {
        testContext = context;
        cryptocurrenciesRankingPage = testContext.getPageObjectManager().getCryptocurrenciesRankingPage();
    }

    protected void access_url(String url) {
        testContext.getWebDriverManager().getDriver().get(url);
    }

    @Given("I access coinmarketcap.com")
    public void accessCoinMarketCapDotCom() {
       access_url(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
    }

        @Then("the cryptocurriencies ranking page is displayed")
    public void assertCryptocurreniesRankingPageIsDisplayed() {
        assertThat(cryptocurrenciesRankingPage.getPageHeader())
                .isEqualTo(CryptocurrenciesRankingPage.PAGE_HEADER_TEXT);
    }
}
