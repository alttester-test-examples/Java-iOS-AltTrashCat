package altunity.alttrashcatj.tests;

import altunity.alttrashcatj.configreader.PropFileReader;
import altunity.alttrashcatj.pages.MainMenuPage;
import altunity.alttrashcatj.pages.StartPage;
import org.junit.*;
import ro.altom.altunitytester.AltUnityDriver;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class MainMenuTests {

    private static AltUnityDriver driver;
    private static StartPage startPage;
    private static MainMenuPage mainMenuPage;

    @BeforeClass
    public static void setUp() throws IOException {
        PropFileReader properties = new PropFileReader();
        driver = new AltUnityDriver(properties.getDeviceIP(), 13000,";","&",true);
    }

    @Before
    public void loadLevel(){
        mainMenuPage = new MainMenuPage(driver);
        mainMenuPage.loadScene();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.stop();
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
