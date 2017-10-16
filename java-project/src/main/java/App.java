public class App {

    public static void main(String[] args) {

        Score scores[] = new Score[3];
        scores[0] = new Score();
        scores[1] = new Score();
        scores[2] = new Score();

        Init.init(scores[0], "홍길동", 100, 90, 80);
        Init.init(scores[1], "임꺽정", 80, 80, 80);
        Init.init(scores[2], "유관순", 100, 100, 100);

        for (Score s : scores) {
            Print.print(s);
        }
    }
}
