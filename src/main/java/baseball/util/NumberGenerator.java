package baseball.util;

import java.util.LinkedHashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NumberGenerator {
    public static final int MIN = 1;
    public static final int MAX = 9;

    public static String create(int length) {
        Set<String> result = new LinkedHashSet<>();

        while (result.size() < length) {
            result.add(String.valueOf(pickNumberInRange(MIN, MAX)));
        }

        return String.join("", result);
    }
}
