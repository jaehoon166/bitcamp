package bitcamp.java100.Test18;

public class Test18_3 {

    public static void main(String[] args) {
        String s1 = "ABC가각간";
        String s2 = "ABC가각간";
        String s3 = "ABC가각간";
        
        String s4 = new String("ABC가각간");
        String s5 = new String("ABC가각간");
        String s6 = new String("ABC가각간");
        
        
        //H-Heap C-Constants Pool
        if (s1 == s2) {
            System.out.println("H.s1 == H.s2");
        }
        if (s1 == s3) {
            System.out.println("H.s1 == H.s3");
        }
        ///////////////////////////////////////
        if (s1 != s4) {
            System.out.println("H.s1 != C.s4");
        }
        if (s1 != s5) {
            System.out.println("H.s1 != C.s5");
        }
        if (s1 != s6) {
            System.out.println("H.s1 != C.s6");
        }
        
        if (s4 != s5) {
            System.out.println("C.s4 != C.s5");
        }
        if (s4 != s6) { 
            System.out.println("C.s4 != C.s6");
        }
        if (s5 != s6) {
            System.out.println("C.s5 != C.s6");
        }
        ///////////////////////////////////////
        if (s1 == "ABC가각간") System.out.println("H.s1 == H.ABC가각간");
        if (s4 != "ABC가각간") System.out.println("C.s4 != C.ABC가각간");
    }
}