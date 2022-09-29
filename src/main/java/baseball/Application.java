package baseball;

import baseball.model.Computer;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import baseball.view.BaseBallScreen;

public class Application {
    public static final int MIN = 100;
    public static final int MAX = 999;
    public static final int BASEBALL_NUMBER_LENGTH = 3;

    public static void main(String[] args) {
        Boolean isFinish = false;
        Computer computer = new Computer(pickNumberInRange(MIN, MAX));

        while(isFinish == false) {
            isFinish = play(computer);
        }
    }

    private static boolean play(Computer computer) {
        BaseBallScreen.inputNumber();
        String input = readLine();
        validateInput(input);

        int strikeCount = computer.getStrikeCount(input);
        int ballCount = computer.getBallCount(input);

        BaseBallScreen.count(strikeCount, ballCount);

        return matchAll(strikeCount);
    }

    private static boolean matchAll(int strikeCount) {
        return strikeCount == BASEBALL_NUMBER_LENGTH;
    }

    private static void validateInput(String input) {
        validateInputLength(input);
        validateIsInteger(input);
    }

    private static void validateInputLength(String input) {
        if (input.length() != BASEBALL_NUMBER_LENGTH) {
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
