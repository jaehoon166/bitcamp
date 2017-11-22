package bitcamp.java100.ch05.Test21.Test21_5;
// ## 키보드로부터 입력 받기 - 연습1
// - 다음과 같이 사용자로부터 구구단 번호를 입력 받아 출력하라!
// - 실행 예) 
// 구구단? 2
// 2 * 1 = 2
// 2 * 2 = 4
// 2 * 3 = 6
// ...
// 2 * 9 = 18
// --------------------------
// 구구단? 10
// 2에서 9단까지만 가능합니다!
// 구구단? 1
// 2에서 9단까지만 가능합니다!
// 구구단? 0    <===== 0이하의 수를 입력하면 종료하라!
// 다음에 또 봐요!
// > 



import java.io.Console;

public class Test21_5_6 {

    static class ConsoleCreationException extends RuntimeException {

    }

    static class InvallidGugudanException extends RuntimeException {

    }

    static Console console;

    static void prepareInput() {
        console = System.console();

        if (console == null) {
            throw new ConsoleCreationException();
        }
    }

    static int promptGugudan() {
        int i = Integer.parseInt(console.readLine("구구단? "));

        if (i >= 10 || i == 1 || i < 0) {
            throw new InvallidGugudanException();
        }

        return i;
    }

    static void printGugudan(int i) {
        for (int j = 1; j < 10; j++) {
            System.out.printf("%d * %d = %d\n", i, j, i * j);
        }
    }

    public static void main(String[] args) {

        try {
            prepareInput();

            while (true) {
                int i = 0;
                try {
                    i = promptGugudan();
                    if (i == 0)
                        break;
                    printGugudan(i);
                } catch (InvallidGugudanException e) {
                    System.err.println("구구단의 범위가 아닙니다.");
                }
            }
            System.out.println("다시 또 오세요!");
        } catch (ConsoleCreationException e) {
            System.err.println("콘솔 입력을 지원하지 않습니다.");
        }
    }
}