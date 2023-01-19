package Android_Gestures;

import CreateSession.CreateDriverSession;
import CreateSession.CreateDriverSessionForPinch;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class PinchOutInGesture {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSessionForPinch.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        pinchOpen(driver);
        pinchClose(driver);
    }

    public static void pinchOpen(AppiumDriver driver) throws InterruptedException {

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text=\"SKIP\"]")).click();
        Thread.sleep(2000);
        driver.executeScript("mobile: pinchOpenGesture", ImmutableMap.of(
                "left", 200,
                "top",  470,
                "width", 600,
                "height", 600,
                "percent", 0.75
        ));
    }

    public static void pinchClose(AppiumDriver driver) throws InterruptedException {
        Thread.sleep(2000);
        driver.executeScript("mobile: pinchCloseGesture", ImmutableMap.of(
                "left", 450,
                "top",  1230,
                "width", 10,
                "height", 10,
                "percent", 0.75
        ));
    }
}
