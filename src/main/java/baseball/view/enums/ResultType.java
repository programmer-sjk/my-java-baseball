package baseball.view.enums;

public enum ResultType {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String result;

    ResultType(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return this.result;
    }
}
