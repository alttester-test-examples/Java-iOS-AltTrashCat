package altunity.alttrashcatj.pages;

import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;

public class GetAntoherChance extends BasePage{

    public AltUnityObject gameOverButton;
    public AltUnityObject premiumButton;
    public AltUnityObject availableCurrency;

    public GetAntoherChance(AltUnityDriver driver) {
        super(driver);

        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Game/DeathPopup/GameOver").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        this.gameOverButton = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Game/DeathPopup/ButtonLayout/Premium Button").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        this.premiumButton = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Game/DeathPopup/PremiumDisplay/PremiumOwnCount").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        this.availableCurrency = driver.waitForObject(params);
    }

    public boolean isDisplayed(){
        if(gameOverButton != null && premiumButton != null && availableCurrency != null)
            return true;
        return false;
    }

    public void pressGameOver(){
        gameOverButton.tap();
    }

    public void pressPremiumBotton(){
        premiumButton.tap();
    }
}
