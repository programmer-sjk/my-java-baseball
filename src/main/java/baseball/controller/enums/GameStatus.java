package baseball.controller.enums;

public enum GameStatus {
    RESTART("1"),
    STOP("2");

    private final String flag;

    GameStatus(String flag) {
        this.flag = flag;
    }

    public static boolean isRestart(String flag) {
        return flag == GameStatus.RESTART.flag;
    }

    public static boolean isStop(String flag) {
        return flag == GameStatus.STOP.flag;
    }
}
