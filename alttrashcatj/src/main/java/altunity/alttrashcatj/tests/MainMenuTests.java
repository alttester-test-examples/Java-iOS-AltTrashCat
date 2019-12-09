package altunity.alttrashcatj.tests;

import altunity.alttrashcatj.pages.MainMenuPage;
import org.junit.*;
import ro.altom.altunitytester.AltUnityDriver;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class MainMenuTests {

    private static AltUnityDriver driver;
    private static MainMenuPage mainMenuPage;

    @BeforeClass
    public static void setUp() throws IOException {
        driver = new AltUnityDriver("127.0.0.1", 13000);
        mainMenuPage = new MainMenuPage(driver);

        mainMenuPage.setCharacterName();
        mainMenuPage.setLeaderBoardButton();
        mainMenuPage.setMissionButton();
        mainMenuPage.setRunButton();
        mainMenuPage.setSettingsButton();
        mainMenuPage.setStoreButton();
        mainMenuPage.setThemeName();
    }

    @Before
    public void loadLevel() throws Exception {

        mainMenuPage.loadScene();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.stop();
        Thread.sleep(1000);
    }


    @Test
    public void TestMainPageLoadedCorrectly(){
        assertTrue(mainMenuPage.isDisplayed());
    }

}
