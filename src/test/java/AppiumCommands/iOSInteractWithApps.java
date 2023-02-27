package AppiumCommands;

import CreateSession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

import java.io.File;
import java.time.Duration;

public class iOSInteractWithApps {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("iOS");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        By activityIndicators = AppiumBy.accessibilityId("Activity Indicators");
        driver.findElement(activityIndicators).click();

        Thread.sleep(2000);

        //TERMINATE APP
        //((IOSDriver) driver).terminateApp("com.example.apple-samplecode.UICatalog");

        //INSTALL APP
        //String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                //File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
        //((IOSDriver) driver).installApp(appUrl);

        //BACKGROUND APP
        //((IOSDriver) driver).runAppInBackground(Duration.ofSeconds(2));

        //ACTIVATE AN OTHER APP
        //((IOSDriver) driver).activateApp("com.apple.Preferences");
        //Thread.sleep(2000);
        //((IOSDriver) driver).activateApp("com.example.apple-samplecode.UICatalog");

        //STATE APP
        //System.out.println(((IOSDriver) driver).queryAppState("com.example.apple-samplecode.UICatalog"));
    }
}
