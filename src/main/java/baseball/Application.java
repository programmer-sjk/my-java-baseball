package baseball;

import baseball.model.Computer;
import baseball.view.BaseBallScreen;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static final int MIN = 100;
    public static final int MAX = 999;

    public static void main(String[] args) {
        Computer computer = new Computer(pickNumberInRange(MIN, MAX));

        BaseBallScreen.inputNumber();
        String input = readLine();
        validateInput(input);

        int strikeCount = computer.getStrikeCount(input);
        int ballCount = computer.getBallCount(input);

        BaseBallScreen.count(strikeCount, ballCount);
    }
    private static void validateInput(String input) {
        validateInputLength(input);
        validateIsInteger(input);
    }

    private static void validateInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }
    private static void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
