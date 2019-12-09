package altunity.alttrashcatj.pages;

import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;

public class StartPage extends BasePage{

    public AltUnityObject startButton;
    public AltUnityObject startText;
    public AltUnityObject logoImage;
    public AltUnityObject unityUrlButton;

    public StartPage(AltUnityDriver driver) {
        super(driver);

        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "StartButton").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        this.startButton = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "StartText").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        this.startText = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "LogoImage").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        this.logoImage = driver.waitForObject(params);

        par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "UnityURLButton").build();
        params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        this.unityUrlButton = driver.waitForObject(params);
    }

    public boolean isDisplayed(){
        if(startButton != null && startText != null && logoImage != null && unityUrlButton != null){
            return true;
        }
        return false;
    }

    public void load(){
        getDriver().loadScene("Start");
    }

    public void pressStart(){
        startButton.tap();
    }

    public String getStartingButtonText(){
        return startButton.getText();
    }
}
