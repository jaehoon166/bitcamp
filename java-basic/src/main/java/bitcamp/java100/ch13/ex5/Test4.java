package bitcamp.java100.ch13.ex5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Test4 {

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("입력> ");
        String str = keyScan.nextLine().toLowerCase();

        try {
            System.out.println("try블럭 실행!");

            switch (str) {
            case "a":
                throw new Exception();
            case "b":
                throw new IOException();
            case "c":
                throw new FileNotFoundException();
            case "d":
                throw new SQLException();

            default:
                break;
            }
            System.out.println(str);

        } catch (Exception e) {
            System.out.println("catch블럭 실행!");
        //IOException은 Exception의 자식 클레스이기 때문에 부모 클레스인 Exception 위쪽에 선언 해주어야 한다.
        //} catch (IOException e) {
        //    System.out.println("catch블럭 실행!");
        }
    }

}
