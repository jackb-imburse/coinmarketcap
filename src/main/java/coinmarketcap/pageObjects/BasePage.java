package coinmarketcap.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BasePage {

    @FindBy(how = How.CSS, using = "h1")
    private WebElement PAGE_HEADER_IDENTIFIER;

    public String getPageHeader() {
        return PAGE_HEADER_IDENTIFIER.getText();
    }
}