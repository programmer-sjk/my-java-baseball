package baseball.model;

import baseball.constant.BaseBall;

public class Ball {
    private final int number;

    public Ball(int number) {
        validateInRange(number);
        this.number = number;
    }

    private void validateInRange(int number) {
        if (number >= BaseBall.MIN_NUMBER && number <= BaseBall.MAX_NUMBER) {
            return ;
        }

        throw new IllegalArgumentException("숫자가 유효한 범위 안에 있지 않습니다.");
    }

    public int getNumber() {
        return number;
    }
}
