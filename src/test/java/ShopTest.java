
import pages.*;
import com.alttester.AltDriver;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShopTest extends BaseTest{

    private static AltDriver altDriver;
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

    @BeforeMethod
    public void setUp() throws IOException {
        altDriver = new AltDriver();
        mainMenuPage = new MainMenuPage(altDriver);
        shopPage = new ShopPage(altDriver);
        shopPage.loadScene();
    }


    @AfterMethod
    public void tearDown() throws Exception {
        altDriver.stop();
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