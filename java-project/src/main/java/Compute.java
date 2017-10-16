public class Compute {
    static void compute(Score score) {
        for (int sub : score.subjects) {
            score.sum += sub;
        }
        score.aver = score.sum / 3f;
    }
}