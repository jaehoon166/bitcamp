package bitcamp.java100.ch02;

public class Test16_2 {

    public static void main(String[] args) {
        int age = 17;

        if (age <= 19)
            System.out.println("미성년");
        else
            System.out.println("성년");

        age = 67;

        if (age >= 65)
            System.out.println("경로우대 대상자입니다.");
        else
            System.out.println("경로우대 대상자가 아닙니다.");

        age = 17;

        if (age <= 19) {
            System.out.println("미성년입니다.");
            System.out.println("청소년 할인을 받을 수 있습니다.");
        }
        System.out.println("--------------------------------------------");

        age = 47;

        if (age < 8)
            System.out.println("유아");
        else if (age < 14)
            System.out.println("어린이");
        else if (age < 28)
            System.out.println("청소년");
        else if (age < 65)
            System.out.println("장년");
        else
            System.out.println("노인");

        age = 47;

        if (age < 8) {
            System.out.println("유아");
        } else if (age < 14) {
            System.out.println("어린이");
        } else if (age < 28) {
            System.out.println("청소년");
        } else if (age < 65) {
            System.out.println("장년");
        } else {
            System.out.println("노인");
        }
    }
}