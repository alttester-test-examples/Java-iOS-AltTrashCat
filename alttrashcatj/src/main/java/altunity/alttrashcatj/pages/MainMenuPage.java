package altunity.alttrashcatj.pages;

import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;

public class MainMenuPage extends BasePage{

    public AltUnityObject storeButton;
    public AltUnityObject leaderBoardButton;
    public AltUnityObject settingsButton;
    public AltUnityObject missionButton;
    public AltUnityObject runButton;
    public AltUnityObject characterName;
    public AltUnityObject themeName;

    public MainMenuPage(AltUnityDriver driver) {
        super(driver);

        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//UICamera/Loadout/StoreButton").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.storeButton = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//UICamera/Loadout/OpenLeaderboard").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.leaderBoardButton = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//UICamera/Loadout/SettingButton").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.settingsButton = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//UICamera/Loadout/MissionButton").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.missionButton = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//UICamera/Loadout/StartButton").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.runButton = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "CharName").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.characterName = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//UICamera/Loadout/ThemeZone").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(10).build();
        this.themeName = driver.waitForObject(params);
    }

    public boolean isDisplayed(){
        if(storeButton != null || leaderBoardButton != null || settingsButton != null || missionButton != null || runButton != null || characterName != null || themeName != null){
            return true;
        }
        return false;
    }

    public void pressRun(){
        runButton.tap();
    }
}
