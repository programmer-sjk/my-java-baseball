package baseball.model;

public class Computer {
    private final Balls balls;

    public Computer(Balls balls) {
        this.balls = balls;
    }

    public int getStrikeCount(Balls input) {
        int strikeCount = 0;

        for (int i = 0; i < balls.size(); i++) {
            strikeCount += equalCount(balls.numberByIndex(i), input.numberByIndex(i));
        }

        return strikeCount;
    }

    public int getBallCount(Balls balls) {
        int ballCount = 0;

        for (int i = 0; i < balls.size(); i++) {
            ballCount += ballCount(i, balls.numberByIndex(i));
        }

        return ballCount;
    }
    private int ballCount(int index, int value) {
        int ballCount = 0;

        for (int i = 0; i < balls.size(); i++) {
            ballCount += countIfDifferentPositionEqual(index, i, value);
        }

        return ballCount;
    }

    private int countIfDifferentPositionEqual(
            int inputIndex,
            int computerIndex,
            int value
    ) {
        if (inputIndex != computerIndex) {
            return equalCount(value, balls.numberByIndex(computerIndex));
        }

        return 0;
    }

    private int equalCount(int num1, int num2) {
        return num1 == num2 ? 1 : 0;
    }
}
