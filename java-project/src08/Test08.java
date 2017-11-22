package src08;

public class Test08 {

    static void compute(Score scores) {
        for (int sub : scores.subjects) {
            scores.sum += sub;
        }
        scores.aver = scores.sum / 3f;
    }

    static void init(Score scores, String name, int kor, int eng, int math) {
        scores.name = "홍길동";
        scores.subjects[0] = 100;
        scores.subjects[1] = 90;
        scores.subjects[2] = 80;

        compute(scores);
    }

    static void print(Score score) {
        System.out.printf("%-4s, %4d, %4d, %4d, %4d, %6.1f\n", 
                score.name,
                score.subjects[0],
                score.subjects[1],
                score.subjects[2],
                score.sum, score.aver);
    }
    public static void main(String[] args) {

        Score[] scores = { new Score(), new Score(), new Score() };

        init(scores[0], "홍길동", 100, 90, 80);
        init(scores[1], "홍길동", 100, 90, 80);
        init(scores[2], "홍길동", 100, 90, 80);

        for (Score s : scores) {
            print(s);

        }
    }
}