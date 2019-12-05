package altunity.alttrashcatj.tests;

import ro.altom.altunitytester.AltUnityDriver;

public class StartPageTests {

    private AltUnityDriver driver;
    //private MainMenuPage mainMenuPage;

    public StartPageTests() {
        this.driver = new AltUnityDriver("127.0.0.1",13000);;
    }
}
