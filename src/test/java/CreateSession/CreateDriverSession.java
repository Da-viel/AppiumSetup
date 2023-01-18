package CreateSession;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.net.URL;
public class CreateDriverSession {
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
                appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                        File.separator + "resources" + File.separator + "ApiDemos-debug.apk";
                caps.setCapability(MobileCapabilityType.APP, appUrl);
                caps.setCapability("avd", "Pixel_4_API_30");
                caps.setCapability("avdLaunchTimeout", 120000);
                return new AndroidDriver(url, caps);
            case "iOS":
                caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 8");
                caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
                caps.setCapability(MobileCapabilityType.UDID, "BC53CDCB-EA39-4614-BD06-0AB7173CF968");
                appUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" +
                        File.separator + "resources" + File.separator + "UIKitCatalog-iphonesimulator.app";
                caps.setCapability(MobileCapabilityType.APP, appUrl);
                //caps.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");

                caps.setCapability("simulatorStartupTimeout", 180000);
                return new IOSDriver(url, caps);
            default:
                throw new Exception("Invalid Platform");

        }
    }
}
