package Test;

import Base.BasePage;
import Page.ElementSeleniumPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ElementalSeleniumTestPage extends BasePage {
    ElementSeleniumPage elementSeleniumPage;
    String expectedURL = "http://elementalselenium.com/";
    String expectedTittle = "Elemental Selenium";
    @Before
    public void setUpTestPage() {
        elementSeleniumPage = new ElementSeleniumPage();
    }
    // testiramo link ElementSelenium
    @Test
    public void elementalSeleniumLinkTest() {
        //klikcemo na link
        elementSeleniumPage.elmentalSeleniumClick();
        // prelazimo na novi TAB jer se link
        elementSeleniumPage.switchToNewTab();
        // proveravamo da li je URL
        assertEquals(expectedURL,driver.getCurrentUrl());
        // proveravamo da li se tittle pojavio
        assertTrue(elementSeleniumPage.elementalSeleniumTittle());
        // proveravamo da li je tittle sadrzi ocekivanu poruku
        assertEquals(expectedTittle, elementSeleniumPage.elementalseleniumGetText());
    }
}
