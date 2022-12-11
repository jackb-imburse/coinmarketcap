package coinmarketcap.testData.dataTypes;


public class CryptoCurrency {
    public String position;
    public String name;
    public String price;

    public CryptoCurrency(String position, String name, String price) {
        this.position = position;
        this.name = name;
        this.price = price;
    }
}
