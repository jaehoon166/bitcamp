package bitcamp.java100.ch06.ex1;

public class Test5 {

    public static void main(String[] args) {
        Score4 score = new Score4("홍길동", 100, 80, 70);// new 명령어를 줄때 Score class형식의 메모리가 만들어진다.

        score.compute();
        
        System.out.printf("이름 = %s\n", score.name);
        System.out.printf("합계 = %d\n", score.sum);
        System.out.printf("평균 = %f\n", score.aver);
    }
}