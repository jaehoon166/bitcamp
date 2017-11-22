package bitcamp.java100.ch02;

public class Test15_3 {

  public static void main(String[] age) {
    byte b1 = 20, b2 = 22;
    short s1 = 30, s2 = 33;
    int i1 = 40, i2 = 44;
    long l1 = 50, l2 = 55;
    float f1 = 3.14f, f2 = 45.32f;
    double d1 = 4567.8988, d2 = 9876.5432;

    int r1 = b1 + s1;
    r1 = b1 + i1;
    r1 = i1 + s1;

    /*r1 = i1 + l1;
    incompatible types: possible lossy conversion from long to int*/
    long r2 = i1 + l1;

    /*long r3 = b1 + f1;
    r3 = s1 + f1;
    r3 = i1 + f1;
    r3 = l1 + f1;
    incompatible types: possible lossy conversion from float to long*/

    float r4 = b1 + f1;
    r4 = s1 + f1;
    r4 = i1 + f1;
    r4 = l1 + f1;
    //결과 값이 float의 크기를 넘어가면 넘어간 값은 짤린다.

    double r5 = f1 + d1;
    r5 = b1 + d1;
    r5 = s1 + d1;
    r5 = i1 + d1;
    r5 = l1 + d1;

    
  }
}