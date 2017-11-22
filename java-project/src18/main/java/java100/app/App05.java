package java100.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App05 {

    static Scanner keyScan = new Scanner(System.in);

    static String prompt(String message) {
        System.out.print(message);
        return keyScan.nextLine();
    }

    static boolean confirm(String message) {
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if (response.equals("y") || response.equals("yes") || response.equals("")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<Score> list = new ArrayList<>();
        Iterator<Score> iterator;

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

                iterator = list.iterator();
                while (iterator.hasNext()) {
                    iterator.next().print();
                }

                break;
            case "view":
                System.out.println("[학생 정보]");
                String name = prompt("이름? ");

                Score score = null;
                iterator = list.iterator();
                while (iterator.hasNext()) {
                    Score temp = iterator.next();
                    if (temp.name.equals(name)) {
                        score = temp;
                        break;
                    }
                }

                if (score == null) {
                    System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
                } else {
                    score.printDetail();
                }
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
