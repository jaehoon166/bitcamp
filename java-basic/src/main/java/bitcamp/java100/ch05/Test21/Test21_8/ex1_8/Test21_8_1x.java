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

public class Test21_8_1x {

    static Console console;

    static void prepareConsole() {
        console = System.console();
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }
    }

    static StringBuffer inputUser() {
        String name = console.readLine("이름? ");
        StringBuffer ubuf = new StringBuffer();
        ubuf.append(name);

        String email = console.readLine("이메일? ");
        ubuf.append(email);

        String phone = console.readLine("전화? ");
        ubuf.append(phone);

        return ubuf;
    }

    
    static void printUsers(StringBuffer buf) {
        System.out.printf("%s\n", buf);
    }

    public static void main(String[] args) {

        prepareConsole();

        //users배열을 생성하고 users배열에 user정보 넣기
        StringBuffer users[] = new StringBuffer[3];
        int cursor = 0;
        for (cursor = 0; cursor < users.length; cursor++) {
            users[cursor] = inputUser();
        }

        //users배열에 있는 user정보 출력
        for (cursor = 0; cursor < users.length; cursor++) {
            printUsers(users[cursor]);
        }
    }
}