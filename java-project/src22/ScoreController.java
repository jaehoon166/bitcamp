package src22;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ScoreController {
    private ArrayList<Score> list = new ArrayList<>();
    static Scanner keyScan = new Scanner(System.in);

    public void excute() {
        loop: while (true) {
            System.out.print("성적관리> ");
            String input = keyScan.nextLine();

            switch (input) {

            case "add":
                this.doAdd();
                break;

            case "list":
                this.doList();
                break;

            case "view":
                this.doView();
                break;

            case "update":
                this.doUpdate();
                break;

            case "delete":
                this.doDelete();
                break;

            case "main":
                break loop;

            default:
                App.doError();
            }
            System.out.println();
        }

    }

    private void doAdd() {
        System.out.println("[학생 등록]");

        Score score;
        while (true) {
            score = new Score();
            score.input();

            list.add(score);

            if (!Prompts.confirm("계속하시겠습니까?(Y/n) "))
                break;
        }

    }

    private void doList() {
        System.out.println("[학생 목록]");

        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }

    }

    private void doView() {
        System.out.println("[학생 정보]");
        Score score = null;

        String name = Prompts.input("이름? ");
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if (temp.name.equals(name)) {
                score = temp;
                break;
            }
        }

        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            score.printDetail();
        }

    }

    private void doUpdate() {
        System.out.println("[학생 정보 변경]");
        Score score = null;

        String name = Prompts.input("이름? ");
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if (temp.name.equals(name)) {
                score = temp;
                break;
            }
        }

        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            score.update();
        }

    }

    private void doDelete() {
        System.out.println("[학생 삭제]");
        Score score = null;

        String name = Prompts.input("이름? ");
        Iterator<Score> iterator = list.iterator();
        while (iterator.hasNext()) {
            Score temp = iterator.next();
            if (temp.name.equals(name)) {
                score = temp;
                break;
            }
        }

        if (score == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", name);
        } else {
            if (Prompts.confirm2("정말 삭제하시겠습니까?(y/N) ")) {
                list.remove(score);
                System.out.println("삭제하였습니다.");
            } else {
                System.out.println("삭제를 취소하였습니다.");
            }
        }

    }

}
