package bitcamp.java100.ch14.ex4;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Test1_1 {
    public static void main(String[] args) throws Exception {

        Score2 s = new Score2("홍깋동", 800, 900, 1000);

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test1.dat"));

        out.writeObject(s);
        
        out.close();
        
        System.out.println("출력을 완료했습니다.");
        
    }
}
