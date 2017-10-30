package bitcamp.java100;

public class Test12_6{
  
    public static void main(String[] age){
      byte b1 = 50;
      byte b2 = 50;
      byte b3;

      b3 = 50 + 50;
      /*b3 = b1 + b2;
        b3 = b1 + 50;
        incompatible types: possible lossy conversion from int to byte*/
      short s1, s2;

      /*s1 = b1 + b2;
        incompatible types: possible lossy conversion from int to short*/
    }
  }