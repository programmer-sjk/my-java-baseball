package baseball.controller;

import baseball.constant.Error;
import baseball.constant.GameStatus;
import baseball.model.Balls;
import baseball.model.Computer;
import baseball.model.Referee;
import baseball.util.BallsGenerator;
import baseball.util.Random;
import baseball.view.BaseBallScreen;
import baseball.view.Input;

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
        Balls balls = BallsGenerator.create(Input.read());
        Referee referee = new Referee(computer.getBalls(), balls);

        BaseBallScreen.count(referee.getStrikeCount(), referee.getBallCount());

        return referee.isAllStrike();
    }

    public boolean restart() {
        BaseBallScreen.finish();
        return isRestart(Input.read());
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
}
