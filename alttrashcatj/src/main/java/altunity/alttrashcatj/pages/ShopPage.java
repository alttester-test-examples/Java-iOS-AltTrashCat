package altunity.alttrashcatj.pages;

import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopPage extends BasePage {

    public AltUnityObject storeTitle;
    public AltUnityObject itemsButton;
    public AltUnityObject charactersButton;
    public AltUnityObject accessoriesButton;
    public AltUnityObject themesButton;
    public AltUnityObject premiumSection;
    public AltUnityObject coinSection;

    public AltUnityObject closeButton;

    public ShopPage(AltUnityDriver driver) {
        super(driver);
    }

    public void getStoreTitle() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/StoreTitle").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        storeTitle = getDriver().waitForObject(params);
    }

    public void getItemsButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/TabsSwitch/Item").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        itemsButton = getDriver().waitForObject(params);
    }

    public void getCharactersButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/TabsSwitch/Character").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        charactersButton = getDriver().waitForObject(params);
    }

    public void getAccessoriesButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/TabsSwitch/Accesories").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        accessoriesButton = getDriver().waitForObject(params);
    }

    public void getThemesButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/TabsSwitch/Themes").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        themesButton = getDriver().waitForObject(params);
    }

    public void getPremiumSection() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/Premium").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        premiumSection = getDriver().waitForObject(params);
    }

    public void getCoinSection() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/Premium").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        coinSection = getDriver().waitForObject(params);
    }

    public void getCloseButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/Button").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        closeButton = getDriver().waitForObject(params);
    }

    public boolean isDisplayedCorrectly(){
        if(storeTitle != null && itemsButton != null && charactersButton != null && accessoriesButton != null && themesButton != null && premiumSection != null && coinSection != null && closeButton != null){
            return true;
        }
        return false;
    }

    public Integer getShopItemCount(int itemIndex){

        AltFindObjectsParameters params = new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Icon/Count").build();
        List<AltUnityObject> shopItemsCounts = new ArrayList<>(Arrays.asList(getDriver().findObjectsWhichContains(params)));

        return Integer.parseInt(shopItemsCounts.get(itemIndex).getText());
    }

    public void clickBuyButton(int index){
        AltFindObjectsParameters params = new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//NamePriceButtonZone/PriceButtonZone/BuyButton").build();
        List<AltUnityObject> itemsBuyButtons = new ArrayList<>(Arrays.asList(getDriver().findObjectsWhichContains(params)));
        itemsBuyButtons.get(index).tap();
    }

    public void pressClose(){
        closeButton.tap();
    }
}
