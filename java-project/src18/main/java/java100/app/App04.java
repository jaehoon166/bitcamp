package java100.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App04 {

    static boolean confirm(String message) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if (response.equals("y") || response.equals("yes") || response.equals("")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);

        ArrayList<Score> list = new ArrayList<>();

        loop: while (true) {
            System.out.print("성적관리> ");
            String input = keyScan.nextLine();

            switch (input) {
            case "add":
                System.out.println("[학생 등록]");

                while (true) {
                    Score score = new Score();
                    score.input();

                    list.add(score);

                    if (!confirm("계속하시겠습니까?(Y/n) "))
                        break;
                }

                break;
            case "list":
                System.out.println("[학생 목록]");

                Iterator<Score> iterator = list.iterator();
                while (iterator.hasNext()) {
                    iterator.next().print();
                }

                break;
            case "view":
                System.out.println("[학생 정보]");
                break;
            case "update":
                System.out.println("[학생 정보 변경]");
                break;
            case "delete":
                System.out.println("[학생 삭제]");
                break;
            case "quit":
                System.out.println("프로그램을 종료합니다.");
                break loop;
            default:
                System.out.println("실행할 수 없는 명령입니다.");
            }

            System.out.println();
        }

    }
}
