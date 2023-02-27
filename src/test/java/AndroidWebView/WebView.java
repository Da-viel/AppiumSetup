package AndroidWebView;

import CreateSession.CreateDriverSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.time.Duration;

public class WebView {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(AppiumBy.accessibilityId("Views")).click();

        WebElement element = driver.findElement(AppiumBy.id("android:id/list"));

        swipe(driver, element);

        driver.findElement(AppiumBy.accessibilityId("WebView2")).click();

        System.out.println(driver.findElement(AppiumBy.xpath("//android.webkit.WebView/android.view.View[1]")).getText());

    }
    public static void swipe(AppiumDriver driver, WebElement element){
        driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", "up",
                "percent", 0.75
        ));
    }
}
