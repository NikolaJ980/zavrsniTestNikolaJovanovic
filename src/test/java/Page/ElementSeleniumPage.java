package Page;

import Base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class ElementSeleniumPage extends BasePage {
    public ElementSeleniumPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[target=\"_blank\"]")
    WebElement elementalSeleniumLink;
    @FindBy(css = "h1")
    WebElement elementalseleniumText;

    public void elmentalSeleniumClick() {
        wdWait.until(ExpectedConditions.elementToBeClickable(elementalSeleniumLink)).click();
    }
    public void switchToNewTab() {
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> numTab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(numTab.get(1));
    }
    public boolean elementalSeleniumTittle() {
        return wdWait.until(ExpectedConditions.visibilityOf(elementalseleniumText)).isDisplayed();
    }
    public String elementalseleniumGetText() {
        return wdWait.until(ExpectedConditions.visibilityOf(elementalseleniumText)).getText();
    }


}
