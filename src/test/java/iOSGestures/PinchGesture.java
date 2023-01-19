package iOSGestures;

import CreateSession.CreateDriverSession;
import CreateSession.CreateDriverSessionForPinch;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class PinchGesture {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSessionForPinch.initializeDriver("iOS");
        pinchGesture(driver);
    }

    public static void pinchGesture(AppiumDriver driver){
        WebElement element = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"OverlayView\"`][1]"));

        Map<String, Object> params = new HashMap<>();
        params.put("elementID", ((RemoteWebElement) element).getId());
        params.put("scale", 6); // -> Scale 0 - 1 to zoom out // Scale 1 - 999 to zoom in ////// in this case "6" is going to zoom in
        params.put("velocity", 2.2);// -> When zoom in this variable mast be positive
        driver.executeScript("mobile: pinch", params);

        Map<String, Object> params2 = new HashMap<>();
        params.put("elementID", ((RemoteWebElement) element).getId());
        params2.put("scale", 0.5); // -> Scale 0 - 1 to zoom out // Scale 1 - 999 to zoom in ////// in this case "0.3" is going to zoom put
        params2.put("velocity", -1);// -> When zoom out this variable must be negative
        driver.executeScript("mobile: pinch", params2);

    }
}
