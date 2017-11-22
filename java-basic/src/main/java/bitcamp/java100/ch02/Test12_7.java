package bitcamp.java100.ch02;

public class Test12_7{
  
    public static void main(String[] age){
      float f1 = 9876567f;
      
      System.out.println(f1);
      
      f1 = 9876543456789l; //9.8765436E12 = 9.876543600000

      System.out.println(f1);

      /*f1 = 9876543.4567;
        incompatible types: possible lossy conversion from double to float*/
      
      f1 = 9876543.4567f;
      System.out.println(f1);
    }
  }