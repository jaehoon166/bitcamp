package bitcamp.java100.ch06.ex1;

public class Test4 {

    public static void main(String[] args) {
        Score3 score = new Score3();// new 명령어를 줄때 Score class형식의 메모리가 만들어진다.

        score.compute();
        
        System.out.printf("이름 = %s\n", score.name);
        System.out.printf("합계 = %d\n", score.sum);
        System.out.printf("평균 = %f\n", score.aver);
        
        score = new Score3();
    }
}