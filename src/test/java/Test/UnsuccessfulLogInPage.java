package Test;

import Base.BasePage;
import Page.LogInPage;
import Page.MessagesPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class UnsuccessfulLogInPage extends BasePage {

    LogInPage logInPage;
    MessagesPage messagesPage;
    String wrongName = "petar";
    String userName = "tomsmith";
    String wrongPass = "12345678";
    String password = "SuperSecretPassword!";
    String errorMessagesUserName = "Your username is invalid!\n" + "×";
    String errorMessagesPassword = "Your password is invalid!\n" + "×";
    @Before
    public void setUpTestPage() {
        logInPage = new LogInPage();
        messagesPage = new MessagesPage();
    }
    // pokusaj logIn sa pogresnim userName a ispravnim password-om
    @Test
    public void wrongUserName() {
        // unosimo neispravan username
        logInPage.usenameInput(wrongName);
        // unosimo ispravan password
        logInPage.passwordInput(password);
        //klikcemo na submit dugme
        logInPage.submitClick();
        // proveravamo da li je poruka o pogresnom username prikazana
        assertTrue(messagesPage.successfulMessageIsDisplay());
        // proveravamo da li je prikazana poruka ona koju ocekujemo
        assertEquals(errorMessagesUserName, messagesPage.successfulMessageGetText());
    }
    // pokusaj login sa ispravnim username a pogresnim password-om
    @Test
    public void wrongPassword() {
        // unosimo ispravan username
        logInPage.usenameInput(userName);
        // unosimo neispravan password
        logInPage.passwordInput(wrongPass);
        // klikcemo na submit dugme
        logInPage.submitClick();
        // proveravamo da li je prikazana poruka o neispravnom password-u
        assertTrue(messagesPage.successfulMessageIsDisplay());
        // proveravamo da li je prikazana poruka ona koju ocekujemo
        assertEquals(errorMessagesPassword, messagesPage.successfulMessageGetText());
    }
    // pokusaj login sa neispravnim username i password-om
    // (prikazuje poruku da nije ispravan username, smatram da bi poruka trebala da sadrzi i da je pogresan password unet)
    @Test
    public void wrongUserNamePassword() {
        // unosimo pogresan username
        logInPage.usenameInput(wrongName);
        // unosimo pogresan password
        logInPage.passwordInput(wrongPass);
        // klikcemo na submit dugme
        logInPage.submitClick();
        // proveravamo da li je prikazana poruka o neispravnom username i password-u
        assertTrue(messagesPage.successfulMessageIsDisplay());
        // proveravamo da li je prikazana poruka ona koju ocekujemo
        assertEquals(errorMessagesUserName, messagesPage.successfulMessageGetText());

    }
    // pokusaj login sa praznim poljem username i ispravnim password-om

    @Test
    public void emptyUserName() {
        // ostavljamo prazno polje username
        logInPage.usenameInput(" ");
        // popunjavamo ispravan password
        logInPage.passwordInput(password);
        // klikcemo na submit dugme
        logInPage.submitClick();
        // proveravamo da li je prikazana poruka da je username polje prazno i da ga treba popuniti
        assertTrue(messagesPage.successfulMessageIsDisplay());
        // proveravamo da li je prikazana poruka ona koju ocekujemo
        assertEquals(errorMessagesUserName, messagesPage.successfulMessageGetText());

    }
    // pokusaj login sa praznim password poljem i ispravnim username
    @Test
    public void emptyPassword() {
        // upisujemo ispravan username
        logInPage.usenameInput(" ");
        // ostavljamo prazno polje password
        logInPage.passwordInput(password);
        // klikcemo na submit dugme
        logInPage.submitClick();
        // proveravamo da li je prikazana poruka da je password polje prazno i da ga treba popuniti
        assertTrue(messagesPage.successfulMessageIsDisplay());
        // proveravamo da li je prikazana poruka ona koju ocekujemo
        assertEquals(errorMessagesUserName, messagesPage.successfulMessageGetText());

    }
    // pokusaj login sa praznim poljima
    // (prikazuje poruku da nije ispravan username, smatram da bi poruka trebala da obavestava da polja nisu popunjena)
    @Test
    public void emptyField() {
        // ostavljamo prazno polje username
        logInPage.usenameInput(" ");
        // ostavljamo prazno polje password
        logInPage.passwordInput(" ");
        // klikcemo na submit dugme
        logInPage.submitClick();
        // proveravamo da li je prikazana poruka da su polja prazna i da ih treba popuniti
        assertTrue(messagesPage.successfulMessageIsDisplay());
        // proveravamo da li je prikazana poruka ona koju ocekujemo
        assertEquals(errorMessagesUserName, messagesPage.successfulMessageGetText());
    }

}
