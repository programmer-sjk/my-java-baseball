package baseball.util;

import java.util.LinkedHashSet;
import java.util.Set;

import static baseball.constant.BaseBall.BASEBALL_NUMBER_LENGTH;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Random {
    public static final int MIN = 1;
    public static final int MAX = 9;

    public static String create() {
        Set<String> result = new LinkedHashSet<>();

        while (result.size() < BASEBALL_NUMBER_LENGTH) {
            result.add(String.valueOf(pickNumberInRange(MIN, MAX)));
        }

        return String.join("", result);
    }
}
