package bitcamp.java100.ch06.ex1;

public class Score2 {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;

    void compute() {
        this.sum = this.kor + this.eng + this.math;
        this.aver = this.sum / 3f;
    }
}
