package bitcamp.java100.ch05.Test21.Test21_8.ex1_8;
// ## 키보드로부터 입력 받기 - 연습4
// - 다음과 같이 사용자로부터 이름, 이메일, 전화를 입력받아 출력하시오!
// - 실행 예) 
// 이름? 홍길동
// 이메일? hong@test.com
// 전화? 1111-1111
// 저장하시겠습니까?(y/n) y
// 저장하였습니다.
// 계속입력하시겠습니까?(y/n) y
// 이름? 임꺽정
// 이메일? leem@test.com
// 전화? 1111-1112
// 저장하시겠습니까?(y/n) y
// 저장하였습니다.
// 계속입력하시겠습니까?(y/n) y
// 이름? 유관순
// 이메일? yoo@test.com
// 전화? 1111-1113
// 저장하시겠습니까?(y/n) n
// 저장 취소하였습니다.
// 계속입력하시겠습니까?(y/n) y
// 이름? 안중근
// 이메일? ahn@test.com
// 전화? 1111-1114
// 저장하시겠습니까?(y/n) y
// 저장하였습니다.
// 계속입력하시겠습니까?(y/n) n
// ------------------------------
// 홍길동     hong@test.com 1111-1111
// 임꺽정     leem@test.com 1111-1112
// 안중근      ahn@test.com 1111-1114
// > 


import java.io.Console;

public class Test21_8_6 {

    static Console console;
    static Contact[] contacts = new Contact[100];
    static int cursor = 0;

    static boolean confirm(String message) {
        String inpute = console.readLine(message + "(y/n)");
        if (inpute.toLowerCase().equals("y") || inpute.toLowerCase().equals("yes")) {
            return true;
        }
        return false;
    }

    static Contact inputContact() {
        Contact contact = new Contact();

        contact.name = console.readLine("이름? ");
        contact.email = console.readLine("이메일? ");
        contact.phone = console.readLine("전화? ");

        return contact;
    }

    static class Contact {
        String name;
        String email;
        String phone;
    }

    static void printContacts() {
        for (int i = 0; i < cursor; i++) {
            // 저장된 고객 정보 출력하기
            System.out.printf("%s, %s, %s\n", contacts[i].name, contacts[i].email, contacts[i].phone);
        }
    }

    public static void main(String[] args) {

        console = System.console();
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }

        while (cursor < contacts.length) {
            Contact contact = inputContact();

            if (confirm("저장하시겠습니까?")) {
                contacts[cursor] = contact;
                cursor++;
            }
            if (!confirm("계속하시겠습니까?"))
                break;
        }
        printContacts();
    }
}