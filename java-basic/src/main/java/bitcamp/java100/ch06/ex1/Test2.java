package bitcamp.java100.ch06.ex1;

public class Test2 {

    public static void main(String[] args) {
        Score score = new Score();// new 명령어를 줄때 Score class형식의 메모리가 만들어지다.

        score.name = "홍길동";// 따라서 Score class형식의 score메모리에 있는 name에 "홍길동"
        score.kor = 100;
        score.eng = 100;
        score.math = 100;

        score.sum = score.kor + score.eng + score.math;
        score.aver = score.sum / 3f;
    }
}