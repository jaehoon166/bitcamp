package bitcamp.java100.ch06.ex1;

public class Test3 {

    public static void main(String[] args) {
        Score2 score = new Score2();// new 명령어를 줄때 Score class형식의 메모리가 만들어진다.

        score.name = "홍길동";// 따라서 Score class형식의 score메모리에 있는 name에 "홍길동"
        score.kor = 100;
        score.eng = 100;
        score.math = 100;

        score.compute();
    }
}