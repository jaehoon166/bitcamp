package bitcamp.java100.ch14.ex2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class Test1_6 {
    public static void main(String[] args) throws Exception {
        FileInputStream in = new FileInputStream("sample/jls9.pdf");

        BufferedInputStream in2 = new BufferedInputStream(in);

        int count = 0;
        int b = 0;

        long start = System.currentTimeMillis();

        while ((b = in2.read()) != -1) {
            count++;
        }

        long end = System.currentTimeMillis();

        System.out.printf("읽은 바이트 수 = %d\n", count);
        System.out.printf("걸린시간 = %d\n", end - start);
        in.close();

    }
}
