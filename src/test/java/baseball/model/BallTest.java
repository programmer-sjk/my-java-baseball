package baseball.model;

import baseball.constant.Error;
import baseball.util.BallsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {
    @DisplayName("공이 가진 숫자를 얻을 수 있다.")
    @Test
    void 공이_가진_숫자를_구한다() {
        int expected = 3;
        Ball ball = new Ball(expected);
        assertThat(ball.getNumber()).isEqualTo(expected);
    }

    @DisplayName("숫자는 1과 9 사이여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "10"})
    void 숫자_범위_예외_테스트(int input) {
        assertThatThrownBy(() -> new Ball(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(Error.INVALID_RANGE.toString());
    }
}
