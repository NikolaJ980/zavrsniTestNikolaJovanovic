package Test;

import Base.BasePage;
import Page.LogInPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import Page.MessagesPage;
import org.junit.Before;
import org.junit.Test;

public class SuccessfulLogInPage extends BasePage {

    LogInPage logInPage;
    MessagesPage messagesPage;

    String welkomMess = "Welcome to the Secure Area. When you are done click logout below.";
    String successfulMess = "You logged into a secure area!\n" + "×";
    String userName = "tomsmith";
    String password = "SuperSecretPassword!";



    @Before
    public void setUpTestPage() {
        logInPage = new LogInPage();
        messagesPage = new MessagesPage();
    }
    // uspesan login
    @Test
    public void successfulLogIn() {
        // upisujemo ispravan username
        logInPage.usenameInput(userName);
        // upisujemo ispravan password
        logInPage.passwordInput(password);
        // klikcemo na submit dugme
        logInPage.submitClick();
        // proveravamo da li je poruka o uspesnom login-u prikazana
        assertTrue(messagesPage.successfulMessageIsDisplay());
        // proveramo da li je prikazana poruka ona koju ocekujemo
        assertEquals(successfulMess, messagesPage.successfulMessageGetText());
        // proveravamo da li je poruka sa dobrodoslicom prikazana
        assertTrue(messagesPage.welcomeMessagesIsDisplay());
        // proveravamo da li je prikazana poruka dobrodoslice ona koju ocekujemo
        assertEquals(welkomMess, messagesPage.welcomeMessagesGetText());
        String actualUrl = driver.getCurrentUrl();
        assertEquals("https://the-internet.herokuapp.com/secure", actualUrl);
        System.out.println("URL matching --> Part executed");
    }
}
