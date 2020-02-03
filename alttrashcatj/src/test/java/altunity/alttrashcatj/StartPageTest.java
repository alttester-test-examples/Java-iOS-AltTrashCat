package altunity.alttrashcatj;

import altunity.alttrashcatj.configreader.PropFileReader;
import altunity.alttrashcatj.pages.MainMenuPage;
import altunity.alttrashcatj.pages.StartPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ro.altom.altunitytester.AltUnityDriver;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

public class StartPageTest {

    private static AltUnityDriver driver;
    private static StartPage startPage;
    private static MainMenuPage mainMenuPage;

    @BeforeClass
    public static void setUp() throws IOException {
        PropFileReader properties = new PropFileReader();
        driver = new AltUnityDriver(properties.getDeviceIP(), 13000,";","&",true);
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
