package iOSGestures;

import CreateSession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;


public class TapGesture {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        tapGesture(driver);
    }

    public static void tapGesture(AppiumDriver driver){
        Map<String, Object> params = new HashMap<>();
        WebElement element = driver.findElement(AppiumBy.accessibilityId("Steppers"));
        params.put("elementId", ((RemoteWebElement) element).getId());
        params.put("x", 0);// -> Mandatory parameter
        params.put("y", 0);// -> Mandatory parameter
        driver.executeScript("mobile: tap", params);
    }
}
