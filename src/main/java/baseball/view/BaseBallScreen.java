package baseball.view;

public class BaseBallScreen {
    public static void inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void count(int strikeCount, int ballCount) {
        if (ballCount > 0) {
            System.out.print(ballCount + "볼 ");
        }

        if (strikeCount > 0) {
            System.out.print(strikeCount + "스트라이크");
        }

        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }

        System.out.println();
    }
}
