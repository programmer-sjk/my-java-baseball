package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.constant.BaseBall.BASEBALL_NUMBER_LENGTH;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validateDuplicate(balls);
        this.balls = balls;
    }

    private void validateDuplicate(List<Ball> balls) {
        Set<Ball> uniqueBalls = new HashSet<>(balls);
        if (uniqueBalls.size() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력값 길이가 맞지 않습니다.");
        }
    }

    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (Ball ball : balls) {
            numbers.add(ball.getNumber());
        }

        return numbers;
    }
}
