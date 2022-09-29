package baseball.model;

public class Computer {
    private final String number;

    public Computer(int number) {
        this.number = String.valueOf(number);
    }

    public int getStrikeCount(String input) {
        int strikeCount = 0;
        for (int i = 0; i < number.length(); i++) {
            strikeCount += isEqual(number.charAt(i), input.charAt(i));
        }

        return strikeCount;
    }

    public int getBallCount(String input) {
        int ballCount = 0;
        for (int i = 0; i < input.length(); i++) {
            ballCount += ballCount(i, input.charAt(i));
        }

        return ballCount;
    }

    private int ballCount(int index, char value) {
        int ballCount = 0;
        for (int i = 0; i < number.length(); i++) {
            ballCount += countIfDifferentPositionEqual(index, i, value);
        }

        return ballCount;
    }

    private int countIfDifferentPositionEqual(
            int inputIndex,
            int computerIndex,
            char value
    ) {
        if (inputIndex != computerIndex) {
            return isEqual(value, number.charAt(computerIndex));
        }

        return 0;
    }

    private int isEqual(int num1, int num2) {
        return num1 == num2 ? 1 : 0;
    }
}
