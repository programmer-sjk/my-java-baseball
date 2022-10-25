package baseball.model;

import baseball.common.constant.BaseBall;
import baseball.common.enums.Error;

public class Ball {
    private final int number;

    private Ball(int number) {
        validateInRange(number);
        this.number = number;
    }

    public static Ball create(int number) {
        return new Ball(number);
    }

    private void validateInRange(int number) {
        if (number < BaseBall.MIN_NUMBER && number > BaseBall.MAX_NUMBER) {
            throw new IllegalArgumentException(Error.INVALID_RANGE.toString());
        }
    }

    public int getNumber() {
        return number;
    }
}
