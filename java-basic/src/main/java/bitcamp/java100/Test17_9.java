package bitcamp.java100;

public class Test17_9 {
    static class Score {
        String name;
        int[] subject = new int[3];
        int sum;
        float aver;
    }

    static Score createMember(String name, int kor, int eng, int math) {
        Score s = new Score();
        s.name = "윤재훈";
        s.subject[0] = kor;
        s.subject[1] = eng;
        s.subject[2] = math;
        s.sum = kor + eng + math;
        s.aver = s.sum / 3f;

        return s;
    }

    static int exp(int value, int ex) {
        int sum = 1;
        for (int i = 0; i < ex; i++) {
            sum *= value;
        }
        return sum;
    }

    public static void main(String[] args) {
        Score score = createMember("윤재훈", 100, 90, 80);

        System.out.println(score.name);
        System.out.println(score.subject[0]);
        System.out.println(score.subject[1]);
        System.out.println(score.subject[2]);
        System.out.println(score.sum);
        System.out.println(score.aver);
        
        int result = exp(2, 8);
        System.out.println(result);
    }
}