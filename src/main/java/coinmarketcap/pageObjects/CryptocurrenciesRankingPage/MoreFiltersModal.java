package coinmarketcap.pageObjects.CryptocurrenciesRankingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MoreFiltersModal {

    @FindBy(how = How.XPATH, using = "//label[@id=\"mineable\"]")
    private WebElement MINEABLE_TOGGLE;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'All Cryptocurrencies')]")
    private WebElement ALL_CRYPTOCURRENCIES_BUTTON;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Coins')]")
    private WebElement COINS_BUTTON;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Price')]")
    private WebElement PRICE_BUTTON;

    @FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[5]/div/div/div[2]/div/div[4]/div[1]/div[1]/input[1]")
    private WebElement MINIMUM_PRICE_INPUT;

    @FindBy(how = How.XPATH, using = "//*[@id=\"__next\"]/div/div[1]/div[2]/div/div[1]/div[5]/div/div/div[2]/div/div[4]/div[1]/div[1]/input[2]")
    private WebElement MAXIMUM_PRICE_INPUT;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Apply Filter')]")
    private WebElement APPLY_FILTER_BUTTON;

    @FindBy(how = How.XPATH, using = "//button[contains(text(), 'Show results')]")
    private WebElement SHOW_RESULTS_BUTTON;

    public MoreFiltersModal(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void toggleMineable() {
        MINEABLE_TOGGLE.click();
    }
    private void clickAllCryptocurrencies(WebDriver driver) throws InterruptedException {
        Thread.sleep(1000);
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(ALL_CRYPTOCURRENCIES_BUTTON));
        ALL_CRYPTOCURRENCIES_BUTTON.click();
    }

    private void selectCoins(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(COINS_BUTTON));
        COINS_BUTTON.click();
    }

    public void selectCurrenciesCoin(WebDriver driver) throws InterruptedException {
        clickAllCryptocurrencies(driver);
        selectCoins(driver);
    }


    private void clickPrice(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(PRICE_BUTTON));
        PRICE_BUTTON.click();
    }

    private void setMinimumPrice(WebDriver driver, String amount) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(MINIMUM_PRICE_INPUT));
        MINIMUM_PRICE_INPUT.sendKeys(amount);
    }

    private void setMaximumPrice(WebDriver driver, String amount) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(MINIMUM_PRICE_INPUT));
        MAXIMUM_PRICE_INPUT.sendKeys(amount);
    }

    public void setPriceRange(WebDriver driver, String minimum, String maximum) {
        clickPrice(driver);
        setMinimumPrice(driver, minimum);
        setMaximumPrice(driver, maximum);
    }

    public void clickApplyFilter(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(APPLY_FILTER_BUTTON));
        APPLY_FILTER_BUTTON.click();
    }

    public void clickShowResults(WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.elementToBeClickable(SHOW_RESULTS_BUTTON));
        SHOW_RESULTS_BUTTON.click();
    }
}
