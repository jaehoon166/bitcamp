package bitcamp.java100.ch12.ex3;

public class Test3 {
    public static void main(String[] args) {
        System.out.println(Protocol3.AA);
        // Protocol3.AA = 300;
        class MyClass implements Protocol3 {
            @Override
            public void m1() {
                System.out.println("m1()");
            }

            @Override
            public void m2(int p) {
                System.out.println("m2()");
            }

            @Override
            public void m3(String p) {
                System.out.println("m3()");
            }
            
        }
        Protocol3 obj = new MyClass();
        obj.m1();
        obj.m2(100);
        obj.m3("asd");
    }
}
