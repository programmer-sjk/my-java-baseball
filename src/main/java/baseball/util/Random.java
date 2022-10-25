package baseball.util;

import java.util.*;

import static baseball.common.constant.BaseBall.BASEBALL_NUMBER_LENGTH;

public class Random {
    public static final int MIN = 1;
    public static final int MAX = 9;

    public static String create() {
        List<Integer> uniqueRandomNumbers = toSubList(shuffle(initialize()));
        String result = "";

        for (Integer number : uniqueRandomNumbers) {
            result += String.valueOf(number);
        }

        return result;
    }

    private static List<Integer> initialize() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = MIN; i <= MAX; i++) {
            numbers.add(i);
        }

        return numbers;
    }

    private static List<Integer> shuffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

    private static List<Integer> toSubList(List<Integer> numbers) {
        return numbers.subList(0, BASEBALL_NUMBER_LENGTH);
    }
}
