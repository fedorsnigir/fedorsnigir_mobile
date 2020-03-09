package homework2.enums;

public enum BrowsersEnum {

    CHROME("Chrome"),
    SAFARI("Safari");

    public String value;

    BrowsersEnum(String browserName) {
        this.value = browserName;
    }
}
