package bitcamp.java100.ch14.ex2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Test3_0 {

    public static void main(String[] args) throws Exception{
        FileInputStream in = new FileInputStream(new File("sample/a.png"));
        FileOutputStream out = new FileOutputStream(new File("sample/a2.png"));
        
        int b;
        while((b = in.read()) != -1) {
            out.write(b);
        }
        in.close();
        out.close();
        System.out.println("파일 복사 완료");
    }

}
