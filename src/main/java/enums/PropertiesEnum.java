package enums;

public enum PropertiesEnum {

    AUT("aut"),
    SUT("sut"),
    APP("app"),
    PLATFORM("platform"),
    PLATFORM_NAME("platformName"),
    DRIVER("driver"),
    DEVICE_NAME("deviceName"),
    UDID("udid"),
    APP_PACKAGE("appPackage"),
    APP_ACTIVITY("appActivity");

    public String value;

    PropertiesEnum(String value) {
        this.value = value;
    }
}
