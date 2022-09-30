package baseball.controller;

import baseball.model.Computer;
import baseball.view.BaseBallScreen;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class GameController {
    public static final int MIN = 1;
    public static final int MAX = 9;
    public static final int BASEBALL_NUMBER_LENGTH = 3;
    public static final String RESTART_SIGNAL = "1";

    public boolean play() {
        Boolean isRoundFinish = false;
        Computer computer = new Computer(randomNumber());

        while (isRoundFinish == false) {
            isRoundFinish = playRound(computer);
        }

        return restart();
    }

    private String randomNumber() {
        String result = "";

        int index = 0;
        while (index++ < BASEBALL_NUMBER_LENGTH) {
            result += String.valueOf(pickNumberInRange(MIN, MAX));
        }

        return result;
    }


    private boolean playRound(Computer computer) {
        BaseBallScreen.inputNumber();
        String input = readLine();
        validateInput(input);

        int strikeCount = computer.getStrikeCount(input);
        int ballCount = computer.getBallCount(input);

        BaseBallScreen.count(strikeCount, ballCount);

        return matchAll(strikeCount);
    }

    private Boolean restart() {
        BaseBallScreen.finish();
        return readLine().equals(RESTART_SIGNAL) ? true : false;
    }

    private boolean matchAll(int strikeCount) {
        return strikeCount == BASEBALL_NUMBER_LENGTH;
    }

    private void validateInput(String input) {
        validateInputLength(input);
        validateIsInteger(input);
    }

    private void validateInputLength(String input) {
        if (input.length() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException("입력값 길이가 맞지 않습니다.");
        }
    }
    private void validateIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }
}
