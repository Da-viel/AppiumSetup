package Appium_Basics;

import CreateSession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class AndroidUiAutomator {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        WebElement myElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Accessibility\")"));
        System.out.println("UiAutomator by Text: " + myElement.getText());

        //By myElement1 = AppiumBy.androidUIAutomator("");

        myElement = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\")")).get(2);
        System.out.println("UiAutomator by Class Name: " + myElement.getText());

        myElement = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().description(\"Accessibility\")"));
        System.out.println("UiAutomator by Class Name: " + myElement.getText());

        myElement = driver.findElements(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/text1\")")).get(1);
        System.out.println("UiAutomator by Class Name: " + myElement.getText());

    }
}
