
import pages.*;
import ro.altom.altunitytester.AltUnityDriver;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StartPageTest extends BaseTest{

    private AltUnityDriver altUnityDriver;
    private StartPage startPage;
    private MainMenuPage mainMenuPage;

    @BeforeMethod
    public void setUp() throws IOException {
        altUnityDriver = new AltUnityDriver();

        startPage = new StartPage(altUnityDriver);
        mainMenuPage = new MainMenuPage(altUnityDriver);
        startPage.load();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        altUnityDriver.stop();
        Thread.sleep(1000);
    }

    @Test
    public void testStartPageLoadedCorrectly() {
        startPage.load();
        startPage.getUnityURLButton();
        startPage.getLogoImage();
        startPage.getStartText();
        startPage.getStartButton();
        assertTrue(startPage.isDisplayed());
    }

    @Test
    public void testStartButtonLoadMainMenu(){

        startPage.getUnityURLButton();
        startPage.getLogoImage();
        startPage.getStartText();
        startPage.getStartButton();
        startPage.pressStart();

        mainMenuPage.setCharacterName();
        mainMenuPage.setLeaderBoardButton();
        mainMenuPage.setMissionButton();
        mainMenuPage.setRunButton();
        mainMenuPage.setSettingsButton();
        mainMenuPage.setStoreButton();
        mainMenuPage.setThemeName();

        assertTrue(mainMenuPage.isDisplayed());
    }
}