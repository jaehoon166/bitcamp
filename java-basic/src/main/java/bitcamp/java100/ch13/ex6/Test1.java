package bitcamp.java100.ch13.ex6;

import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("입력> ");
        String str = keyScan.nextLine().toLowerCase();

        try {
            System.out.println("try 블록 실행!");
        } finally {
            System.out.println("Finally 블록 실행!");
        }
    }

}
