package bitcamp.java100.ch02;

public class Test12_1 {

  public static void main(String[] age) {
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    boolean bool;
    char c;

    b = 100;
    s = 100;
    i = 100;
    l = 100;
    f = 3.14f;
    d = 3.14;
    bool = true;
    c = 44032;

    System.out.print(b);
    System.out.print(s);
    System.out.print(i);
    System.out.print(l);
    System.out.print(f);
    System.out.print(d);
    System.out.print(bool);
    System.out.print(c);
    System.out.printf("%d\n %d\n %d\n %d\n %f\n %f\n %b\n %c", b, s, i, l, f, d, bool, c);
  }
}