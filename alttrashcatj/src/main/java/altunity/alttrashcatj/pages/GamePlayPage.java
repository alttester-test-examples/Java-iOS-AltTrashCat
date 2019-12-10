package altunity.alttrashcatj.pages;

import ro.altom.altunitytester.AltUnityDriver;
import ro.altom.altunitytester.AltUnityObject;
import ro.altom.altunitytester.Commands.FindObject.AltFindObjectsParameters;
import ro.altom.altunitytester.Commands.FindObject.AltWaitForObjectsParameters;
import ro.altom.altunitytester.Commands.OldFindObject.AltWaitForElementParameters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamePlayPage extends BasePage {

    public AltUnityObject pauseButton;
    public AltUnityObject character;

    public GamePlayPage(AltUnityDriver driver) {
        super(driver);

    }

    public void setPauseButton(){
        AltFindObjectsParameters par=new AltFindObjectsParameters.Builder(AltUnityDriver.By.PATH, "//Game/WholeUI/pauseButton").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).withTimeout(2).build();
        pauseButton = getDriver().waitForObject(params);
    }

    public void setCharacter(){
        AltFindObjectsParameters par = new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "PlayerPivot").build();
        AltWaitForObjectsParameters params = new AltWaitForObjectsParameters.Builder(par).build();
        this.character = getDriver().waitForObject(params);
    }

    public boolean isDisplayed(){
        if(pauseButton != null && character != null){
            return true;
        }
        return false;
    }

    public void pressPause(){
        pauseButton.tap();
    }

    public int getCurrentLife() throws Exception {
        return Integer.parseInt(character.callComponentMethod("CharacterInputController", "get_currentLife",""));
    }

    public void avoidObstacles(int nrOfObstacles){
        AltUnityObject character1 = character;
        boolean movedLeft = false;
        boolean movedRight = false;

        for(int i=0; i< nrOfObstacles; i++){

            AltFindObjectsParameters params = new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "[contains(@name, Obstacle)]").build();
            List<AltUnityObject> allObstacles = Arrays.asList(getDriver().findObjects(params));
            allObstacles.sort((x,y) -> {
                String xs = String.valueOf(x.worldZ);
                String ys = String.valueOf(y.worldZ);
                return xs.compareTo(ys);
            });

            List<AltUnityObject> tobeRemoved = new ArrayList<>();
            for(AltUnityObject obs: allObstacles){
                if(obs.worldZ < character1.worldZ)
                    tobeRemoved.add(obs);
            }
            allObstacles.removeAll(tobeRemoved);

            AltUnityObject obstacle = allObstacles.get(0);
            System.out.println(("Obstacle: "+ obstacle.name+", z:"+obstacle.worldZ+", x:"+obstacle.worldX));
            System.out.println("Next: "+ allObstacles.get(1).name+", z:"+allObstacles.get(1).worldZ+", x:"+allObstacles.get(1).worldX);

            while(obstacle.worldZ - character1.worldZ < 5) {
                params = new AltFindObjectsParameters.Builder(AltUnityDriver.By.ID, "id(" + obstacle.id + ")").build();
                obstacle = getDriver().findObject(params);
                params = new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "PlayerPivot").build();
                character1 = getDriver().findObject(params);
            }

            if(obstacle.name.contains("ObstacleHighBarrier")){
                getDriver().pressKey("down",1,0);
            }
            else if (obstacle.name.contains("ObstacleLowBarrier") || obstacle.name.contains("Rat")){
                getDriver().pressKey("up",1,0);
            }
            else {
                if (obstacle.worldZ == allObstacles.get(1).worldZ) {
                    if (obstacle.worldX == character1.worldX) {
                        if (allObstacles.get(1).worldX == -1.5f) {
                            getDriver().pressKey("right", 1, 0);
                            movedRight = true;
                        } else {
                            getDriver().pressKey("left", 1, 0);
                            movedLeft = true;
                        }
                    } else {
                        if (allObstacles.get(1).worldX == character1.worldX) {
                            if (obstacle.worldX == -1.5f) {
                                getDriver().pressKey("right", 1, 0);
                                movedRight = true;
                            } else {
                                getDriver().pressKey("left", 1, 0);
                                movedRight = true;
                            }
                        }
                    }
                }
            }

            while(character1.worldZ - 3 < obstacle.worldZ && character1.worldX < 99){
                params = new AltFindObjectsParameters.Builder(AltUnityDriver.By.ID, "id("+obstacle.id+")").build();
                obstacle = getDriver().findObject(params);
                params = new AltFindObjectsParameters.Builder(AltUnityDriver.By.NAME, "PlayerPivot").build();
                character1 = getDriver().findObject(params);
            }

            if(movedRight){
                getDriver().pressKey("left", 1, 0);
                movedRight = false;
            }

            if(movedLeft){
                getDriver().pressKey("right", 1, 0);
                movedLeft = false;
            }
        }

    }
}
