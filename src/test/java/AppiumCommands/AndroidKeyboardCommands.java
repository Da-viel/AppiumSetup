package AppiumCommands;

import CreateSession.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class AndroidKeyboardCommands {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));
        driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
        driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit")).click();
        Thread.sleep(1000);

        //KEYBOARD COMMANDS
        System.out.println(((AndroidDriver) driver).isKeyboardShown());// -> Check if Keyboard displayed

        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.C));// AndroidKey.CALENDAR -> Opensa calendar
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.A));// AndroidKey.HOME -> Press the home button
        ((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.T));

        ((AndroidDriver) driver).hideKeyboard();// -> Hide Keyboard

    }
}
