//-학생 한명의 성적 점수를 출력하라!
//-이름, 국어, 영어, 수학, 총점, 평균
//이름: 홍길동
//국어: 100
//영어: 100
//수학: 100
//총점: 300
//평균: 100
public class Test1{
    
      public static void main(String[] args){
        String name = "윤재훈";
        int kor = 100;
        int eng = 100;
        int math = 100;
        int sum = kor + eng + math;
        float aver = sum /3.0f;

        System.out.printf("이름: %s\n", name);
        System.out.printf("국어: %d\n", kor);
        System.out.printf("영어: %d\n", eng);
        System.out.printf("수학: %d\n", math);
        System.out.printf("총점: %d\n", sum);
        System.out.printf("평균: %f\n", aver);
      }
    }