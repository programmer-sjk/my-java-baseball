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
            balls.add(new Ball(Integer.parseInt(value)));
        }

        return new Balls(balls);
    }
}
