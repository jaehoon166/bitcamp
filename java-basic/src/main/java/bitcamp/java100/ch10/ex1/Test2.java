package bitcamp.java100.ch10.ex1;

public class Test2 {
    // static nested class
    // => 인스턴스 없이 바깥 클래스의 이름만으로 사용할 수 있는 중첩 클래스.
    static class A {}
    
    // non-static nested class = inner class
    // => 인스턴스가 있어야만 사용할 수 있는 nested class
    class B {}
    
    
    // 익명 클래스
    // => 클래스의 이름이 없어 클래스를 정의하는 동시에 
    //    인스턴스를 바로 생성하는 클래스를 말한다.
    Object obj = new Object() {
        String name;
        public void m1() {}
    };
    
    public static void main(String[] args) {
        
        // 로컬 클래스
        // => 특정 메서드에서만 사용하도록 메서드 안에 정의된 클래스.
        class C {}
        
        // 익명 클래스는 메서드 안에서도 정의할 수 있다.
        Object obj2 = new Object() {
            String name;
            public void m1() {}
        };
                
    }

}