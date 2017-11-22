package bitcamp.java100.ch04.Test18;


public class Test18_7 {

    public static void main(String[] args) throws Exception {
        String s1 = "Hello!";

        String s2 = s1.replace("l", "x");

        System.out.println(s1);
        System.out.println(s2);

        StringBuffer sb1 = new StringBuffer("Hello!");

        sb1.append(" World!");
        System.out.println(sb1);

        sb1.replace(2, 4, "xx");
        System.out.println(sb1);
    }

}