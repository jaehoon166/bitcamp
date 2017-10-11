package bitcamp.java100;

public class Test15_12 {

  public static void main(String[] args) {
      
      int v = 87;
      
      System.out.println(v >> 1);
      System.out.println(v >> 2);
      System.out.println(v >> 3);
      System.out.println(v >> 4);
      
      v = -87;
      System.out.println(v >> 1);
      System.out.println(v >> 2);
      System.out.println(v >> 3);
      System.out.println(v >> 4);
      
      v = 87;
      System.out.println(v >>> 1);
      System.out.println(v >>> 2);
      System.out.println(v >>> 3);
      System.out.println(v >>> 4);
      
      v = -87;
      System.out.println(v >>> 1);
      System.out.println(v >>> 2);
      System.out.println(v >>> 3);
      System.out.println(v >>> 4);
      
      v = 5;
      System.out.println(v << 1);
      System.out.println(v << 2);
      System.out.println(v << 3);
      System.out.println(v << 4);
      
      v = -5;
      System.out.println(v << 1);
      System.out.println(v << 2);
      System.out.println(v << 3);
      System.out.println(v << 4);
  }
}