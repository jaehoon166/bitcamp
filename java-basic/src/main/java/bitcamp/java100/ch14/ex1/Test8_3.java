package bitcamp.java100.ch14.ex1;

public class Test8_3 {

    static int f(int n) {
        if(n == 0)
            return 0;
        return n + f(n-1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(f(10));
    }
}
