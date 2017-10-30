package bitcamp.java100.ch06.ex3;

public class Test7 {

    static class A {
        static int a = 100;

        static {
            System.out.println("A의 스태틱 블록 실행!");
            System.out.printf("A===>a = %d\n", A.a);
            B.b = 222;
            System.out.printf("A===>a = %d\n", A.a);
            System.out.println("A의 스태틱 블록 종료!");
            System.out.printf("B===>b = %d\n", B.b);
            System.out.println("B의 스태틱 블록 종료!");
        }
    }

    static class B {
        static int b = 200;

        static {
            System.out.println("B의 스태틱 블록 실행!");
            System.out.printf("B===>b = %d\n", B.b);
            A.a = 111;
            System.out.printf("B===>b = %d\n", B.b);
            System.out.println("B의 스태틱 블록 종료!");
        }
    }

    public static void main(String[] args) {
        new A();
    }
}
//method area - class -static
//Heap - instance (static이 붙지 않은 변수)-new로 만들어져서 Heap에 메로리가 할당
//static class S{
//static String s = new String("");-> Method Area에 String 변수의 값이 Heap에 만들어지고 그 주소 값을 Method Area에 만들어진 class 변수 메모리에 넣는다.
//}
//stack- 로컬변수
