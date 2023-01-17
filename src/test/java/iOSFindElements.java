import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class iOSFindElements {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

        //"Accesibility id", "name" and "id" always contains the same value

        //As always the "Accesibility id" is the best way to find elements // Standard
        WebElement myElement = driver.findElement(AppiumBy.accessibilityId("Activity Indicators"));
        System.out.println(myElement.getText());

        //Need to use the "type" element to use className method
        myElement = driver.findElements(AppiumBy.className("XCUIElementTypeStaticText")).get(1);
        System.out.println(myElement.getText());

        //Just using the element "name"
        myElement = driver.findElement(AppiumBy.name("Activity Indicators"));
        System.out.println(myElement.getText());

        //Need to use the "name" element
        myElement = driver.findElement(AppiumBy.id("Activity Indicators"));
        System.out.println(myElement.getText());

        //Using the xpath given by Appium
        myElement = driver.findElement(AppiumBy.xpath("//XCUIElementTypeStaticText[@name=\"Activity Indicators\"]"));
        System.out.println(myElement.getText());

        /*Need to use "Accesibility id" in this one. Also it can't be used in native apps
        myElement = driver.findElement(AppiumBy.tagName("Activity Indicators"));
        System.out.println(myElement.getText());*/
    }
}
