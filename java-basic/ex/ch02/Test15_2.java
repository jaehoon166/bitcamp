package bitcamp.java100;

public class Test15_2 {

  public static void main(String[] age) {
    byte b1 = 10;
    byte b2 = 20;

    /*byte b3 = b1 - b2;
    incompatible types: possible lossy conversion from int to byte*/

    short s1 = 10;
    short s2 = 20;

    /*short s3 = s1 + s2;
    incompatible types: possible lossy conversion from int to short*/

    int r1 = b1 + b2 + s1 + s2;
    long r2 = b1 + b2 + s1 + s2;
    
  }
}