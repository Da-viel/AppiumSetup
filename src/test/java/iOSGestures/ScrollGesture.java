package iOSGestures;

import CreateSession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class ScrollGesture {
        public static void main(String[] args) throws Exception {
            AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
            scrollGesture(driver);
        }

        public static void scrollGesture(AppiumDriver driver){
            Map<String, Object> params = new HashMap<>();
            params.put("direction", "down");
            driver.executeScript("mobile: scroll", params);
/*        WebElement parentElement = driver.findElement(AppiumBy.
                iOSNsPredicateString("type == \"XCUIElementTypeTable\""));*/
            WebElement childElement = driver.findElement(AppiumBy.
                    accessibilityId("Activity Indicators"));
            params = new HashMap<>();
//        params.put("direction", "down");
            params.put("elementId", ((RemoteWebElement) childElement).getId());
            //        params.put("name", "Web View");
//        params.put("predicateString", "label == \"Web View\"");
            params.put("toVisible", true);
            driver.executeScript("mobile: scroll", params);
        }
    }

