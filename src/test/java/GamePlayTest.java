
import pages.*;

import ro.altom.altunitytester.AltUnityDriver;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GamePlayTest extends BaseTest {

    private static AltUnityDriver altUnityDriver;
    private static MainMenuPage mainMenuPage;
    private static PauseOverlayPage pauseOverlayPage;
    private static GetAnotherChancePage getAntoherChancePage;
    private static GamePlayPage gamePlayPage;

    @BeforeMethod
    public void setUp() throws IOException {
        altUnityDriver = new AltUnityDriver();
        
        mainMenuPage = new MainMenuPage(altUnityDriver);
        mainMenuPage.loadScene();
        mainMenuPage.setCharacterName();
        mainMenuPage.setLeaderBoardButton();
        mainMenuPage.setMissionButton();
        mainMenuPage.setRunButton();
        mainMenuPage.setSettingsButton();
        mainMenuPage.setStoreButton();
        mainMenuPage.setThemeName();

        gamePlayPage = new GamePlayPage(altUnityDriver);
        pauseOverlayPage = new PauseOverlayPage(altUnityDriver);
        getAntoherChancePage = new GetAnotherChancePage(altUnityDriver);
    
    }

    @AfterMethod
    public void tearDown() throws Exception {
        altUnityDriver.stop();
        Thread.sleep(1000);
    }

    @Test
    public void testGamePlayDisplayedCorrectly(){
        mainMenuPage.pressRun();
        gamePlayPage.getPauseButton();
        gamePlayPage.getCharacter();
        assertTrue(gamePlayPage.isDisplayed());
    }

    @Test
    public void testGameCanBePausedAndResumed(){
        mainMenuPage.pressRun();
        gamePlayPage.getCharacter();
        gamePlayPage.getPauseButton();
        gamePlayPage.pressPause();
        pauseOverlayPage.getTitle();
        pauseOverlayPage.getMainMenuButton();
        pauseOverlayPage.getResumeButton();
        assertTrue(pauseOverlayPage.isDisplayed());
        pauseOverlayPage.pressResume();
        assertTrue(gamePlayPage.isDisplayed());
    }

    @Test
    public void testGameCanBePausedAndStopped(){
        mainMenuPage.pressRun();
        gamePlayPage.getCharacter();
        gamePlayPage.getPauseButton();
        gamePlayPage.pressPause();
        pauseOverlayPage.getTitle();
        pauseOverlayPage.getMainMenuButton();
        pauseOverlayPage.getResumeButton();
        pauseOverlayPage.pressMainMenu();
        assertTrue(mainMenuPage.isDisplayed());
    }

    @Test
    public void testAvoidingObstacles() throws Exception {
        mainMenuPage.pressRun();
        gamePlayPage.getCharacter();
        gamePlayPage.getPauseButton();
        gamePlayPage.avoidObstacles(0);
        assertTrue(gamePlayPage.getCurrentLife()>=0);
    }

    @Test
    public void testPlayerDiesWhenObstacleNotAvoided() throws Exception {

        mainMenuPage.pressRun();
        gamePlayPage.getCharacter();
        gamePlayPage.getPauseButton();

        float timeout = 20;
        while(timeout>0){
            try {
                getAntoherChancePage.getGameOver();
                getAntoherChancePage.getAvailableCurrency();
                getAntoherChancePage.getPremiumButton();
                getAntoherChancePage.isDisplayed();
                break;
            }catch(Exception e){
                timeout -= 1;
            }
        }

        assertTrue(getAntoherChancePage.isDisplayed());

    }
}
