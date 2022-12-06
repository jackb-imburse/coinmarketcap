@UI
Feature: User access to coinmarketcap.com
  Accessing coinmarketcap.com will take user to the curptocurrencies ranking page

  @Smoke
  Scenario: Cryptocurrencies ranking page displayed when accessing coinmarketcap.com
    Given I access coinmarketcap.com
    Then the cryptocurriencies ranking page is displayed
