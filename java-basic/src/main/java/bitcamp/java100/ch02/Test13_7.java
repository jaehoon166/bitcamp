package bitcamp.java100.ch02;

public class Test13_7 {

  public static void main(String[] age) {
    int a = 100;
    int b;

    b = a;
    b = 200;

    System.out.printf("a=%d, b=%d\n", a, b);

    int[] arr1 = { 100, 200, 300 };
    int[] arr2;

    arr2 = arr1;

    arr2[1] = 50;

    for (int i = 0; i < 3; i++) {
      System.out.printf("arr1[%d]=%d\n", i, arr1[i]);
    }
    System.out.printf("\n");
    for (int i = 0; i < 3; i++) {
      System.out.printf("arr2[%d]=%d\n", i, arr2[i]);
    }
  }
}