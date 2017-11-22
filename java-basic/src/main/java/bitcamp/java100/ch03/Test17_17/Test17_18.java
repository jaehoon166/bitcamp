package bitcamp.java100.ch03.Test17_17;

public class Test17_18{

    static class My {
        int value;
        
        static void print(My ref) {
            System.out.println(ref.value);
            //System.out.println(this.value);
        }
    }
    
    public static void main(String[] args) {
        My r1 = new My();
        My r2 = new My();
        My r3 = new My();
        
        r1.value = 100;
        r2.value = 200;
        r3.value = 300;
        
        My.print(r1);
        My.print(r2);
        My.print(r3);
        
        r1.print(r1);
    }
}