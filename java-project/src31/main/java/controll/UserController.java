package controll;

import java.util.Iterator;

import domain.User;
import utill.App;
import utill.Prompts;

public class UserController extends GenericController<User> {

    @Override
    public void excute() {
        loop: while (true) {
            System.out.print("회원관리> ");
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
        System.out.println("[학생 삭제]");
        String email = Prompts.inputString("Email? ");

        User user = findByEmail(email);

        if (user == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", email);
            return;
        }

        if (Prompts.confirm2("정말 삭제하시겠습니까?(y/N) ")) {
            list.remove(user);
            System.out.println("삭제하였습니다.");
        } else {
            System.out.println("삭제를 취소하였습니다.");
        }
    }

    private void doUpdate() {
        System.out.println("[회원 정보 수정]");
        String email = Prompts.inputString("Email? ");

        User user = findByEmail(email);
        if (user == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
        } else {

            String name = Prompts.inputString("이름?(%s)", user.getName());
            if (name.isEmpty()) {
                name = user.getName();
            }

            String pw = Prompts.inputString("암호? ");
            if (pw.isEmpty()) {
                pw = user.getPw();
            }

            if (Prompts.confirm2("변경하시겠습니까?(y/N) ")) {
                user.setName(name);
                user.setPw(pw);
                System.out.println("변경하였습니다.");

            } else {
                System.out.println("변경을 취소하였습니다.");
            }
        }
    }

    private void doView() {
        String email = Prompts.inputString("Email? ");

        User user = findByEmail(email);
        if (user == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
            return;
        }
        System.out.printf("이름: %s\nID : %s\nPW : %s\n", user.getName(), user.getEmail(), user.getPw());
    }

    private void doAdd() {
        System.out.println("[회원 등록]");
        User user = new User();

        user.setName(Prompts.inputString("이름? "));
        user.setEmail(Prompts.inputString("Email? "));
        if (findByEmail(user.getEmail()) != null) {
            System.out.println("이미 등록된 Email입니다.");
            return;
        }

        user.setPw(Prompts.inputString("PW? "));

        list.add(user);
    }

    private void doList() {
        System.out.println("[회원 목록]");

        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            System.out.printf("%-4s, %s\n", user.getName(), user.getEmail());
        }
    }

    private User findByEmail(String email) {
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }
}
