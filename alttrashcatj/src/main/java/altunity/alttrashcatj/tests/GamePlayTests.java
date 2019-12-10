package altunity.alttrashcatj.tests;

import altunity.alttrashcatj.pages.*;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ro.altom.altunitytester.AltUnityDriver;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class GamePlayTests {

    private static AltUnityDriver driver;
    private static MainMenuPage mainMenuPage;
    private static PauseOverlayPage pauseOverlayPage;
    private static GetAntoherChancePage getAntoherChancePage;
    private static GamePlayPage gamePlayPage;

    @BeforeClass
    public static void setUp() throws IOException {
        driver = new AltUnityDriver("127.0.0.1", 13000,";","&",true);
    }

    @Before
    public void loadLevel() throws Exception {

        mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.loadScene();
        mainMenuPage.setCharacterName();
        mainMenuPage.setLeaderBoardButton();
        mainMenuPage.setMissionButton();
        mainMenuPage.setRunButton();
        mainMenuPage.setSettingsButton();
        mainMenuPage.setStoreButton();
        mainMenuPage.setThemeName();

        gamePlayPage = new GamePlayPage(driver);
        pauseOverlayPage = new PauseOverlayPage(driver);
        getAntoherChancePage = new GetAntoherChancePage(driver);
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.stop();
        Thread.sleep(1000);
    }

    @Test
    public void testGamePlayDisplayedCorrectly(){
        mainMenuPage.pressRun();
        gamePlayPage.setPauseButton();
        gamePlayPage.setCharacter();
        assertTrue(gamePlayPage.isDisplayed());
    }

    @Test
    public void testGameCanBePausedAndResumed(){
        mainMenuPage.pressRun();
        gamePlayPage.setCharacter();
        gamePlayPage.setPauseButton();
        gamePlayPage.pressPause();


        pauseOverlayPage.getTitle();
        pauseOverlayPage.getMainMenuButton();
        pauseOverlayPage.getResumeButton();

        assertTrue(pauseOverlayPage.isDisplayed());

        pauseOverlayPage.pressResume();
        assertTrue(gamePlayPage.isDisplayed());
    }
}
