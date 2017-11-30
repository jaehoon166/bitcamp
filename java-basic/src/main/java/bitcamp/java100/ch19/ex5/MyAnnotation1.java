package bitcamp.java100.ch19.ex5;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation1 {
    String[] name();
    int[] age();
}
