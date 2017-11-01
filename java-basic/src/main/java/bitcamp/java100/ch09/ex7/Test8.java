package bitcamp.java100.ch09.ex7;

import java.util.HashMap;

public class Test8 {

    static class MyKey {
        String id;
        String pw;

        public MyKey(String id, String pw) {
            this.id = id;
            this.pw = pw;
        }
    }

    static class Contact {
        String name;
        String email;
        String tel;

        public Contact(String name, String email, String tel) {
            this.name = name;
            this.email = email;
            this.tel = tel;
        }

        @Override
        public String toString() {
            return "Contact[name=" + name + ",email=" + email + ", tel=" + tel + "]";
        }
    }

    public static void main(String[] args) {
        HashMap<MyKey, Contact> map = new HashMap<>();

        Contact c1 = new Contact("홍길동1", "hong1@test.com", "111-1111-1111");
        MyKey k1  = new MyKey("aaaa", "1111");
        
        map.put(k1, c1);

        System.out.println(map.get(k1));

        MyKey k2  = new MyKey("aaaa", "1111");
        System.out.println(map.get(k2));
    }
}
