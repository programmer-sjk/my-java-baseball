package baseball.model;

import baseball.constant.BaseBall;
import baseball.constant.Error;

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

        throw new IllegalArgumentException(Error.INVALID_RANGE.toString());
    }

    public int getNumber() {
        return number;
    }
}
