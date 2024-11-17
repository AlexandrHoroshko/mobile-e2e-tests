import org.junit.jupiter.api.Test;

public class SampleTest extends BaseTest {

    @Test
    public void appLaunchTest() {
        System.out.println("App launched successfully!");
        assert driver != null;
    }
}
