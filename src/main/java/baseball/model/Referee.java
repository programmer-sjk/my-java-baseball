package baseball.model;

public class Referee {
    private static final int ALL_STRIKE_COUNT =3;

    private boolean allStrike = false;
    private final Balls computerBalls;
    private final Balls guessingBalls;

    public Referee(Balls computerBalls, Balls guessingBalls) {
        this.computerBalls = computerBalls;
        this.guessingBalls = guessingBalls;
    }

    public int getStrikeCount() {
        int strikeCount = 0;

        for (int i = 0; i < computerBalls.size(); i++) {
            strikeCount += equalCount(computerBalls.numberByIndex(i), guessingBalls.numberByIndex(i));
        }

        checkAllStrike(strikeCount);
        return strikeCount;
    }

    private void checkAllStrike(int strikeCount) {
        if (strikeCount == ALL_STRIKE_COUNT) {
            this.allStrike = true;
        }
    }

    public int getBallCount() {
        int ballCount = 0;

        for (int i = 0; i < guessingBalls.size(); i++) {
            ballCount += ballCount(i, guessingBalls.numberByIndex(i));
        }

        return ballCount;
    }
    private int ballCount(int index, int value) {
        int ballCount = 0;

        for (int i = 0; i < computerBalls.size(); i++) {
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
            return equalCount(value, computerBalls.numberByIndex(computerIndex));
        }

        return 0;
    }

    private int equalCount(int num1, int num2) {
        return num1 == num2 ? 1 : 0;
    }

    public boolean isAllStrike() {
        return this.allStrike;
    }
}
