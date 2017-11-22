package bitcamp.java100.ch03;

public class Test17_3 {

    static void m1(String name) {
        System.out.printf("%s님 반갑습니다!\n", name);
    }

    static void m2(String name, int age) {
        System.out.printf("%s(%d)님 반갑습니다!\n", name, age);
    }

    public static void main(String[] args) {
        m1("윤재훈");
        m1("장현주");

        m2("윤재훈", 26);
        m2("장현주", 25);
    }
}