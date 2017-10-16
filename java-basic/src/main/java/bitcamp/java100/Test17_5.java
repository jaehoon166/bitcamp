package bitcamp.java100;

public class Test17_5 {

    static String m1() {
        return "Hello!";
    }
    
    static int m2() {
        return 100;
    }

    static boolean m3() {
        return true;
    }
    
    //static int m4() {return "Hello!"}
    //static int m5() {}
    
    public static void main(String[] args) {
        String v = m1();
        System.out.println(v);
        
        System.out.println(m1());
        
        m1();
        
        //int v2 = m1();
        
        
    }
}