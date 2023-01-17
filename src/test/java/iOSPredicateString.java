import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class iOSPredicateString {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");

       WebElement myElement = driver.findElement(AppiumBy.iOSNsPredicateString("name == \"Activity Indicators\""));
       System.out.println(myElement.getText());

       myElement = driver.findElement(AppiumBy.iOSNsPredicateString("type == \"XCUIElementTypeStaticText\" AND name == \"Activity Indicators\""));
       System.out.println(myElement.getText());

        myElement = driver.findElements(AppiumBy.iOSNsPredicateString("name == \"Alert Views\" OR name == \"Activity Indicators\"")).get(1);
        System.out.println(myElement.getText());

       //By myElement1 = AppiumBy.iOSNsPredicateString("");
    }
}
