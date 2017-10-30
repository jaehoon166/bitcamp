package bitcamp.java100.ch06.ex5;

import java.util.Scanner;

public class Score2 {

    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    void input() {
        Scanner keyScan = new Scanner(System.in);

        System.out.print("이름? ");
        this.name = keyScan.nextLine();

        System.out.print("국어? ");
        this.kor = keyScan.nextInt();

        System.out.print("영어? ");
        this.eng = keyScan.nextInt();

        System.out.print("수학? ");
        this.math = keyScan.nextInt();

        this.compute();
        // keyScan.close();
    }

    void compute() {
        this.sum = kor + eng + math;
        this.aver = sum / 3f;
    }

    void print() {
        System.out.printf("%s, %d, %d, %d, %d, %f\n", this.name, this.kor, this.eng, this.math, this.sum, this.aver);
    }

}
