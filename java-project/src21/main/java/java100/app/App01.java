package java100.app;

import java.util.Scanner;

public class App01 {

    static Scanner keyScan = new Scanner(System.in);

    public static void main(String[] args) {
        ScoreController scoreController = new ScoreController();

        loop: while (true) {
            System.out.print("명령> ");
            String input = keyScan.nextLine();
            System.out.println(input);

            System.out.println();
        }

    }

    private static void doError() {
        System.out.println("실행할 수 없는 명령입니다.");
    }

    private static void doQuit() {
        System.out.println("프로그램을 종료합니다.");
    }

}
