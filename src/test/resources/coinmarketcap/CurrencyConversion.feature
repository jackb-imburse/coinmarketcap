@API
Feature: Convert Currencies
  Price conversion API can be used to convert values between currencies

  @Smoke
  Scenario: Convert value between fiat currencies and then into cryptocurrency
    Given I convert 10000000 Guatemalan Quetzal into Pound Sterling
    Then I can convert the converted amount in Pound Sterling into Doge Coin