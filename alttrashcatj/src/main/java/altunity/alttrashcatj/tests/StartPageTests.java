package altunity.alttrashcatj.tests;

import altunity.alttrashcatj.pages.MainMenuPage;
import altunity.alttrashcatj.pages.StartPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ro.altom.altunitytester.AltUnityDriver;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

public class StartPageTests {

    private static AltUnityDriver driver;
    private static StartPage startPage;
    private static MainMenuPage mainMenuPage;

    @BeforeClass
    public static void setUp() throws IOException {
        driver = new AltUnityDriver("127.0.0.1", 13000,";","&",true);
    }

    @Before
    public void loadLevel() throws Exception {
        driver.loadScene("Start");
        startPage = new StartPage(driver);
        mainMenuPage = new MainMenuPage(driver);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.stop();
        Thread.sleep(1000);
    }

    @Test
    public void testStartPageLoadedCorrectly(){
        assertTrue(startPage.isDisplayed());
    }

    @Test
    public void testStartButtonLoadMainMenu(){

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
