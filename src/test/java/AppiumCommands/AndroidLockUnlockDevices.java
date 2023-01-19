package AppiumCommands;

import CreateSession.CreateDriverSession;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.util.concurrent.TimeUnit;

public class AndroidLockUnlockDevices {
    public static void main(String[] args) throws Exception {
        AppiumDriver driver = CreateDriverSession.initializeDriver("Android");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        unlock(driver);
    }

    public static void unlock(AppiumDriver driver){
        ((AndroidDriver) driver).lockDevice();// For a certain time -> lockDevice(Duration.ofSeconds(5)
        System.out.println(((AndroidDriver)driver).isDeviceLocked());
        ((AndroidDriver) driver).unlockDevice();
        System.out.println(((AndroidDriver)driver).isDeviceLocked());
    }
}
