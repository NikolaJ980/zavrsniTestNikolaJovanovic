package Page;

import Base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MessagesPage extends BasePage {
    public MessagesPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(id="flash")
    WebElement successfulLogInMessages;
    @FindBy(css = ".subheader")
    WebElement welcomeMessages;
    @FindBy(xpath = "//h2")
    WebElement loginPageTittle;

    public boolean successfulMessageIsDisplay() {
        return wdWait.until(ExpectedConditions.visibilityOf(successfulLogInMessages)).isDisplayed();
    }
    public String successfulMessageGetText() {
        return wdWait.until(ExpectedConditions.visibilityOf(successfulLogInMessages)).getText();
    }
    public boolean welcomeMessagesIsDisplay() {
        return wdWait.until(ExpectedConditions.visibilityOf(welcomeMessages)).isDisplayed();
    }
    public String welcomeMessagesGetText() {
        return wdWait.until(ExpectedConditions.visibilityOf(welcomeMessages)).getText();
    }
    public boolean loginPageTittleIsDisplay() {
        return wdWait.until(ExpectedConditions.visibilityOf(loginPageTittle)).isDisplayed();
    }
    public String loginPageTittleGetText() {
        return wdWait.until(ExpectedConditions.visibilityOf(loginPageTittle)).getText();
    }


}
