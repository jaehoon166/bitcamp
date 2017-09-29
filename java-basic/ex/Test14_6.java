package bitcamp.java100;

public class Test14_6 {

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

      }
    }
    Score[] scores = new Score[3];

    scores[0] = new Score();
    scores[1] = new Score();
    scores[2] = new Score();

    scores[0].name = "윤재훈";
    scores[0].kor = 100;
    scores[0].eng = 100;
    scores[0].math = 100;
    scores[0].compute();

    scores[1].name = "홍길동";
    scores[1].kor = 100;
    scores[1].eng = 100;
    scores[1].math = 100;
    scores[1].compute();

    scores[2].name = "임꺽정";
    scores[2].kor = 100;
    scores[2].eng = 100;
    scores[2].math = 100;
    scores[2].compute();

    Score s1 = new Score();
    s1.name = "윤재훈";
    s1.kor = 100;
    s1.eng = 100;
    s1.math = 100;
    s1.compute();

    for (int i = 0; i < scores.length; i++) {
      System.out.printf("%s\n%d\n%d\n%d\n%d\n%.1f\n", scores[i].name, scores[i].kor, scores[i].eng, scores[i].math,
          scores[i].sum, scores[i].avg);
    }
  }
}