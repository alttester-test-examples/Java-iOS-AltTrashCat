//import altunity.alttrashcatj.configreader.PropFileReader;

import pages.MainMenuPage;
import ro.altom.altunitytester.AltUnityDriver;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainMenuTest extends BaseTest{

    private static AltUnityDriver altUnityDriver;
    private static MainMenuPage mainMenuPage;

    @BeforeMethod
    public void setUp() throws IOException {
        altUnityDriver = new AltUnityDriver();

        mainMenuPage = new MainMenuPage(altUnityDriver);
        mainMenuPage.loadScene();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        altUnityDriver.stop();
        Thread.sleep(1000);
    }

    @Test
    public void TestMainPageLoadedCorrectly(){

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