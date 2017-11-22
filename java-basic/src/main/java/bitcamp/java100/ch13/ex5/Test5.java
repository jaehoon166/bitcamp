package bitcamp.java100.ch13.ex5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Test5 {

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

        } catch (IOException e) {
            System.out.println("IOException처리!");
        } catch (Exception e) {
            System.out.println("Exception처리!");
        }
    }

}
