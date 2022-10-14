package baseball.controller;

import baseball.constant.Error;
import baseball.constant.GameStatus;
import baseball.model.Balls;
import baseball.model.Computer;
import baseball.util.BallsGenerator;
import baseball.util.Random;
import baseball.view.BaseBallScreen;

import static baseball.constant.BaseBall.BASEBALL_NUMBER_LENGTH;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameController {
    public void play() {
        Boolean isRoundFinish = false;
        Computer computer = new Computer(BallsGenerator.create(Random.create()));

        while (isRoundFinish == false) {
            isRoundFinish = playRound(computer);
        }
    }

    private boolean playRound(Computer computer) {
        BaseBallScreen.inputNumber();
        Balls balls = BallsGenerator.create(readLine());

        int strikeCount = computer.getStrikeCount(balls);
        int ballCount = computer.getBallCount(balls);

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

        throw new IllegalArgumentException(Error.INVALID_INPUT_RESTART.toString());
    }

    private boolean isAllStrike(int strikeCount) {
        return strikeCount == BASEBALL_NUMBER_LENGTH;
    }
}
