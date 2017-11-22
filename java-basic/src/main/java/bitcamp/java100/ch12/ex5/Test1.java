package bitcamp.java100.ch12.ex5;

public class Test1 implements B {

    @Override // B가 A인터페이스를 상속받았으므로 A인터페이스에 있는 m1메소드도 구현해햐한다.
    public void m1() {
        System.out.println("m1()");
    }

    @Override
    public void m2() {
        System.out.println("m2()");
    }

}
