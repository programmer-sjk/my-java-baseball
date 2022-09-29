package baseball;

import baseball.model.Computer;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static final int MIN = 100;
    public static final int MAX = 999;

    public static void main(String[] args) {
        Computer computer = new Computer(pickNumberInRange(MIN, MAX));
    }
}
