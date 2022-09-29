package baseball;

import baseball.model.Computer;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import baseball.view.BaseBallScreen;

public class Application {
    public static final int MIN = 1;
    public static final int MAX = 9;
    public static final int BASEBALL_NUMBER_LENGTH = 3;

    public static final String RESTART_SIGNAL = "1";

    public static void main(String[] args) {
        Boolean isContinue = true;

        while (isContinue == true) {
            isContinue = play();
        }
    }

    private static boolean play() {
        Boolean isRoundFinish = false;
        Computer computer = new Computer(randomNumber());

        while (isRoundFinish == false) {
            isRoundFinish = playRound(computer);
        }

        return restart();
    }

    private static String randomNumber() {
        String result = "";

        int index = 0;
        while (index++ < BASEBALL_NUMBER_LENGTH) {
            result += String.valueOf(pickNumberInRange(MIN, MAX));
        }

        return result;
    }


    private static boolean playRound(Computer computer) {
        BaseBallScreen.inputNumber();
        String input = readLine();
        validateInput(input);

        int strikeCount = computer.getStrikeCount(input);
        int ballCount = computer.getBallCount(input);

        BaseBallScreen.count(strikeCount, ballCount);

        return matchAll(strikeCount);
    }

    private static Boolean restart() {
        BaseBallScreen.finish();
        return readLine().equals(RESTART_SIGNAL) ? true : false;
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
