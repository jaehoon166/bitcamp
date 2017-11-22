package bitcamp.java100.ch02;

public class Test16_3 {

    public static void main(String[] args) {
        int level = 2;
        switch (level) {
        case 0:
            System.out.println("손님");
            break;
        case 1:
            System.out.println("회원");
            break;
        case 2:
            System.out.println("관리자");
            break;
        case 3:
            System.out.println("유효하지않은회원");
        }

        byte b = 10;
        short s = 10;
        int i = 10;
        char c = 10;
        String str = "Hello";
        long l = 10;
        float f = 10.f;
        double d = 10;
        boolean bool = true;

        switch (b) {
        }
        switch (s) {
        }
        switch (i) {
        }
        switch (c) {
        }
        switch (str) {
        }
        // switch (l) {}
        // switch (f) {}
        // switch (d) {}
        // switch (bool) {}

        level = 2;
        switch (level) {
        case 0:
            System.out.println("손님");
        case 1:
            System.out.println("회원");
        case 2:
            System.out.println("관리자");
        case 3:
            System.out.println("유효하지않은회원");
        }

        String v1 = "어린이";
        switch (v1) {
        case "유아":
        case "노인":
            System.out.println("무료");
            break;
        case "어린이":
        case "중학생":
        case "고등학생":
        case "미성년":
            System.out.println("청소년 요금");
            break;
        case "성인":
        case "외국인":
            System.out.println("일반 요금");
            break;
        default:
            System.out.println("요금 대상이 아닙니다!");
        }
    }
}