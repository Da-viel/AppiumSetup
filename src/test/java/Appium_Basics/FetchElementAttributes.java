package Appium_Basics;

import CreateSession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FetchElementAttributes {
    public static void main(String[] args) throws Exception {
        /*
        AppiumDriver driver = CreateSession.CreateDriverSession.initializeDriver("Android");
        By accesibility = AppiumBy.accessibilityId("Accessibility");
        */

        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        By accesibility = AppiumBy.accessibilityId("Activity Indicators");

        System.out.println("label: " + driver.findElement(accesibility).getText()); // -> iOS and Android compatibility
        System.out.println("label: " + driver.findElement(accesibility).getAttribute("label"));// -> "label" for iOS/"text" for Android

        //This to elements can check/value elements such as switches
        System.out.println("value: " + driver.findElement(accesibility).getAttribute("value"));// -> only applicable for iOS
        //System.out.println("checked: " + driver.findElement(accesibility).getAttribute("checked"));// -> only applicable for Android

        System.out.println("enabled: " + driver.findElement(accesibility).getAttribute("enabled"));// -> iOS and Android compatibility
        System.out.println("selected: " + driver.findElement(accesibility).getAttribute("selected"));// -> iOS and Android compatibility
        System.out.println("visible: " + driver.findElement(accesibility).getAttribute("visible"));// -> "visible" for iOS/"displayed" for Android

        System.out.println("isSelected: " + driver.findElement(accesibility).isSelected());// -> iOS and Android compatibility
        System.out.println("isEnabled: " + driver.findElement(accesibility).isEnabled());// -> iOS and Android compatibility
        System.out.println("isDisplayed: " + driver.findElement(accesibility).isDisplayed());// -> iOS and Android compatibility

    }
}
