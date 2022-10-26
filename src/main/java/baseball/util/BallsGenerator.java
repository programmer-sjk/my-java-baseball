package baseball.util;

import baseball.common.enums.Error;
import baseball.model.Ball;
import baseball.model.Balls;

import java.util.ArrayList;
import java.util.List;

public class BallsGenerator {
    private static final String DELIMITER = "";

    public static Balls create(String number) {
        List<Ball> balls = new ArrayList<>();

        for (String value : number.split(DELIMITER)) {
            balls.add(Ball.create(convertInteger(value)));
        }

        return Balls.create(balls);
    }

    private static int convertInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.IS_NOT_INTEGER.getDescription());
        }
    }
}
