package baseball.model;

import baseball.util.BallsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ComputerTest {
    @DisplayName("컴퓨터가 가지고 있는 Balls를 구할 수 있다.")
    @Test
    void 컴퓨터의_Balls_구하기() {
        Balls balls = BallsGenerator.create("138");
        Computer computer = new Computer(balls);

        assertThat(computer.getBalls().equals(balls)).isTrue();
    }
}
