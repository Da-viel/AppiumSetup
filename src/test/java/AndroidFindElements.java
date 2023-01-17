import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class AndroidFindElements {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");

        //Standard find (Always try this when it's possible)
        WebElement myElement = driver.findElement(AppiumBy.accessibilityId("Accessibility"));
        System.out.println("Accessibility ID:  " + myElement.getText());

        //Search for all ElementS, then we find the one we need from the index get(1) in this case
        myElement = driver.findElements(AppiumBy.id("android:id/text1")).get(1);
        System.out.println("ID:  " + myElement.getText());

        //Search for all ElementS in the class, then we find the one we need from the index get(2) in this case
        myElement = driver.findElements(AppiumBy.className("android.widget.TextView")).get(2);
        System.out.println("Class Name:  " + myElement.getText());

        //Standard find with Xpath
        myElement = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
        System.out.println("Xpath:  " + myElement.getText());

        //We just created a customMade Xpath using the name/text of the button
        myElement = driver.findElement(AppiumBy.xpath("//*[@text=\"Accessibility\"]"));
    }
}
