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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShopTests {

    private static AltUnityDriver driver;
    private static MainMenuPage mainMenuPage;
    private static ShopPage shopPage;

    private static void getAllObjectsShopPage(){
        shopPage.getStoreTitle();
        shopPage.getAccessoriesButton();
        shopPage.getCharactersButton();
        shopPage.getItemsButton();
        shopPage.getCloseButton();
        shopPage.getThemesButton();
        shopPage.getPremiumButton();
        shopPage.getCoinSection();
    }

    private static void getAllObjectsMainMenuPage(){
        mainMenuPage.setStoreButton();
        mainMenuPage.setThemeName();
        mainMenuPage.setSettingsButton();
        mainMenuPage.setRunButton();
        mainMenuPage.setMissionButton();
        mainMenuPage.setLeaderBoardButton();
        mainMenuPage.setCharacterName();
    }

    @BeforeClass
    public static void setUp() throws IOException {
        driver = new AltUnityDriver("192.168.11.209", 13000,";","&",true);
    }

    @Before
    public void loadLevel(){
        mainMenuPage = new MainMenuPage(driver);
        shopPage = new ShopPage(driver);
        shopPage.loadScene();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.stop();
        Thread.sleep(1000);
    }

    @Test
    public void ShopPageLoadedCorrectly(){
        getAllObjectsShopPage();
        assertTrue(shopPage.isDisplayedCorrectly());
        shopPage.pressClose();
    }

    @Test
    public void testShopPageCanBeClosed(){
        getAllObjectsShopPage();
        shopPage.pressClose();
        mainMenuPage.loadScene();
        getAllObjectsMainMenuPage();
        assertTrue(mainMenuPage.isDisplayed());
    }

    @Test
    public void testBuySomething(){
        getAllObjectsShopPage();
        shopPage.storeTitle.tap();
        int indexOfElement = 0;
        Integer beforeBuy = shopPage.getShopItemCount(indexOfElement);
        shopPage.clickBuyButton(0);
        Integer afterBuy = shopPage.getShopItemCount(indexOfElement);
        assertTrue(beforeBuy + 1 == afterBuy);

    }

    @Test
    public void testPremiumPopUpOpen(){
        shopPage.getPremiumButton();
        shopPage.pressPremiumPopUp();
        shopPage.getPopup();
        assertTrue(shopPage.checkPopupOpen());
    }

    @Test
    public void testPremiumPopUpClosed(){
        shopPage.getPremiumButton();
        shopPage.pressPremiumPopUp();
        shopPage.getPopup();
        shopPage.getClosePopupButton();
        shopPage.pressClosePremiumPopup();
        assertFalse(shopPage.checkPopupOpen());
    }
}
