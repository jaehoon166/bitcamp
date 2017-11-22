package bitcamp.java100.ch14.ex4;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test2_1 {
    public static void main(String[] args) throws Exception {

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("test1.dat"));

        Score2 s = (Score2) in.readObject();

        in.close();

        System.out.println(s);
    }
}
