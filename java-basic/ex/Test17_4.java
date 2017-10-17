package bitcamp.java100;

public class Test17_4 {

    static void m1(int... values) {
        System.out.printf("아규먼트 개쉬 %d\n", values.length);
        for (int v : values) {
            System.out.println(v);
        }
        System.out.println("------------------------------");
    }

    // static void m2(int... values, int... values2) {}
    // static void m2(int... values, String... values2) {}
    static void m2(String name, int age, int... values) {}
    // static void m3(int... values, String name, int age) {}
    // static void m3(String name, int... values, int age) {}

    static void sum(int... values) {
       int s = 0;
       for(int v : values) {
           s+=v;
       }
       System.out.printf("합계 : %d\n", s);
    }
    public static void main(String[] args) {
        m1();
        m1(10);
        m1(10, 20);
        m1(10, 20, 30);
        
        sum(10);
        sum(10, 20);
        sum(10, 20, 30);
    }
}