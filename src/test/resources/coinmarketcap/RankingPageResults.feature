@UI
Feature: Filtering results shown on cryptocurrencies ranking page
  User can filter the results shown on the curptocurrencies ranking page

  Scenario: User can set number of displayed rows and apply filters on cryptocurrencies ranking page
    Given I access coinmarketcap.com
    And I view the ranking data when showing the first 20 rows
    When I filter by algorithm PoW
    And I add more filters options Mineable, Coins and Price between 100 and 10000
    Then the ranking data is filtered