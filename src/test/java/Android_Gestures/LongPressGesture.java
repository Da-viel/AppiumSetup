package Android_Gestures;

import CreateSession.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class LongPressGesture {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        longClickGesture(driver);
    }

    public static void longClickGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

        //We take the window size, doing this is going to be useful in order to test this class in other devices
        Dimension windowSize = driver.manage().window().getSize();

        //It can be used the id or coordinates, but not both at the same time
        driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
                //"elementId", ((RemoteWebElement) element).getId(),
                "x", windowSize.width/5,
                "y", windowSize.height/3.5,
                "duration", 2000
        ));

    }
}
