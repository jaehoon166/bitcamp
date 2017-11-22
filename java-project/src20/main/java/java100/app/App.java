package java100.app;

import java.util.Scanner;

public class App {

    static Scanner keyScan = new Scanner(System.in);

    public static void main(String[] args) {
        ScoreController scoreController = new ScoreController();

        loop: while (true) {
            System.out.print("성적관리> ");
            String input = keyScan.nextLine();

            switch (input) {
            case "add":
                scoreController.doAdd();
                break;
            case "list":
                scoreController.doList();
                break;
            case "view":
                scoreController.doView();
                break;
            case "update":
                scoreController.doUpdate();
                break;
            case "delete":
                scoreController.doDelete();
                break;
            case "quit":
                doQuit();
                break loop;
            default:
                doError();
            }

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
