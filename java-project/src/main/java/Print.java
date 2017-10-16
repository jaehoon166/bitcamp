public class Print {
    static void print(Score score) {
        System.out.printf("%s, %3d, %3d, %3d, %3d, %5.1f\n", score.name, score.subjects[0], score.subjects[1],
                score.subjects[2], score.sum, score.aver);
    }
}