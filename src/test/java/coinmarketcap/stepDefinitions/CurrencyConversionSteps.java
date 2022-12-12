package coinmarketcap.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.config.JsonPathConfig;
import io.restassured.response.Response;

import java.math.BigDecimal;

public class CurrencyConversionSteps {
    Header header = new Header("X-CMC_PRO_API_KEY", "df1be128-1e47-45d5-8625-9f0ac40795ea");

    int amountGTQ;
    BigDecimal amountGBP;
    BigDecimal amountDogeCoin;

    @Given("I convert {int} Guatemalan Quetzal into Pound Sterling")
    public void convertGuatemalanQuetzalIntoPoundSterling(int amount) {

        amountGTQ = amount;

        JsonPath.config = new JsonPathConfig().numberReturnType(JsonPathConfig.NumberReturnType.BIG_DECIMAL);

        Response response = given()
                .header(header)
                .when()
                .get("https://pro-api.coinmarketcap.com/v2/tools/price-conversion?convert_id=2791&id=3541&amount=" + amount);

        assertThat(response.statusCode()).isEqualTo(200);
        amountGBP = response.jsonPath(JsonPath.config).get("data.quote.2791.price");
        assertThat(amountGBP).isNotNull();
    }

    @Then("I can convert the converted amount in Pound Sterling into Doge Coin")
    public void convertConvertedPoundSterlingIntoDogeCoin() {

        if (amountGBP == null) {
            throw new Error("Converted amount in Pound Sterling not recorded");
        }

        Response response = given()
                .header(header)
                .when()
                .get("https://pro-api.coinmarketcap.com/v2/tools/price-conversion?convert_id=74&id=2791&amount=1031015");

        assertThat(response.statusCode()).isEqualTo(200);
        amountDogeCoin = response.jsonPath(JsonPath.config).get("data.quote.74.price");
        assertThat(amountDogeCoin).isNotNull();

        System.out.println("Guatemalan Quetzal: " + amountGTQ);
        System.out.println("Pound Sterling: " + amountGBP);
        System.out.println("Doge Coin: " + amountDogeCoin);
    }
}
