package baseball.controller;

import baseball.constant.Error;
import baseball.constant.GameStatus;
import baseball.model.Balls;
import baseball.model.Computer;
import baseball.model.Referee;
import baseball.util.BallsGenerator;
import baseball.util.Random;
import baseball.view.Output;
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
        Output.inputNumber();
        Balls balls = BallsGenerator.create(Input.read());
        Referee referee = new Referee(computer.getBalls(), balls);

        Output.gameResult(referee.getStrikeCount(), referee.getBallCount());

        return referee.isAllStrike();
    }

    public boolean restart() {
        Output.finish();
        return isRestart(Input.read());
    }

    private boolean isRestart(String userInput) {
        if (GameStatus.isRestart(userInput)) {
            return true;
        }

        if (GameStatus.isStop(userInput)) {
            return false;
        }

        throw new IllegalArgumentException(Error.INVALID_INPUT_RESTART.toString());
    }
}
