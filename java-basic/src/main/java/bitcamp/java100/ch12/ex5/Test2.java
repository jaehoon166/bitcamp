package bitcamp.java100.ch12.ex5;

public class Test2 implements D {

    @Override // D, A
    public void m1() {
        System.out.println("sm1()");
    }

    @Override // B
    public void m2() {
        System.out.println("B.m2()");
    }

    @Override // C
    public void m3() {
        System.out.println("C.m3()");
    }

    @Override // D
    public void m4() {
        System.out.println("D.m4()");
    }

}
