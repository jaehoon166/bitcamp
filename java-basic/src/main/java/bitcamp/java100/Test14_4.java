package bitcamp.java100;

public class Test14_4 {

  public static void main(String[] age) {
    class Score {
      String name;
      int kor;
      int eng;
      int math;
      int sum;
      float avg;
    }
    Score s1 = new Score();//s1 메모리 시작주소:200
    s1.name = "윤재훈";
    s1.kor = 100;
    s1.eng = 100;
    s1.math = 100;
    s1.sum = s1.kor + s1.eng + s1.math;
    s1.avg = s1.sum / 3.0f;

    System.out.printf("%s\n%d\n%d\n%d\n%d\n%.1f\n",
     s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.avg);

    Score s2 = s1;//s2시작번지를 s1시작번지로->s2의 메모리 시작주소:200

    s1 = new Score();
    //s1에 Sorce형식의 새로운 메모리 부여 (ex. s1의 시작주소 :300)

    s1.name = "임꺽정";
    s1.kor = 90;
    s1.eng = 90;
    s1.math = 90;
    s1.sum = s1.kor + s1.eng + s1.math;
    s1.avg = s1.sum / 3.0f;

    System.out.printf("%s\n%d\n%d\n%d\n%d\n%.1f\n",
     s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.avg);

    System.out.printf("%s\n%d\n%d\n%d\n%d\n%.1f",
     s2.name, s2.kor, s2.eng, s2.math, s2.sum, s2.avg);
  }
}