# Coin Market Cap

CoinMarketCap is the world's most-referenced price-tracking website for cryptoassets. 

This repository is a UI and API end-to-end test suite for CoinMarketCap.

## Installation

Java 17 https://adoptium.net/en-GB/marketplace/

Maven https://maven.apache.org/install.html

Chrome web-browser and Chromedriver https://chromedriver.chromium.org/downloads

## Executing Test

Tests are written in Gherkin syntax using Cucumber. 

The .feature files containing test scenarios are found in path /src/test/resources

### Execute all tests

```bash
mvn verify
```

### Execute targeted tests using Cucumber tags
```bash
mvn verify -DexcludedGroups="Ignore" -Dgroups="Smoke | Sanity"
```

## Test execution results and report

The console output will show the high level results of a test run
```
[INFO] Results:
[INFO] 
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
```

A link to a Cucumber report is also shown in the console output, example output

```
┌──────────────────────────────────────────────────────────────────────────┐
│ View your Cucumber Report at:                                            │
│ https://reports.cucumber.io/reports/3a51f87f-161b-4d51-a1f6-456aeb21368d │
│                                                                          │
│ This report will self-destruct in 24h.                                   │
│ Keep reports forever: https://reports.cucumber.io/profile                │
└──────────────────────────────────────────────────────────────────────────┘[
```

