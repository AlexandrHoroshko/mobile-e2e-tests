import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleTest extends BaseTest {

    @Test
    void onePlusOneTest() {
        WebElement buttonOne = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_1"));
        WebElement plusButton = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add"));
        buttonOne.click();
        plusButton.click();
        buttonOne.click();
        WebElement resultArea = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview"));
        assertEquals("2", resultArea.getText());
    }

    @Test
    void twoPlusTwoTest() {
        WebElement buttonTwo = driver.findElement(AppiumBy.id("com.google.android.calculator:id/digit_2"));
        WebElement plusButton = driver.findElement(AppiumBy.id("com.google.android.calculator:id/op_add"));
        buttonTwo.click();
        plusButton.click();
        buttonTwo.click();
        WebElement resultArea = driver.findElement(AppiumBy.id("com.google.android.calculator:id/result_preview"));
        assertEquals("4", resultArea.getText());
    }

}