package bitcamp.java100.ch19.ex6;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation2 {
    String[] name() default "홍길동";

    int[] age() default 20;
}
