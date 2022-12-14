package baseball.view;

import baseball.view.enums.ResultType;

public class Output {
    public static void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void gameResult(int strikeCount, int ballCount) {
        ballCount(ballCount);
        strikeCount(strikeCount);
        nothingCount(strikeCount, ballCount);

        System.out.println();
    }

    private static void ballCount(int ballCount) {
        if (ballCount > 0) {
            System.out.print(ballCount + ResultType.BALL.getDescription() + " ");
        }
    }

    private static void strikeCount(int strikeCount) {
        if (strikeCount > 0) {
            System.out.print(strikeCount + ResultType.STRIKE.getDescription());
        }
    }

    private static void nothingCount(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print(ResultType.NOTHING.getDescription());
        }
    }

    public static void finish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
