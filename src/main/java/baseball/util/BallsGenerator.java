package baseball.util;

import baseball.model.Ball;
import baseball.model.Balls;

import java.util.ArrayList;
import java.util.List;

public class BallsGenerator {
    private static final String DELIMITER = "";
    public static Balls create(String number) {
        List<Ball> balls = new ArrayList<>();

        for (String value : number.split(DELIMITER)) {
            balls.add(new Ball(convertInteger(value)));
        }

        return new Balls(balls);
    }

    private static int convertInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
