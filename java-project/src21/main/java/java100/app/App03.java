package java100.app;

import java.util.Scanner;

public class App03 {

    static Scanner keyScan = new Scanner(System.in);

    public static void main(String[] args) {
        ScoreController scoreController = new ScoreController();

        loop: while (true) {
            System.out.print("명령> ");
            String input = keyScan.nextLine();

            switch (input) {
            case "menu":
                doMenu();
                break;
            case "help":
                doHelp();
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

    private static void doHelp() {
        System.out.println("[명령]");
        System.out.println("menu        - 메뉴 목록 출력한다.");
        System.out.println("go 번호     - 메뉴로 이동한다.");
        System.out.println("quit        - 프로그램을 종료한다.");
    }

    private static void doMenu() {
        System.out.println("1 성적관리");
        System.out.println("2 회원관리");
        System.out.println("3 게시판");
    }

    private static void doError() {
        System.out.println("실행할 수 없는 명령입니다.");
    }

    private static void doQuit() {
        System.out.println("프로그램을 종료합니다.");
    }

}
