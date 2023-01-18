package Appium_Basics;

import CreateSession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Waits {
    //Do not use implicit and explicit waits in the same elements/driver etc... it's a bad practice
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        //Implcit wait affect in every element created
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By alertViews = AppiumBy.accessibilityId("Alert Views");
        By okeyCancel = AppiumBy.accessibilityId("Okay / Cancel");

        //Explicit wait affect in a unique element
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(alertViews));// -> Replaces driver.findElement(alertViews).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(okeyCancel));// -> Replaces driver.findElement(okeyCancel).click();
    }
}
