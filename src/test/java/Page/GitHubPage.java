package Page;

import Base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GitHubPage extends BasePage {
    public GitHubPage() {
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//img[@alt=\"Fork me on GitHub\"]")
    WebElement gitHubField;
    @FindBy(xpath = "(//summary[@class='btn-primary btn'])[1]")
    WebElement codeButton;
   @FindBy(css = "#cloud-tab")
   WebElement codeSpacesTab;
   @FindBy(css = ".mb-1")
   WebElement codeSpacesMessage;

    public void gitHubClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(gitHubField)).click();
    }
    public void codeButtonClick() {
       wdWait.until(ExpectedConditions.elementToBeClickable(codeButton)).click();
    }
    public void codeSpacesClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(codeSpacesTab)).click();
    }
    public boolean codeSpacesIsDisplay() {
        return wdWait.until(ExpectedConditions.visibilityOf(codeSpacesMessage)).isDisplayed();
    }
    public String codeSpacesText() {
        return wdWait.until(ExpectedConditions.visibilityOf(codeSpacesMessage)).getText();
    }


}
