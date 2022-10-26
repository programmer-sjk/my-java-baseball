package baseball.view.enums;

public enum ResultType {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String description;

    ResultType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}
