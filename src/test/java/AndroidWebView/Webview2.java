package AndroidWebView;

import CreateSession.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import java.time.Duration;
import java.util.Map;
import java.util.Set;

public class Webview2 {

    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));
        swipe(driver, element);
        driver.findElement(AppiumBy.accessibilityId("WebView")).click();

        Set<String> contextHandles = ((AndroidDriver) driver).getContextHandles();
        Thread.sleep(3000);
        for (String contextHandle: contextHandles) {
            System.out.println(contextHandle);
        }
        Thread.sleep(3000);
        ((AndroidDriver) driver).context("WEBVIEW");

        System.out.println(driver.findElement(By.cssSelector("body > h1")).getText());

        ((AndroidDriver) driver).context("NATIVE_APP");

    }

    public static void swipe(AppiumDriver driver, WebElement element){
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));
    }
}
