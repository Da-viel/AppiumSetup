package AndroidWebView;

import CreateSession.CreateBrowserSession;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import java.time.Duration;

public class WebView3 {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateBrowserSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.tesla.com/");

        //Click menu button
        driver.findElement(AppiumBy.xpath("//*[@id=\"tds-site-header\"]/ol/li/button")).click();
        //Click Model X
        driver.findElement(AppiumBy.xpath("//*[@id=\"tds-global-menu\"]/dialog/section/ol/li[3]/a/span\n")).click();
         //Order Now
        driver.findElement(AppiumBy.xpath("//*[@id=\"tesla-hero-3455\"]/div[2]/div/section/div/a")).click();
        //Click on USA
        driver.findElement(AppiumBy.xpath("//*[@id=\"tds-global-menu\"]/dialog/section/div/div[1]/div[1]/div/div[1]/a")).click();

        Thread.sleep(5000);
        for (int i = 0; i < 25; i++) {
            driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 600, "height", 600,
                    "direction", "down",
                    "percent", 1.0
            ));
        }
        //Continue to Payment
        driver.findElement(AppiumBy.xpath("//*[@id=\"main-content\"]/section/div/div/div[8]/div/div/div[2]/button")).click();

        Thread.sleep(2000);
        for (int i = 0; i < 5; i++) {
            driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 600, "height", 600,
                    "direction", "down",
                    "percent", 1.0
            ));
        }

        //Order with card
        driver.findElement(AppiumBy.xpath("//*[@id=\"main-content\"]/section/div/div/div[3]/div/div/div[8]/div/div[2]/div[1]/div[1]/button")).click();
        //First name
        driver.findElement(AppiumBy.xpath("//*[@id=\"FIRST_NAME\"]")).click();
        driver.findElement(AppiumBy.xpath("//*[@id=\"FIRST_NAME\"]")).sendKeys("Dani");

    }
}
