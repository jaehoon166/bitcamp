package src22;
import java.util.Scanner;

public class App {

    static Scanner keyScan = new Scanner(System.in);
    static ScoreController scoreController = new ScoreController();
    static UserController userController = new UserController();

    public static void main(String[] args) {

        loop: while (true) {
            System.out.print("명령> ");
            String[] input = keyScan.nextLine().toLowerCase().split(" ");
            try {
                switch (input[0]) {

                case "menu":
                    doMenu();
                    break;

                case "help":
                    doHelp();
                    break;

                case "quit":
                    doQuit();
                    break loop;

                case "go":
                    doGo(input[1]);
                    break;

                default:
                    menuError();
                    break;
                }
            } catch (Exception e) {
                System.out.println("명령처리중 오류발생!");
            }
            System.out.println();
        }

    }

    private static void doGo(String menuNo) {
        switch (menuNo) {
        case "1":
            scoreController.excute();
            break;

        case "2":
            userController.excute();
            break;

        case "3":
            System.out.println("게시판");
            break;
        default:
            System.out.println("해당 번호의 메뉴가 없습니다.");
            break;
        }
    }

    private static void doHelp() {
        System.out.println("[명령]");
        System.out.println("menu    -메뉴 목록을 출력한다.");
        System.out.println("go 번호    -메뉴로 이동한다.");
        System.out.println("quit    -프로그램을 종료한다.");
    }

    private static void doMenu() {
        System.out.println("1 성적관리");
        System.out.println("2 회원관리");
        System.out.println("3 게시판");
    }

    private static void menuError() {
        System.out.println("잘못된 명령입니다.");
    }

    protected static void doError() {
        System.out.println("실행할 수 없는 명령입니다.");
    }

    protected static void doQuit() {
        System.out.println("프로그램을 종료합니다.");
    }

}
