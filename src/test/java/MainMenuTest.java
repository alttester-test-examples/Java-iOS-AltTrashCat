//import altunity.alttrashcatj.configreader.PropFileReader;

import pages.MainMenuPage;
import com.alttester.AltDriver;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainMenuTest extends BaseTest{

    private static AltDriver altDriver;
    private static MainMenuPage mainMenuPage;

    @BeforeMethod
    public void setUp() throws IOException {
        altDriver = new AltDriver();

        mainMenuPage = new MainMenuPage(altDriver);
        mainMenuPage.loadScene();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        altDriver.stop();
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