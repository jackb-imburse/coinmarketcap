package coinmarketcap.stepDefinitions;

import coinmarketcap.pageObjects.CryptocurrenciesRankingPage.CryptocurrenciesRankingPage;
import coinmarketcap.pageObjects.CryptocurrenciesRankingPage.MoreFiltersModal;
import coinmarketcap.pageObjects.CryptocurrenciesRankingPage.RankingTableRows;
import coinmarketcap.testData.dataTypes.CryptoCurrency;
import cucumber.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class CryptocurrienciesRankingPageSteps {

    TestContext testContext;
    CryptocurrenciesRankingPage cryptocurrenciesRankingPage;
    MoreFiltersModal moreFiltersModal;
    RankingTableRows rankingTableRows;

    public CryptocurrienciesRankingPageSteps(TestContext context) {
        testContext = context;
        cryptocurrenciesRankingPage = testContext.getPageObjectManager().getCryptocurrenciesRankingPage();
        moreFiltersModal = testContext.getPageObjectManager().getMoreFiltersModal();
        rankingTableRows = testContext.getPageObjectManager().getRankingTableRows();
    }

    @Given("I view the ranking data when showing the first 20 rows")
    public void viewRankingDataWhenShowingFirst20Rows() {
        cryptocurrenciesRankingPage.displayFirst20Rows();
        testContext.getCapturedDataValidationManager().getRankingTableRows().maxDisplayRowCount = 20;
        recordRankingTableData();
    }

    @When("I filter by algorithm PoW")
    public void filterByAlgorithmPoW() {
        cryptocurrenciesRankingPage.clickFiltersButton();
        cryptocurrenciesRankingPage.clickAlgorithmButton();
        cryptocurrenciesRankingPage.clickAlgorithmOptionPow();
    }

    @When("I add more filters options Mineable, Coins and Price between 100 and 10000")
    public void addMoreFiltersOptionsMineableCoinsPrice100To10000() throws InterruptedException {
        cryptocurrenciesRankingPage.clickAddFilter();
        moreFiltersModal.toggleMineable();
        moreFiltersModal.selectCurrenciesCoin(testContext.getWebDriverManager().getDriver());
        moreFiltersModal.setPriceRange(testContext.getWebDriverManager().getDriver(), "100", "10000");
        testContext.getCapturedDataValidationManager().getRankingTableRows().setPriceRangeMinimumValue(100);
        testContext.getCapturedDataValidationManager().getRankingTableRows().setPriceRangeMaximumValue(10000);
        try {
            moreFiltersModal.clickApplyFilter(testContext.getWebDriverManager().getDriver());
        } catch (ElementClickInterceptedException cie) {
            cryptocurrenciesRankingPage.clickMaybeLaterPopUpButton();
            moreFiltersModal.clickApplyFilter(testContext.getWebDriverManager().getDriver());
        }
        try {
            moreFiltersModal.clickShowResults(testContext.getWebDriverManager().getDriver());
        } catch (ElementClickInterceptedException cie) {
            cryptocurrenciesRankingPage.clickMaybeLaterPopUpButton();
            moreFiltersModal.clickShowResults(testContext.getWebDriverManager().getDriver());
        }
    }

    @Then("the cryptocurriencies ranking page is displayed")
    public void assertCryptocurrenciesRankingPageIsDisplayed() {
        assertThat(cryptocurrenciesRankingPage.getPageHeader())
                .isEqualTo(CryptocurrenciesRankingPage.PAGE_HEADER_TEXT);
    }

    @Then("the ranking data is filtered")
    public void rankingDataIsFiltered() throws InterruptedException {
        Thread.sleep(1000);
        LinkedList<RankingTableRows.CurrencyRowElement> filteredCurrencyRows = rankingTableRows.getDisplayedCurrencies();
        LinkedList<CryptoCurrency> filteredCurrencies = new LinkedList<>();
        for (RankingTableRows.CurrencyRowElement filteredCurrencyRow : filteredCurrencyRows) {
            filteredCurrencies.add(
                    new CryptoCurrency(
                            filteredCurrencyRow.getPosition(),
                            getCurrencyNameFromCurrenciesUrl(filteredCurrencyRow.getName()),
                            filteredCurrencyRow.getPrice()
                    )
            );
        }

        assertThat(filteredCurrencies.size()).isLessThanOrEqualTo(testContext.getCapturedDataValidationManager().getRankingTableRows().getMaxDisplayedRowCount());

        for (CryptoCurrency currency : filteredCurrencies) {
            String price = currency.price.replace(",", "");
            assertThat(Integer.parseInt(currency.price.substring(price.indexOf("$")+1, price.lastIndexOf("."))))
                .isGreaterThanOrEqualTo(testContext.getCapturedDataValidationManager().getRankingTableRows().getPriceRangeMinimumValue())
                .isLessThanOrEqualTo(testContext.getCapturedDataValidationManager().getRankingTableRows().getPriceRangeMaximumValue());
        }

        LinkedList<CryptoCurrency> unfilteredCurrencies = testContext.getCapturedDataValidationManager().getRankingTableRows().currencies;

        /* When writing a test to filter table data I would aim to assert that the filtered list only contains data that matches the applied filtered.
        I would looking to check things like Mineable and Coins for the given currencies.
        In this instance I have been asked to compare the result set.
        The below shows some comparisons that output the results to the console rather than running asserts against the result set. */

        if (filteredCurrencies.size() == unfilteredCurrencies.size()) {
            System.out.println("The number of filtered currencies is the same as the number of unfiltered currencies");
            System.out.println("Filtered currencies count: " + filteredCurrencies.size());
            System.out.println("Unfiltered currencies count: " + unfilteredCurrencies.size());
        } else {
            System.out.println("The number of filtered currencies is less than the number of unfiltered currencies");
            System.out.println("Filtered currencies count: " + filteredCurrencies.size());
            System.out.println("Unfiltered currencies count: " + unfilteredCurrencies.size());
        }

        List<String> matchedCurrencies = new ArrayList<>();
        for (CryptoCurrency unfilteredCurrency : unfilteredCurrencies) {
            for (CryptoCurrency filteredCurrency : filteredCurrencies) {
                if (Objects.equals(unfilteredCurrency.name, filteredCurrency.name)) {
                    matchedCurrencies.add(filteredCurrency.name);
                }
            }
        }

        if (matchedCurrencies.size() == 0) {
            System.out.println("None of the filtered currencies matched the unfiltered currencies");
        } else {
            System.out.println("There were " + matchedCurrencies.size() + " matched currencies, here are the matched currencies" );
            for (String currency : matchedCurrencies) {
                System.out.println(currency);
            }
        }
    }

    private void recordRankingTableData() {
        LinkedList<RankingTableRows.CurrencyRowElement> currencies = rankingTableRows.getDisplayedCurrencies();
        for (int i = 0; i < currencies.size(); i++) {
            JavascriptExecutor js = (JavascriptExecutor) testContext.getWebDriverManager().getDriver();
            WebElement element = testContext.getWebDriverManager().getDriver().findElement(rankingTableRows.getRowIdentifier(i+1));
            js.executeScript("arguments[0].scrollIntoView();", element);
            try {
                testContext.getCapturedDataValidationManager().getRankingTableRows().currencies.add(
                        new CryptoCurrency(
                                currencies.get(i).getPosition(),
                                getCurrencyNameFromCurrenciesUrl(currencies.get(i).getName()),
                                currencies.get(i).getPrice()
                        )
                );
            } catch (StaleElementReferenceException | NoSuchElementException ee) {
                currencies = rankingTableRows.getDisplayedCurrencies();
                testContext.getCapturedDataValidationManager().getRankingTableRows().currencies.add(
                        new CryptoCurrency(
                                currencies.get(i).getPosition(),
                                getCurrencyNameFromCurrenciesUrl(currencies.get(i).getName()),
                                currencies.get(i).getPrice()
                        )
                );
            }
        }
    }

    private String getCurrencyNameFromCurrenciesUrl(String url) {
        return url.substring(37, url.length()-1);
    }
}
