package java100.app;

import java.util.Scanner;

public class Prompts {
    static Scanner keyScan = new Scanner(System.in);

    public static String input(String message) {
        System.out.print(message);
        return keyScan.nextLine();
    }

    public static boolean confirm(String message) {
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if (response.equals("y") || response.equals("yes") || response.equals("")) {
            return true;
        }
        return false;
    }

    public static boolean confirm2(String message) {
        System.out.print(message);
        String response = keyScan.nextLine().toLowerCase();

        if (response.equals("n") || response.equals("no") || response.equals("")) {
            return false;
        }
        return true;
    }
}
