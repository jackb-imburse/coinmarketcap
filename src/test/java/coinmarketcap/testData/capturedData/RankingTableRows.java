package coinmarketcap.testData.capturedData;

import coinmarketcap.testData.dataTypes.CryptoCurrency;

import java.util.LinkedList;

public class RankingTableRows {

    public int maxDisplayRowCount;
    public int priceRangeMinimumValue;
    public int priceRangeMaximumValue;
    public LinkedList<CryptoCurrency> currencies;

    public RankingTableRows() {
        currencies = new LinkedList<>();
    }

    public void setMaxDisplayRowCount(int maxDisplayRowCount) {
        this.maxDisplayRowCount = maxDisplayRowCount;
    }

    public int getMaxDisplayedRowCount() {
        return maxDisplayRowCount;
    }

    public void setPriceRangeMinimumValue(int priceRangeMinimumValue) {
        this.priceRangeMinimumValue = priceRangeMinimumValue;
    }
    public int getPriceRangeMinimumValue() {
        return priceRangeMinimumValue;
    }

    public void setPriceRangeMaximumValue(int priceRangeMaximumValue) {
        this.priceRangeMaximumValue = priceRangeMaximumValue;
    }

    public int getPriceRangeMaximumValue() {
        return priceRangeMaximumValue;
    }
}
