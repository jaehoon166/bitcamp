package bitcamp.java100.Test21.Test21_7;

import java.io.Console;

public class Test21_7 {

    public static void main(String[] args) {

        Console console = System.console();

        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }
        
        String str = console.readLine("문자열? ");
        StringBuffer buf = new StringBuffer();
        buf.append(str);
        
        int len = buf.length() / 2;
        
        for(int left = 0, right = buf.length() - 1; left < len; left++, right--) {
            char ch = buf.charAt(left);
            buf.setCharAt(left, buf.charAt(right));
            buf.setCharAt(right, ch);
            System.out.printf("%s\n", ch);
        }
        System.out.printf("%d\n", len);
        System.out.printf("입력 문자열: %s\n", str);
        System.out.printf("출력 문자열: %s\n", buf);
    }
}
