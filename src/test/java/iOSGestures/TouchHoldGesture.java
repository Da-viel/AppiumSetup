package iOSGestures;

import CreateSession.CreateDriverSession;
import com.beust.ah.A;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class TouchHoldGesture {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        tapAndHoldGesture(driver);
    }

    public static void tapAndHoldGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Steppers")).click();

        WebElement increment = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Increment\"`][1]"));
        WebElement  decrement = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == \"Decrement\"`][1]"));
        WebElement  validator = driver.findElement(AppiumBy.xpath("(//XCUIElementTypeStaticText[@name=\"0\"])[1]"));

        Map<String, Object> params = new HashMap<>();
        params.put("elementId", ((RemoteWebElement) increment).getId());
        params.put("duration", 3);
        driver.executeScript("mobile: touchAndHold", params);

        if (Integer.valueOf(validator.getText()) != 0){
            System.out.println("Touching and holding decrement");
            Map<String, Object> params2 = new HashMap<>();
            params2.put("elementId", ((RemoteWebElement) decrement).getId());
            params2.put("duration", 3);
            driver.executeScript("mobile: touchAndHold", params2);
        }else{
            System.out.println("Fail");
        }
        if (Integer.valueOf(validator.getText()) == 0) {
            System.out.println("Test passed");
        }else{
            System.out.println("Fail");
        }
    }
}
