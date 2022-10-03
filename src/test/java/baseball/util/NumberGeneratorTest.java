package baseball.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class NumberGeneratorTest {
    @DisplayName("생성되는 숫자는 모두 서로 다른 값이다")
    @RepeatedTest(10)
    void 값의_요소_유니크_테스트() {
        int expectedSize = 3;
        Set<String> set = new HashSet<String>();

        for (String value : NumberGenerator.create(expectedSize).split("")) {
            set.add(value);
        }

        assertThat(set.size()).isEqualTo(expectedSize);
    }

    @DisplayName("입력 길이만큼의 숫자를 생성한다")
    @RepeatedTest(10)
    void 숫자_길이_테스트() {
        assertThat(NumberGenerator.create(3).length()).isEqualTo(3);
    }
}
