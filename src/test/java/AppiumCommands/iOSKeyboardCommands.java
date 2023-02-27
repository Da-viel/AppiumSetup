package AppiumCommands;

import CreateSession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class iOSKeyboardCommands {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        swipe(driver);
        driver.findElement(AppiumBy.accessibilityId("Text Fields")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`value == \"Placeholder text\"`][1]")).click();

        driver.findElement(AppiumBy.accessibilityId("shift")).click();
        driver.findElement(AppiumBy.accessibilityId("C")).click();
        driver.findElement(AppiumBy.accessibilityId("a")).click();
        driver.findElement(AppiumBy.accessibilityId("t")).click();
        driver.findElement(AppiumBy.accessibilityId("Done")).click();
    }

    public static void swipe(AppiumDriver driver){
        WebElement element = driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeTable\""));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "up");
        params.put("velocity", 2500);
        params.put("element", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: swipe", params);
    }
}
