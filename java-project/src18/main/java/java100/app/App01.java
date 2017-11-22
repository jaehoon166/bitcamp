package java100.app;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class App01 {

    static boolean confirm(String message) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if (response.equals("y") || response.equals("yes"))
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        
        ArrayList<Score> list = new ArrayList<>();
        
        while (true) {
            System.out.print("성적관리> ");
            String input = keyScan.nextLine();
            System.out.println(input);
            System.out.println();
    }
}
