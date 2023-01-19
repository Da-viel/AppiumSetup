package iOSGestures;

import CreateSession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public class PickerWheelGesture {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        pickerWheelGesture(driver);
    }

    public static void pickerWheelGesture(AppiumDriver driver){
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();

        WebElement redPicker = driver.findElement(AppiumBy.accessibilityId("Red color component value"));
        WebElement greenPicker = driver.findElement(AppiumBy.accessibilityId("Green color component value"));
        WebElement bluePicker = driver.findElement(AppiumBy.accessibilityId("Blue color component value"));

        Map<String, Object> redPickerParams = new HashMap<>();
        redPickerParams.put("order", "next");// -> next or previous
        redPickerParams.put("offset", 0.15);// -> the sensitivity of the spin
        redPickerParams.put("elementId", ((RemoteWebElement) redPicker).getId());

        driver.executeScript("mobile: selectPickerWheelValue", redPickerParams);

        Map<String, Object> greenPickerParams = new HashMap<>();
        greenPickerParams.put("order", "previous");// -> next or previous
        greenPickerParams.put("offset", 0.3);// -> the sensitivity of the spin
        greenPickerParams.put("elementId", ((RemoteWebElement) greenPicker).getId());

        driver.executeScript("mobile: selectPickerWheelValue", greenPickerParams);

        //This is how to select a specific value
        boolean flag = true;
        while (flag){
            Map<String, Object> bluePickerParams = new HashMap<>();
            bluePickerParams.put("order", "previous");// -> next or previous
            bluePickerParams.put("offset", 0.15);// -> the sensitivity of the spin
            bluePickerParams.put("elementId", ((RemoteWebElement) bluePicker).getId());
            driver.executeScript("mobile: selectPickerWheelValue", bluePickerParams);
            if (bluePicker.getText().equals("90")){
                flag = false;
            }
        }
    }
}
