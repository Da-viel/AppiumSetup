package iOSWebView;

import CreateSession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebView1 {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Dimension size = driver.manage().window().getSize();

        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        driver.executeScript("mobile: scroll", params);

        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        //Thread.sleep(12000);
        Set<String> contextHandles = ((IOSDriver) driver).getContextHandles();

        for (String contextHandle : contextHandles){
            System.out.println(contextHandle);
        }

        ((IOSDriver) driver).context(contextHandles.toArray()[1].toString());
        System.out.println(driver.findElement(By.cssSelector("body > h1")).getText());
        System.out.println(driver.findElement(By.xpath("//h1")).getText());
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        ((IOSDriver) driver).context("NATIVE_APP");
        driver.findElement(AppiumBy.xpath("//XCUIElementTypeButton[@name=\"UIKitCatalog\"]")).click();
        driver.quit();
    }
}
