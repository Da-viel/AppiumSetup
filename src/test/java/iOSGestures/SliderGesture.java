package iOSGestures;

import CreateSession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class SliderGesture {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        sliderGesture(driver);
    }
    public static void sliderGesture(AppiumDriver driver) {
        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();
        WebElement slider = driver.findElement(AppiumBy.iOSNsPredicateString("value == \"42%\""));

        slider.sendKeys("0");

        slider = driver.findElement(AppiumBy.iOSNsPredicateString("value == \"0%\""));
        slider.sendKeys("1");
    }
}
