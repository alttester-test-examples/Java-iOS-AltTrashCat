package altunity.alttrashcatj.pages;

import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;

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
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        storeTitle = getDriver().waitForObject(params);
    }

    public void getItemsButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/TabsSwitch/Item").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        itemsButton = getDriver().waitForObject(params);
    }

    public void getCharactersButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/TabsSwitch/Character").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        charactersButton = getDriver().waitForObject(params);
    }

    public void getAccessoriesButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/TabsSwitch/Accesories").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        accessoriesButton = getDriver().waitForObject(params);
    }

    public void getThemesButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/TabsSwitch/Themes").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        themesButton = getDriver().waitForObject(params);
    }

    public void getPremiumSection() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/Premium").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        premiumSection = getDriver().waitForObject(params);
    }

    public void getCoinSection() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/Premium").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        coinSection = getDriver().waitForObject(params);
    }

    public void getCloseButton() {
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Background/Button").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        closeButton = getDriver().waitForObject(params);
    }

    public boolean isDisplayedCorrectly(){
        if(storeTitle != null && itemsButton != null && charactersButton != null && accessoriesButton != null && themesButton != null && premiumSection != null && coinSection != null && closeButton != null){
            return true;
        }
        return false;
    }

    public void load(){
        getDriver().loadScene("Shop");
    }

    public void pressClose(){
        closeButton.tap();
    }
}
