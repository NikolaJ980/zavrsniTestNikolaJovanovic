package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static WebDriver driver;
    public static WebDriverWait wdWait;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wdWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();

    }
    @After
    public void tearDown(){
        // TODO odkomentarisi narednu liniju koda kada tekstovi budu zavrseni
        // driver.quit();
    }
}
