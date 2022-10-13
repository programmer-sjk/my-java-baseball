package baseball.controller;

import baseball.constant.GameStatus;
import baseball.model.Computer;
import baseball.util.NumberGenerator;
import baseball.view.BaseBallScreen;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameController {
    public static final int BASEBALL_NUMBER_LENGTH = 3;

    public void play() {
        Boolean isRoundFinish = false;
        Computer computer = new Computer(NumberGenerator.create(BASEBALL_NUMBER_LENGTH));

        while (isRoundFinish == false) {
            isRoundFinish = playRound(computer);
        }
    }

    private boolean playRound(Computer computer) {
        BaseBallScreen.inputNumber();
        String input = readLine();
        validateInput(input);

        int strikeCount = computer.getStrikeCount(input);
        int ballCount = computer.getBallCount(input);

        BaseBallScreen.count(strikeCount, ballCount);

        return isAllStrike(strikeCount);
    }

    public boolean restart() {
        BaseBallScreen.finish();
        return isRestart(readLine());
    }

    private boolean isRestart(String userInput) {
        if (GameStatus.RESTART.equals(userInput)) {
            return true;
        }

        if (GameStatus.STOP.equals(userInput)) {
            return false;
        }

        throw new IllegalArgumentException("게임 재시작, 종료에 올바르지 않은 값이 입력되었습니다");
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

    private boolean isAllStrike(int strikeCount) {
        return strikeCount == BASEBALL_NUMBER_LENGTH;
    }
}
