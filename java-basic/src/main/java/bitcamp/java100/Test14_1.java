package bitcamp.java100;

public class Test14_1 {

  public static void main(String[] age) {
    class Score{
      String name;
      int kor;
      int eng;
      int math;
      int sum;
      float avg;

    }
    Score r1;
    r1 = new Score();

    r1.name = "홍길동";
    r1.kor = 100;
    r1.eng = 100;
    r1.math = 100;
    r1.sum = r1.kor+r1.eng+r1.math;
    r1.avg = r1.sum/3.0f;

    System.out.printf("%s,%4d,%4d,%4d,%4d,%6.1f", 
    r1.name,r1.kor,r1.eng,r1.math,r1.sum,r1.avg);
  }
}