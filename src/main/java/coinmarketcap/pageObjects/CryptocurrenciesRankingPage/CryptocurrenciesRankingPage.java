package coinmarketcap.pageObjects.CryptocurrenciesRankingPage;

import coinmarketcap.pageObjects.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;

public class CryptocurrenciesRankingPage extends BasePage {
    public static final String PAGE_HEADER_TEXT = "Today's Cryptocurrency Prices by Market Cap";

    public CryptocurrenciesRankingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
