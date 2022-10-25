package baseball.model;

import baseball.constant.Error;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {
    private static Balls balls;

    @BeforeAll
    static void setUp() {
        balls = Balls.create(Arrays.asList(Ball.create(1), Ball.create(2), Ball.create(3)));
    }

    @DisplayName("Balls가 가진 Ball 크기를 구할수 있다.")
    @Test
    void 사이즈를_구할수있다() {
        assertThat(balls.size()).isEqualTo(3);
    }

    @DisplayName("특정 위치에 있는 Ball의 값을 구할 수 있다.")
    @Test
    void 특정_공_값_구하기() {
        assertThat(balls.numberByIndex(0)).isEqualTo(1);
    }

    @DisplayName("Balls의 값은 중복될 수 없다.")
    @Test
    void 숫자_중복_예외_테스트() {
        assertThatThrownBy(() ->
            Balls.create(Arrays.asList(Ball.create(1), Ball.create(1), Ball.create(1)))
        )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.INVALID_LENGTH.toString());
    }
}
