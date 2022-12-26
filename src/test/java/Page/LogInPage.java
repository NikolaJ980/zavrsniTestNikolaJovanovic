package Page;

import Base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LogInPage extends BasePage {
    public LogInPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="username")
    WebElement userNameField;
    @FindBy(id="password")
    WebElement passwordField;
    @FindBy(css = "button[type=\"submit\"]")
    WebElement submitButton;

    public void usenameInput(String userName) {
        wdWait.until(ExpectedConditions.visibilityOf(userNameField)).clear();
        userNameField.sendKeys(userName);
    }
    public void passwordInput(String password) {
        wdWait.until(ExpectedConditions.visibilityOf(passwordField)).clear();
        passwordField.sendKeys(password);
    }
    public void submitClick(){
        wdWait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

}
