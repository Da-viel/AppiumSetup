package CreateSession;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.URL;
public class CreateDriverSessionForPinch {
    public static AppiumDriver initializeDriver (String platformName) throws Exception {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        caps.setCapability("newCommandTimeout", 300);
        String appUrl;

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        switch (platformName) {
            case "Android":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 4");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
                caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
                caps.setCapability("avd", "Pixel_4_API_30");
                caps.setCapability("appPackage", "com.google.android.apps.maps");
                caps.setCapability("appActivity", "com.google.android.maps.MapsActivity");
                caps.setCapability("avdLaunchTimeout", 120000);
                return new AndroidDriver(url, caps);
            case "iOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                caps.setCapability(MobileCapabilityType.UDID, "BC53CDCB-EA39-4614-BD06-0AB7173CF968");
                caps.setCapability("bundleId", "com.apple.Maps");

                caps.setCapability("simulatorStartupTimeout", 180000);
                return new IOSDriver(url, caps);
            default:
                throw new Exception("Invalid Platform");

        }
    }
}
