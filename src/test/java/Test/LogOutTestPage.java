package Test;

import Base.BasePage;
import Page.LogInPage;
import Page.LogOutPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Page.MessagesPage;
import org.junit.Before;
import org.junit.Test;

public class LogOutTestPage extends BasePage {

    LogOutPage logOutPage;
    MessagesPage messagesPage;
    LogInPage logInPage;
    String userName = "tomsmith";
    String password = "SuperSecretPassword!";
    String successfulMessLogOut = "You logged out of the secure area!\n" + "×";
    String loginPageText = "Login Page";

    @Before
    public void setUpTestPage() {
        logOutPage = new LogOutPage();
        logInPage = new LogInPage();
        messagesPage = new MessagesPage();
    }
    // test uspesnog logout-a
    @Test
    public void logOut() {
        // unosimo ispravan username
        logInPage.usenameInput(userName);
        // unosimo ispravan password
        logInPage.passwordInput(password);
        // klikcemo na submit dugme
        logInPage.submitClick();
        // klikcemo na logout dugme
        logOutPage.logOutClick();
        // proveravamo da li je poruka o uspesnom loguot-u prikazana
        assertTrue(messagesPage.successfulMessageIsDisplay());
        // proveravamo da li je prikazana poruka ona koju ocekujemo
        assertEquals(successfulMessLogOut, messagesPage.successfulMessageGetText());
        // proveravamo da li je prikazan tekst Login Page
        assertTrue(messagesPage.loginPageTittleIsDisplay());
        // proveravamo da li je prikazani tekst onaj koji ocekujemo
        assertEquals(loginPageText, messagesPage.loginPageTittleGetText());

    }

}
