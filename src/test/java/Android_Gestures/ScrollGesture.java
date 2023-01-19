package Android_Gestures;

import CreateSession.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class ScrollGesture {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        scrollExercice(driver);
    }

    public static void scrollExercice(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
        WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));
        boolean canScrollMore = true;
        while (canScrollMore){
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "elementId", ((RemoteWebElement) element).getId(),
                    "direction", "right",
                    "percent", 1.0
            ));
            System.out.println(canScrollMore);
        }

    }

    public static void scrollGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        //WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Animation"));
        boolean canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                //"left", 100, "top", 100, "width", 600, "height", 600,
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "down",
                "percent", 1.0
        ));
        //Scroll till the end
        while(canScrollMore){
            canScrollMore = (Boolean) driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 600, "height", 600,
                    "direction", "down",
                    "percent", 1.0
            ));
            System.out.println(canScrollMore);
        }
    }
}
