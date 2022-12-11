package cucumber;

import managers.CapturedDataValidationManager;
import managers.PageObjectManager;
import managers.WebDriverManager;

public class TestContext {
    private final WebDriverManager webDriverManager;
    private final PageObjectManager pageObjectManager;
    private final CapturedDataValidationManager capturedDataValidationManager;

    public TestContext(){
        webDriverManager = new WebDriverManager();
        pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
        capturedDataValidationManager = new CapturedDataValidationManager();
    }

    public WebDriverManager getWebDriverManager() {
        return webDriverManager;
    }

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public CapturedDataValidationManager getCapturedDataValidationManager() { return capturedDataValidationManager; }

}
