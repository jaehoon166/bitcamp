package bitcamp.java100.ch06.ex1;

public class Score7 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    Score7() {
        this("홍길동");
    }

    Score7(String name) {
        this(name, 50, 50, 50);
        }

    Score7(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;

        this.compute();
    }

    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
}