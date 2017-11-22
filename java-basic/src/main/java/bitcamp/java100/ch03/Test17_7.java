package bitcamp.java100.ch03;

import java.util.ArrayList;

public class Test17_7 {
    static ArrayList m1() {
        ArrayList list = new ArrayList();
        list.add("윤재훈");
        list.add(26);
        list.add(false);
        list.add(4.12f);
        list.add('M');
        
        return list;
    }
    public static void main(String[] args) {
        ArrayList a= m1();
        
        for(Object v : a){
            System.out.println(v);
        }
    }
}