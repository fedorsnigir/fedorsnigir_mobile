package setup;

import enums.ErrorMessagesEnum;
import enums.PropertiesEnum;
import enums.PropertyOptionsEnum;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;

import static enums.BrowsersEnum.CHROME;
import static enums.BrowsersEnum.SAFARI;
import static enums.ErrorMessagesEnum.UNKNOWN_APPLICATION;
import static enums.ErrorMessagesEnum.UNKNOWN_PLATFORM;

//Initialize a driver with test properties
public class DriverSetup extends TestProperties {

    private static AppiumDriver driver;
    private static WebDriverWait wait;
    private DesiredCapabilities capabilities = new DesiredCapabilities();
    private String HTTPS = "https://";
    private String RESOURCES_PATH = "src/main/resources/";
    // Properties
    protected String SUT; // site under testing
    private String AUT; // app under testing
    private String TEST_PLATFORM;
    private String DRIVER;
    private String DEVICE_NAME;
    private String UDID;
    private String APP_PACKAGE;
    private String APP_ACTIVITY;
    private String BROWSER_NAME;

    //Initialize driver with appropriate capabilities depending on platform and application
    protected void prepareDriver(PropertyOptionsEnum propertyOption) throws Exception {
        PROPERTY_OPTION = propertyOption;
        DRIVER = getProperty(PropertiesEnum.DRIVER.value);
        DEVICE_NAME = getProperty(PropertiesEnum.DEVICE_NAME.value);
        UDID = getProperty(PropertiesEnum.UDID.value);
        APP_PACKAGE = getProperty(PropertiesEnum.APP_PACKAGE.value);
        APP_ACTIVITY = getProperty(PropertiesEnum.APP_ACTIVITY.value);

        String site = getProperty(PropertiesEnum.SUT.value);
        SUT = site == null ? null : HTTPS + site;

        String appName = getProperty(PropertiesEnum.AUT.value);
        AUT = appName == null ? null : RESOURCES_PATH + appName;

        // Setup test platform: Android or iOS. Browser also depends on a platform
        TEST_PLATFORM = getProperty(PropertiesEnum.TEST_PLATFORM.value);
        switch (TEST_PLATFORM) {
            case "Android":
                BROWSER_NAME = CHROME.value;
                break;
            case "iOS":
                BROWSER_NAME = SAFARI.value;
                break;
            default:
                throw new Exception(UNKNOWN_PLATFORM.value);
        }

        // Setup type of application: mobile, webTests (or hybrid)
        if (AUT != null && SUT == null) {
            // Native
            File app = new File(AUT);
            capabilities.setCapability(PropertiesEnum.APP.value, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            // Web
            capabilities.setCapability(CapabilityType.BROWSER_NAME, BROWSER_NAME);
        } else {
            throw new Exception(UNKNOWN_APPLICATION.value);
        }

        capabilities.setCapability(PropertiesEnum.APP_PACKAGE.value, APP_PACKAGE);
        capabilities.setCapability(PropertiesEnum.APP_ACTIVITY.value, APP_ACTIVITY);
        capabilities.setCapability(PropertiesEnum.UDID.value, UDID);
        capabilities.setCapability(PropertiesEnum.PLATFORM_NAME.value, TEST_PLATFORM);
        capabilities.setCapability(PropertiesEnum.DEVICE_NAME.value, DEVICE_NAME); // default Android emulator

        // Init driver for local Appium server with capabilities
        switch (TEST_PLATFORM) {
            case "Android":
                driver = new AndroidDriver(new URL(DRIVER), capabilities);
                break;
            case "iOS":
                driver = new IOSDriver(new URL(DRIVER), capabilities);
                break;
            default:
                throw new Exception(ErrorMessagesEnum.UNKNOWN_PLATFORM.value);
        }
    }

    protected AppiumDriver getDriver() throws Exception {
        if (driver == null) {
            prepareDriver(PROPERTY_OPTION);
        }
        return driver;
    }

    protected WebDriverWait getWait() throws Exception {
        if (wait == null) {
            // Set an object to handle timeouts
            wait = new WebDriverWait(getDriver(), 10);
        }
        return wait;
    }
}
