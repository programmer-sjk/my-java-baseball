package baseball.model;

public class Computer {
    private final Balls balls;

    public Computer(Balls balls) {
        this.balls = balls;
    }

    public int getStrikeCount(Balls input) {
        int strikeCount = 0;

        for (int i = 0; i < balls.getNumbers().size(); i++) {
            strikeCount += equalCount(balls.getNumbers().get(i), input.getNumbers().get(i));
        }

        return strikeCount;
    }

    public int getBallCount(Balls balls) {
        int ballCount = 0;

        for (int i = 0; i < balls.getNumbers().size(); i++) {
            ballCount += ballCount(i, balls.getNumbers().get(i));
        }

        return ballCount;
    }

    private int ballCount(int index, int value) {
        int ballCount = 0;

        for (int i = 0; i < balls.getNumbers().size(); i++) {
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
            return equalCount(value, balls.getNumbers().get(computerIndex));
        }

        return 0;
    }

    private int equalCount(int num1, int num2) {
        return num1 == num2 ? 1 : 0;
    }
}
