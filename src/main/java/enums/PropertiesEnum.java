package enums;

public enum PropertiesEnum {

    AUT("aut"),
    SUT("sut"),
    APP("app"),
    PLATFORM("platform"),
    PLATFORM_NAME("platformName"),
    BROWSER_NAME("browserName"),
    DRIVER("driver"),
    DEVICE_NAME("deviceName"),
    UDID("udid"),
    APP_PACKAGE("appPackage"),
    APP_ACTIVITY("appActivity"),
    WEB("web"),
    NATIVE("native");

    public String value;

    PropertiesEnum(String value) {
        this.value = value;
    }
}
