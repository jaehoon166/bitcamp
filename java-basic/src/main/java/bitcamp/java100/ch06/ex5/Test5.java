package bitcamp.java100.ch06.ex5;

import java.util.Scanner;

public class Test5 {

    static boolean confirm(String message) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print(message);

        String response = keyScan.nextLine().toLowerCase();

        if (response.equals("y") || response.equals("yes")) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Score2 scores[] = new Score2[100];

        int cursor = 0;
        while (true) {
            Score2 score = new Score2();
            score.input();

            scores[cursor++] = score;

            if (!confirm("계속하시겠습니까?")) {// confirm message 보기
                break;
            }
        }

        for (int i = 0; i < cursor; i++) {
            scores[i].print();
        }
    }
}
