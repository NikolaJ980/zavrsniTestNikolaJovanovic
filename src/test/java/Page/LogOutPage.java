package Page;

import Base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogOutPage extends BasePage {
    public LogOutPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[@href='/logout']")
    WebElement logOutField;

    public void logOutClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(logOutField)).click();
    }
}
