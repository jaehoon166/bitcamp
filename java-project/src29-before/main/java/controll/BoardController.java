package controll;

import java.sql.Date;
import java.util.Iterator;

import domain.Board;
import utill.App;
import utill.Prompts;

public class BoardController extends GenericController<Board> {

    @Override
    public void excute() {
        loop: while (true) {
            System.out.print("게시판> ");
            String input = keyScan.nextLine().toLowerCase();
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

    private void doDelete() {
        System.out.println("[게시물 삭제]");
        int num = Prompts.inputInt("번호? ");

        Board board = FindByNum(num);

        if (board == null) {
            System.out.printf("%d번 게시물이 없습니다.\n", num);
        } else {
            if (Prompts.confirm2("정말 삭제하시겠습니까?(y/N) ")) {
                list.remove(board);
                System.out.println("삭제하였습니다.");
            } else {
                System.out.println("삭제를 취소하였습니다.");
            }
        }
    }

    private void doUpdate() {
        System.out.println("[게시물 변경]");
        int num = Prompts.inputInt("번호? ");

        Board board = FindByNum(num);

        if (board == null) {
            System.out.printf("%d번 게시물이 없습니다.\n", num);
        }

        System.out.printf("제목?(%s) ", board.getTitle());
        String title = keyScan.nextLine();
        if (title.isEmpty()) {
            title = board.getTitle();
        }

        System.out.printf("내용? ", board.getContents());
        String content = keyScan.nextLine();

        if (Prompts.confirm2("변경하시겠습니까?(y/N) ")) {
            board.setTitle(title);
            board.setContents(content);
            board.setRegdate(new Date(System.currentTimeMillis()));
            System.out.println("변경하였습니다.");

        } else {
            System.out.println("변경을 취소하였습니다.");
        }
    }

    private void doView() {
        System.out.println("[게시물 상세 정보]");
        int num = Prompts.inputInt("번호? ");

        Board board = FindByNum(num);

        if (board == null) {
            System.out.printf("'%d'의 회원 정보가 없습니다.\n", num);
        }
        System.out.printf("제목: %s\n내용: %s\n등록일: %s\n", board.getTitle(), board.getContents(),
                board.getRegdate().toString());
        board.setViewCount(board.getViewCount() + 1);
        System.out.printf("조회수: %d\n", board.getViewCount());

    }

    private void doList() {
        System.out.println("[게시물 목록]");

        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            System.out.printf("%d, %s, %s, %d\n", board.getNum(), board.getTitle(), board.getRegdate(),
                    board.getViewCount());
        }
    }

    private void doAdd() {
        System.out.println("[게시물 등록]");

        Board board = new Board();
        board.setNum(Prompts.inputInt("번호? "));

        if (FindByNum(board.getNum()) != null) {
            System.out.println("이미 등록된 번호입니다.");
            return;
        }

        board.setTitle(Prompts.inputString("제목? "));
        board.setContents(Prompts.inputString("내용? "));
        board.setRegdate(new Date(System.currentTimeMillis()));

        list.add(board);
    }

    private Board FindByNum(int num) {
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            if (board.getNum() == num) {
                return board;
            }
        }
        return null;
    }
}
