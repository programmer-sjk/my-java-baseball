package baseball.model;

import baseball.common.enums.Error;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.common.constant.BaseBall.BASEBALL_NUMBER_LENGTH;

public class Balls {
    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        validateDuplicate(balls);
        this.balls = balls;
    }

    public static Balls create(List<Ball> balls) {
        return new Balls(balls);
    }

    private void validateDuplicate(List<Ball> balls) {
        Set<Integer> uniqueBalls = new HashSet<>();
        for (Ball ball : balls) {
            uniqueBalls.add(ball.getNumber());
        }

        if (uniqueBalls.size() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(Error.INVALID_LENGTH.toString());
        }
    }

    public int size() {
        return this.balls.size();
    }

    public int numberByIndex(int index) {
        return this.balls.get(index).getNumber();
    }
}