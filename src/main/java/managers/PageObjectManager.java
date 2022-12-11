package managers;

import coinmarketcap.pageObjects.CryptocurrenciesRankingPage.CryptocurrenciesRankingPage;
import coinmarketcap.pageObjects.CryptocurrenciesRankingPage.MoreFiltersModal;
import coinmarketcap.pageObjects.CryptocurrenciesRankingPage.RankingTableRows;
import coinmarketcap.pageObjects.ToolTip;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private final WebDriver driver;
    private CryptocurrenciesRankingPage cryptocurrenciesRankingPage;
    private ToolTip toolTip;
    private MoreFiltersModal moreFiltersModal;
    private RankingTableRows rankingTableRows;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public CryptocurrenciesRankingPage getCryptocurrenciesRankingPage(){
        return (cryptocurrenciesRankingPage == null) ? cryptocurrenciesRankingPage = new CryptocurrenciesRankingPage(driver) : cryptocurrenciesRankingPage;
    }

    public ToolTip getToolTip() {
        return (toolTip == null) ? toolTip = new ToolTip(driver) : toolTip;
    }

    public MoreFiltersModal getMoreFiltersModal() {
        return (moreFiltersModal == null) ? moreFiltersModal = new MoreFiltersModal(driver) : moreFiltersModal;
    }

    public RankingTableRows getRankingTableRows() {
        return (rankingTableRows == null) ? rankingTableRows = new RankingTableRows(driver) : rankingTableRows;
    }
}
