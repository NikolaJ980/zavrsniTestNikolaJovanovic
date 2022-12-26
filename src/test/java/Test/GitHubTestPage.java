package Test;

import Base.BasePage;
import Page.GitHubPage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class GitHubTestPage extends BasePage {

    GitHubPage gitHubPage;
    String expectedURL = "https://github.com/saucelabs/the-internet";
    String cloudTabMessageText = "Sign In Required";
    @Before
    public void setUpTestpage() {
        gitHubPage = new GitHubPage();
    }
    // testiramo gitHub link
    @Test
    public void gitHubTestLink() {
        // klikcemo na link
        gitHubPage.gitHubClick();
        //klikcemo na code polje
        gitHubPage.codeButtonClick();
        // proveravamo URL
        assertEquals(expectedURL, driver.getCurrentUrl());
        // klikcemo na codespaces tab u okviru code kartice
        gitHubPage.codeSpacesClick();
        // proveravamo da li se poruka pojavila
        assertTrue(gitHubPage.codeSpacesIsDisplay());
        // proveravamo da le je poruka ona koju smo ocekivali
        assertEquals(cloudTabMessageText, gitHubPage.codeSpacesText());

    }
}
