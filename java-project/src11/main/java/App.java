import java.util.Scanner;

public class App {

    static boolean confirm(String message) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if (response.equals("y") || response.equals("yes"))
            return true;
        return false;
    }

    public static void main(String[] args) {
        Score[] scores = new Score[100];
        int cursor = 0;

        while (true) {
            Score score = new Score();
            score.input();

            scores[cursor++] = score;

            if (!confirm("계속하시겠습니까? "))
                break;
        }

        for (int i = 0; i < cursor; i++) {
            scores[i].print();
        }
    }
}
