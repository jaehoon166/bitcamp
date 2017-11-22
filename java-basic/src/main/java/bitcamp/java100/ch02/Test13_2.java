package bitcamp.java100.ch02;

public class Test13_2{
  
    public static void main(String[] age){
      int[] arr1;
      int arr2[];
      
      /*arr1 = 100;
        arr2 = 100;
        incompatible types: int cannot be converted to int[]*/

      arr1 = new int[3];
      arr2 = new int[4];

      arr1[0]=100;
      arr1[1]=90;
      arr1[2]=80;
      
      System.out.printf("%d,%d,%d\n", arr1[0],arr1[1],arr1[2]);

      arr2[0]=100;
      arr2[1]=200;
      arr2[2]=300;
      arr2[3]=400;

      System.out.printf("%d,%d,%d,%d", arr2[0],arr2[1],arr2[2],arr2[3]);

    }
  }