package managers;

import coinmarketcap.testData.capturedData.RankingTableRows;

public class CapturedDataValidationManager {

    private RankingTableRows rankingTableRows;

    public RankingTableRows getRankingTableRows(){
        return (rankingTableRows == null) ? rankingTableRows = new RankingTableRows() : rankingTableRows;
    }
}
