package bitcamp.java100.ch19.ex1;

@MyAnnotation

public class MyClass {
    @MyAnnotation
    public int a;

    @MyAnnotation
    public void m() {
        //@MyAnnotation
        System.out.println("Hello!!!");
    }
    
    public void m2(@MyAnnotation int a, @MyAnnotation String b) {
        @MyAnnotation
        int x = 10;
    }
}
