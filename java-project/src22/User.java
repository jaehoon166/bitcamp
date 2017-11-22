package src22;
import java.util.Scanner;

public class User {

    protected String name;
    protected String email;
    protected String pw;

    public User() {

    }

    public User(String name, String email, String pw) {
        this.name = name;
        this.email = email;
        this.pw = pw;
    }

    public void printDetail() {
        System.out.printf("이름: %s\nID : %s\nPW : %s\n", this.name, this.email, this.pw);
    }

    public void print() {
        System.out.printf("%-4s, %s\n", this.name, this.email);
    }

    public void input() {
        Scanner keyScan = new Scanner(System.in);

        System.out.print("이름? ");
        this.name = keyScan.nextLine();

        System.out.print("Email? ");
        this.email = keyScan.nextLine();

        System.out.print("PW? ");
        this.pw = keyScan.nextLine();
    }

    public void update() {
        Scanner keyScan = new Scanner(System.in);

        System.out.printf("이름?(%s) ", this.name);
        String name = keyScan.nextLine();
        if(name.isEmpty()) {
            name=this.name;
        }

        System.out.printf("PW?(%s) ", this.pw);
        String pw = keyScan.nextLine();
        if(pw.isEmpty()) {
            pw=this.pw;
        }

        if (Prompts.confirm2("변경하시겠습니까?(y/N) ")) {
            this.name = name;
            this.pw = pw;
            System.out.println("변경하였습니다.");

        } else {
            System.out.println("변경을 취소하였습니다.");
        }
    }
}
