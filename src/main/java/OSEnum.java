public enum OSEnum {

    ANDROID("android"),
    IOS("ios");

    private final String value;

    OSEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
