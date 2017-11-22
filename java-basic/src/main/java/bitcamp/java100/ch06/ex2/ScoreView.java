package bitcamp.java100.ch06.ex2;

import java.io.Console;

public class ScoreView {
    static void inputScore(Score score) {

        Console console = System.console();

        score.name = console.readLine("이름? ");
        score.kor = Integer.parseInt(console.readLine("국어? "));
        score.eng = Integer.parseInt(console.readLine("영어? "));
        score.math = Integer.parseInt(console.readLine("수학? "));
        score.sum = score.kor + score.eng + score.math;
        score.aver = score.sum / 3f;
    }

    static void printScore(Score score) {
        System.out.printf("%10s, %3d, %3d, %3d, %3d, %5.2f\n", score.name, score.kor, score.eng, score.math, score.sum,
                score.aver);
    }
}
