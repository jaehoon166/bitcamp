package bitcamp.java100.ch02;

public class Test14_5 {

  public static void main(String[] age) {
    class Score {
      String name;
      int kor;
      int eng;
      int math;
      int sum;
      float avg;

      void compute() {
        sum = kor + eng + math;
        avg = sum / 3.0f;

        Score s1 = new Score();
        s1.name = "윤재훈";
        s1.kor = 100;
        s1.eng = 100;
        s1.math = 100;
        s1.compute();

        System.out.printf("%s\n%d\n%d\n%d\n%d\n%.1f\n",
        s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.avg);
   
       Score s2 = s1;
       s1 = new Score();
   
       s1.name = "임꺽정";
       s1.kor = 90;
       s1.eng = 90;
       s1.math = 90;
       s1.compute();
   
       System.out.printf("%s\n%d\n%d\n%d\n%d\n%.1f\n",
        s1.name, s1.kor, s1.eng, s1.math, s1.sum, s1.avg);
        
       System.out.printf("%s\n%d\n%d\n%d\n%d\n%.1f",
        s2.name, s2.kor, s2.eng, s2.math, s2.sum, s2.avg);
      }
    }
  }
}