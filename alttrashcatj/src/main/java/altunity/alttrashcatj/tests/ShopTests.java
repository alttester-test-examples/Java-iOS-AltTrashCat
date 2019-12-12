package altunity.alttrashcatj.tests;

import altunity.alttrashcatj.pages.MainMenuPage;
import altunity.alttrashcatj.pages.ShopPage;
import altunity.alttrashcatj.pages.StartPage;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ro.altom.altunitytester.AltUnityDriver;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class ShopTests {

    private static AltUnityDriver driver;
    private static MainMenuPage mainMenuPage;
    private static ShopPage shopPage;
    private static StartPage startPage;

    @BeforeClass
    public static void setUp() throws IOException {
        driver = new AltUnityDriver("127.0.0.1", 13000,";","&",true);
    }

    @Before
    public void loadLevel(){
        mainMenuPage = new MainMenuPage(driver);
        shopPage = new ShopPage(driver);
        startPage = new StartPage(driver);
        //mainMenuPage.loadScene();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.stop();
        Thread.sleep(1000);
    }

    @Test
    public void ShopPageLoadedCorrectly(){
        startPage.getStartButton();
        startPage.pressStart();

        mainMenuPage.setStoreButton();
        mainMenuPage.pressStore();

        shopPage.getStoreTitle();
        shopPage.getAccessoriesButton();
        shopPage.getCharactersButton();
        shopPage.getItemsButton();
        shopPage.getCloseButton();
        shopPage.getThemesButton();
        shopPage.getPremiumSection();
        shopPage.getCoinSection();

        assertTrue(shopPage.isDisplayedCorrectly());
    }

}
