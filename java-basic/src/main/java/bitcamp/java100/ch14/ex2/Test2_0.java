package bitcamp.java100.ch14.ex2;

import java.io.File;
import java.io.FileOutputStream;

public class Test2_0 {

    public static void main(String[] args) throws Exception {
        File file = new File("./test.dat");

        FileOutputStream out = new FileOutputStream(file);

        int[] date = { 0x66554420, 0x66554421, 0x66554422, 0x66554423, 0x66554424, 0x66554425, 0x66554426, 0x66554427,
                0x66554428, 0x66554429 };

        for (int b : date) {
            System.out.println(Integer.toHexString(b));
            out.write(b);
        }
        out.close();
    }

}
