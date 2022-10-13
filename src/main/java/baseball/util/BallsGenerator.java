package baseball.util;

import baseball.model.Ball;
import baseball.model.Balls;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class BallsGenerator {
    public static Balls create(Set<String> numbers) {
        List<Ball> balls = new ArrayList<>();

        for (String number : numbers) {
            balls.add(new Ball(Integer.parseInt(number)));
        }

        return new Balls(balls);
    }
}
