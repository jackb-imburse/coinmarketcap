package managers;

import org.openqa.selenium.WebDriver;
import coinmarketcap.pageObjects.CryptocurrenciesRankingPage.CryptocurrenciesRankingPage;

public class PageObjectManager {

    private final WebDriver driver;
    private CryptocurrenciesRankingPage cryptocurrenciesRankingPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public CryptocurrenciesRankingPage getCryptocurrenciesRankingPage(){
        return (cryptocurrenciesRankingPage == null) ? cryptocurrenciesRankingPage = new CryptocurrenciesRankingPage(driver) : cryptocurrenciesRankingPage;
    }
}
