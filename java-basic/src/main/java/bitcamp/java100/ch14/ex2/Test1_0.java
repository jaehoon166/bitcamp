package bitcamp.java100.ch14.ex2;

import java.io.File;
import java.io.FileInputStream;

public class Test1_0 {

    public static void main(String[] args) throws Exception{
        File file = new File("sample/a.png");
        FileInputStream in = new FileInputStream(file);
        
        int b;
        int count = 0;
        while((b = in.read()) != -1) {
            count ++;
        }
        System.out.println(count);
        in.close();
    }

}
