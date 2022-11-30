import java.io.IOException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;
import com.alttester.AltPortForwarding;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class BaseTest {
    public static URL url;
    public static DesiredCapabilities capabilities;
    public static AppiumDriver<IOSElement> driver;

    @BeforeClass
    public void setUpAppium() throws IOException, InterruptedException {
        final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
        URL url = new URL(URL_STRING);

        capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.APP, System.getenv("APP"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Local Device");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability("useNewWDA", false);
        capabilities.setCapability("xcodeOrgId", "59ESG8ELF5");
        capabilities.setCapability("xcodeSigningId", "iPhone Developer");
        capabilities.setCapability("updatedWDABundleId", "altom.fi.trashcat");

        driver = new IOSDriver<IOSElement>(url, capabilities);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        Thread.sleep(3000);
        SetupPortForwarding();
    }

    void SetupPortForwarding() throws IOException {
        AltPortForwarding.killAllIproxyProcess();
        AltPortForwarding.forwardIos();
    }

    @AfterClass
    public void tearDownAppium() {
        driver.quit();
    }
}