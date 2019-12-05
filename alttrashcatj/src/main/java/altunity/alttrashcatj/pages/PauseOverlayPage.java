package altunity.alttrashcatj.pages;

import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;

public class PauseOverlayPage extends BasePage{

    public AltUnityObject resumeButton;
    public AltUnityObject mainMenuButton;
    public AltUnityObject title;

    public PauseOverlayPage(AltUnityDriver driver) {
        super(driver);
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Game/PauseMenu/Resume").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        this.resumeButton = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Game/PauseMenu/Exit").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        this.mainMenuButton = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Game/PauseMenu/Text").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        this.title = driver.waitForObject(params);
    }

    public boolean isDisplayed(){
        if(resumeButton != null && mainMenuButton != null && title != null){
            return true;
        }
        return false;
    }

    public void pressResume(){
        resumeButton.tap();
    }

    public void pressMainMenu(){
        mainMenuButton.tap();
    }
}
