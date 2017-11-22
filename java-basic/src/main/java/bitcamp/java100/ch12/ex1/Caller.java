package bitcamp.java100.ch12.ex1;

public class Caller {

    public static void main(String[] args) {
        Protocol obj = new Callee();
        //Protocol obj2 = new String();
        obj.m1();
        obj.m2();
        
    }
}
