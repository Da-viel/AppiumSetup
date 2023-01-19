package AppiumCommands;

import CreateSession.CreateDriverSession;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.appmanagement.AndroidInstallApplicationOptions;
import io.appium.java_client.android.appmanagement.AndroidTerminateApplicationOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AndroidInteractWithApps {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        By views = AppiumBy.accessibilityId("Views");
        driver.findElement(views).click();

        Thread.sleep(2000);

        //TERMINATE APP -> use new AndroidTerminateApplicationOptions() for more options
        // ((AndroidDriver) driver).terminateApp("io.appium.android.apis");

        //INSTALL APP -> use new AndroidInstallApplicationOptions() for more options
        //String appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
               //File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
        //((AndroidDriver) driver).installApp(appUrl, new AndroidInstallApplicationOptions().withReplaceEnabled());

        //REMOVE APP
        //((AndroidDriver)driver).removeApp("io.appium.android.apis");

        //CHECK IF APP INSTALLED
        //System.out.println(((AndroidDriver) driver).isAppInstalled("io.appium.android.apis"));

        //BACKGROUND APP
        //((AndroidDriver) driver).runAppInBackground(Duration.ofSeconds(2));

        //ACTIVATE AN OTHER APP
        //((AndroidDriver) driver).activateApp("com.android.settings");

        //STATE APP
        //System.out.println(((AndroidDriver) driver).queryAppState("io.appium.android.apis"));

        //RESET APP
        //((AndroidDriver) driver).resetApp();

        //CLOSE APP -> DEPRECATED
        //((AndroidDriver) driver).closeApp();
    }
}
