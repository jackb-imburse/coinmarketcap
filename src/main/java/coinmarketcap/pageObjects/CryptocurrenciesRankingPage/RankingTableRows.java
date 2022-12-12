package coinmarketcap.pageObjects.CryptocurrenciesRankingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedList;
import java.util.List;

public class RankingTableRows {
    @FindBy(how = How.CSS, using = "table > tbody > tr")
    private List<WebElement> CURRENCY_ROWS;

    public RankingTableRows(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public LinkedList<CurrencyRowElement> getDisplayedCurrencies() {

        List<WebElement> currencyRowsWebElement = CURRENCY_ROWS;
        LinkedList<CurrencyRowElement> currenciesRows = new LinkedList<>();

        for (WebElement currencyRow : currencyRowsWebElement) {
            currenciesRows.add(new CurrencyRowElement(currencyRow));
        }
        return currenciesRows;
    }

    public By getRowIdentifier(int rowIndex) {
        return By.cssSelector("table > tbody > tr:nth-child(" + rowIndex + ")");
    }

    public static class CurrencyRowElement {

        private final WebElement CURRENCY_ROW;
        private final By POSITION_ELEMENT = By.cssSelector("table > tbody > tr > td:nth-child(2) > p");
        private final By NAME_ELEMENT = By.cssSelector("table > tbody > tr > td:nth-child(3) > div > a");
        private final By PRICE_ELEMENT = By.cssSelector("table > tbody > tr > td:nth-child(4) > div > a > span");

        public CurrencyRowElement(WebElement currencyRow) {
            this.CURRENCY_ROW = currencyRow;
        }

        public By getPositionElement() { return POSITION_ELEMENT; }

        public String getPosition() { return CURRENCY_ROW.findElement(POSITION_ELEMENT).getText(); }

        public String getName() {
            return CURRENCY_ROW.findElement(NAME_ELEMENT).getAttribute("href");
        }

        public String getPrice() {
            return CURRENCY_ROW.findElement(PRICE_ELEMENT).getText();
        }
    }
}