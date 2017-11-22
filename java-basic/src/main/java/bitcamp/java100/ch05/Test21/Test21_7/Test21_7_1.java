package bitcamp.java100.ch05.Test21.Test21_7;


import java.io.Console;

public class Test21_7_1 {

    static Console console;

    static void prepareConsole() {
        console = System.console();
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }
    }

    static String inoutString() {
        return console.readLine("문자열? ");
    }

    static String reverseString(String str) {
        StringBuffer buf = new StringBuffer();
        buf.append(str);

        int len = buf.length() / 2;

        for (int left = 0, right = buf.length() - 1; left < len; left++, right--) {
            char ch = buf.charAt(left);
            buf.setCharAt(left, buf.charAt(right));
            buf.setCharAt(right, ch);
        }
        return buf.toString();

    }

    public static void main(String[] args) {

        prepareConsole();

        String str = inoutString();
        String str2 = reverseString(str);

        System.out.printf("입력 문자열: %s\n", str);
        System.out.printf("출력 문자열: %s\n", str2);
    }
}
