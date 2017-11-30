package bitcamp.java100.ch18;

import java.lang.reflect.Method;

public class Test8 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = X.class;

        Method m = clazz.getMethod("m2");
        m.invoke(null);
        
        clazz.getMethod("m2", int.class).invoke(null, 100);
        
        // clazz.getMethod("m").invoke(null);
        X obj = new X();
        clazz.getMethod("m").invoke(obj);
        clazz.getMethod("m", int.class).invoke(obj, 100);
        clazz.getMethod("m", int.class,String.class).invoke(obj, 100, "홍길동");
    }
}
