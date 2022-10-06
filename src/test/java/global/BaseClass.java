package global;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static AppiumDriver driver;

    public static DesiredCapabilities initDevice(){
        File filepath = new File(System.getProperty("user.dir"));
        File app = new File(filepath, "/apk/mda-1.0.13-15.apk");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("automationName","UiAutomator2");
        cap.setCapability("platformName","Android");
        cap.setCapability("deviceName","Android Emulator");
        cap.setCapability("app",app.getAbsolutePath());
        cap.setCapability("autoGrantPermissions","true");
        cap.setCapability("noReset","true");
        return cap;
    }
    public static void openApps() throws Exception {
        String appiumServerURL = "http://localhost:4723/wd/hub";
        driver = new AppiumDriver(new URL(appiumServerURL), initDevice());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public static void closeApps(){
        driver.closeApp();
    }

    public static void scrollDown(){
        Dimension dimension = driver.manage().window().getSize();
        int scrollStart = (int) (dimension.getHeight() * 0.6);
        int scrollEnd = (int) (dimension.getHeight() * 0.2);
        int startX = (int) (dimension.getHeight() * 0.5);
        int endY = (int) (dimension.getHeight() * 0.2);

        TouchAction action = new TouchAction(driver);

        action = new AndroidTouchAction(driver)
                .press(PointOption.point(startX, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endY, scrollEnd))
                .release()
                .perform();
    }

}
