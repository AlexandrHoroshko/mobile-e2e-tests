import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.MalformedURLException;
import java.net.URI;

public abstract class BaseTest {

    protected AndroidDriver driver;

    @BeforeEach
    public void setup() {
        var properties = Config.loadProperties(OSEnum.ANDROID);
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid(properties.getProperty("deviceId"))
                .setApp(properties.getProperty("app"));
        try {
            driver = new AndroidDriver(
                    URI.create(properties.getProperty("appiumServerUrl")).toURL(), options
            );
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
