package bitcamp.java100.ch13.ex4;

import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {

    static class Score {
        String name;
        int kor;
        int eng;
        int math;
        int sum;
        float aver;
    }

    static ArrayList<Score> list = new ArrayList<>();
    static Scanner keyScan = new Scanner(System.in);

    static void input() throws Exception {
        Score score = new Score();
        System.out.println("이름? ");

        score.name = keyScan.nextLine();
        if (score.name.length() == 0) {
            throw new Exception("EmptyString");
        }

        System.out.println("국어? ");
        try {
            score.kor = Integer.parseInt(keyScan.nextLine());
            if (score.kor < 0 || score.kor > 100) {
                throw new Exception("ScoreOutOfBounds");
            }
        } catch (Exception e) {
            throw new Exception("NumberFormatError");
        }

        System.out.println("영어? ");
        try {
            score.eng = Integer.parseInt(keyScan.nextLine());
            if (score.eng < 0 || score.eng > 100) {
                throw new Exception("ScoreOutOfBounds");
            }
        } catch (Exception e) {
            throw new Exception("NumberFormatError");
        }

        System.out.println("수학? ");
        try {
            score.math = Integer.parseInt(keyScan.nextLine());
            if (score.math < 0 || score.math > 100) {
                throw new Exception("ScoreOutOfBounds");
            }
        } catch (Exception e) {
            throw new Exception("NumberFormatError");
        }

        score.sum = score.kor + score.eng + score.math;

        score.aver = score.sum / 3f;

        list.add(score);
    }

    static void print() {
        for (Score score : list) {
            System.out.printf("%s, %d, %d, %d, %d, %.1f\n", score.name, score.kor, score.eng, score.math, score.sum,
                    score.aver);
        }
    }

    static void m1() throws Exception {
        throw new Exception();
    }

    static void m2() throws Exception {
        throw new Exception("이래서... 저래서... 예외가 발생했어요.");
    }

    public static void main(String[] args) {
        while (true) {
            try {
                input();
            } catch (Exception e) {
                String message = e.getMessage();

                if (message.equals("EmptyString")) {
                    System.out.println("입력 문자열이 비어 있습니다.");
                } else if (message.equals("ScoreOutOfBounds")) {
                    System.out.println("점수의 범위를 벗어났습니다.");
                } else if (message.equals("NumberFormatError")) {
                    System.out.println("숫자의 형식이 아닙니다.");
                }
            }

            System.out.println("계속하시겠습니까?(Y/n)");
            String str = keyScan.nextLine().toLowerCase();
            if (str.equals("") || str.equals("y") || str.equals("yes")) {
                continue;
            }
            break;
        }
        System.out.println("-------------------------------------------");
        print();
    }

}
