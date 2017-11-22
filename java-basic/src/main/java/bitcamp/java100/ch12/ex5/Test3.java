package bitcamp.java100.ch12.ex5;

public class Test3 implements A, C {

    @Override // D, A
    public void m1() {
        System.out.println("sm1()");
    }

    @Override // C
    public void m3() {
        System.out.println("C.m3()");
    }

}
