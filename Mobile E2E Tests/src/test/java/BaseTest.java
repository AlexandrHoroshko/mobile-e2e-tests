import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URI;
import java.util.Properties;

public abstract class BaseTest {
    protected AndroidDriver driver;

    @BeforeEach
    public void setup() {
        try {
            Properties config = Config.loadProperties(OSEnum.ANDROID);
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", config.getProperty("platformName"));
            caps.setCapability("platformVersion", config.getProperty("platformVersion"));
            caps.setCapability("deviceName", config.getProperty("deviceName"));
            caps.setCapability("app", config.getProperty("app"));
            caps.setCapability("automationName", config.getProperty("automationName"));

            String selenoidUrl = "http://localhost:4444/wd/hub";
            driver = new AndroidDriver(URI.create(selenoidUrl).toURL(), caps);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
