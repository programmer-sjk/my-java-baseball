package baseball.enums;

public enum Error {
    INVALID_INPUT_RESTART("게임 재시작, 종료에 올바르지 않은 값이 입력되었습니다"),
    INVALID_RANGE("숫자가 유효한 범위 안에 있지 않습니다."),
    INVALID_LENGTH("입력값 길이가 맞지 않습니다."),
    IS_NOT_INTEGER("숫자가 아닙니다.");

    private final String description;

    Error(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.description;
    }
}
