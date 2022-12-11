package coinmarketcap.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ToolTip {

    @FindBy(how = How.CSS, using = "div.gv-close > svg > path")
    private WebElement CLOSE_TOOL_TIP_BUTTON;

    public ToolTip(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void closeToolTip() {
        CLOSE_TOOL_TIP_BUTTON.click();
    }
}
