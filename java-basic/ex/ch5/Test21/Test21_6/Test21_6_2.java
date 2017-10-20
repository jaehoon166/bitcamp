package bitcamp.java100.Test21.Test21_6;

import java.io.Console;

public class Test21_6_2 {

    static Console console;

    static void prepareConsole() {
        console = System.console();
        if (console == null) {
            System.err.println("콘솔을 지원하지 않습니다.");
            System.exit(1);
        }
    }

    static long InputNumber() {
        return Long.parseLong(console.readLine("숫자? "));
    }

    static int[] CountNumber(long value) {
        int cnt[] = new int[10];

        while (value > 0) {
            cnt[(int) (value % 10)]++;
            value /= 10;
        }
        return cnt;
    }

    static void printNumberCount(int cnt[]) {
        int x = 0;
        while (x < cnt.length) {
            System.out.printf("%d = %d\n", x, cnt[x]);
            x++;
        }
    }

    public static void main(String[] args) {

        prepareConsole();

        long value = InputNumber();

        int[] cnt = CountNumber(value);

        printNumberCount(cnt);

    }
}