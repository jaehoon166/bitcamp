package bitcamp.java100.ch18;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test6 {
    public static void main(String[] args) throws Exception {
        Class<?> clazz = z.class;

        Field[] fields = clazz.getFields();
        
        for(Field f : fields) {
            System.out.printf("%s %s\n", f.getType().getName(), f.getName());
        }
        
        System.out.println("-------------------------------------");
        
        fields = clazz.getDeclaredFields();
        
        for(Field f : fields) {
            System.out.printf("%s %s\n", f.getType().getName(), f.getName());
        }
    }
}
