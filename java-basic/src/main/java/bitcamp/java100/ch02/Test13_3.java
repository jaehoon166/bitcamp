package bitcamp.java100.ch02;

public class Test13_3{
  
    public static void main(String[] age){
      int[] arr1;

      arr1 = new int[3];
      
      System.out.print(arr1.length);

      arr1[0]=100;
      arr1[1]=90;
      arr1[2]=80;
      
      /*arr1[-1]=200;
        arr1[3]=300;
      3Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: -1*/
    }
  }