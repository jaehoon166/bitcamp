package src22;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class UserController {
    private ArrayList<User> list = new ArrayList<>();
    static Scanner keyScan = new Scanner(System.in);

    public void excute() {
        loop: while (true) {
            System.out.print("회원관리> ");
            String input = keyScan.nextLine().toLowerCase();
            switch (input) {
            case "add":
                this.userAdd();
                break;

            case "list":
                this.userList();
                break;

            case "view":
                this.userView();
                break;

            case "update":
                this.userUpdate();
                break;

            case "delete":
                this.userDelete();
                break;

            case "main":

                break loop;

            default:
                break;
            }
        }
    }

    private void userDelete() {
        System.out.println("[학생 삭제]");
        User user = null;

        String email = Prompts.input("Email? ");
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            User temp = iterator.next();
            if (temp.email.equals(email)) {
                user = temp;
                break;
            }
        }

        if (user == null) {
            System.out.printf("'%s'의 성적 정보가 없습니다.\n", email);
        } else {
            if (Prompts.confirm2("정말 삭제하시겠습니까?(y/N) ")) {
                list.remove(user);
                System.out.println("삭제하였습니다.");
            } else {
                System.out.println("삭제를 취소하였습니다.");
            }
        }
    }

    private void userUpdate() {
        User user = null;

        String email = Prompts.input("Email? ");
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            User temp = iterator.next();
            if (temp.email.equals(email)) {
                user = temp;
                break;
            }
        }

        if (user == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
        } else {
            user.update();
        }
    }

    private void userView() {
        User user = null;

        String email = Prompts.input("Email? ");
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            User temp = iterator.next();
            if (temp.email.equals(email)) {
                user = temp;
                break;
            }
        }

        if (user == null) {
            System.out.printf("'%s'의 회원 정보가 없습니다.\n", email);
        } else {
            user.printDetail();
        }
    }

    private void userAdd() {
        User user;
        user = new User();
        user.input();

        boolean isExist = false;
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().email.equals(user.email)) {
                isExist = true;
                break;
            }
        }

        if (isExist) {
            System.out.println("이미 등록된 Email입니다.");
        } else
            list.add(user);
    }

    private void userList() {
        Iterator<User> iterator = list.iterator();
        while (iterator.hasNext()) {
            iterator.next().print();
        }
    }

}
