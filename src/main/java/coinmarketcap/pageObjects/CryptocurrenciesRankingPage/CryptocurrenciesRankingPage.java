package coinmarketcap.pageObjects.CryptocurrenciesRankingPage;

import coinmarketcap.pageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CryptocurrenciesRankingPage extends BasePage {
    public static final String PAGE_TITLE_TEXT = "Cryptocurrency Prices, Charts And Market Capitalizations | CoinMarketCap";
    public static final String PAGE_HEADER_TEXT = "Today's Cryptocurrency Prices by Market Cap";

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Maybe later')]")
    private WebElement MAYBE_LATER_POP_UP_BUTTON;

    @FindBy(how = How.CSS, using = "div.sc-aef7b723-0.jPLKhd.table-control-page-sizer > div")
    private WebElement SHOW_RESULTS_DROP_DOWN;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), '20')]")
    private WebElement TWENTY_RESULTS;

    @FindBy(how = How.XPATH, using = "(//button[contains(text(), 'Filters')])[2]")
    private WebElement FILTERS_BUTTON;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Algorithm')]")
    private WebElement ALGORITHM_BUTTON;

    @FindBy(how = How.CSS, using = "div.tippy-content > div > div > div:nth-child(1) > ul > li:nth-child(5)")
    private WebElement POW_OPTION;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), '+')]")
    private WebElement ADD_FILTER_BUTTON;

    public CryptocurrenciesRankingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickMaybeLaterPopUpButton() {
        MAYBE_LATER_POP_UP_BUTTON.click();
    }
    public void displayFirst20Rows() {
        SHOW_RESULTS_DROP_DOWN.click();
        TWENTY_RESULTS.click();
    }

    public void clickFiltersButton() {
        FILTERS_BUTTON.click();
    }

    public void clickAlgorithmButton() {
        ALGORITHM_BUTTON.click();
    }

    public void clickAlgorithmOptionPow() {
        POW_OPTION.click();
    }

    public void clickAddFilter() {
        ADD_FILTER_BUTTON.click();
    }
}
