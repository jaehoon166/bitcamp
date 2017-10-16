package bitcamp.java100;

public class Test15_4 {

  public static void main(String[] age) {
    float f1 = 3.14592f, f2 = 5432.123f;
    int i1 = 7654321;
    System.out.printf("%f, %d\n", f1, i1);
    double d1 = 4567.8988, d2 = 9876.5432;

    double r1 = f1 + i1;
    System.out.println(r1);

    r1 = (double)f1 + (double)i1;
    System.out.println(r1);

    r1 = (double)f1 + i1;
    System.out.print(r1);
    
  }
}