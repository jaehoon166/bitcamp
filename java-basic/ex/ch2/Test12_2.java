package bitcamp.java100;

public class Test12_2 {

  public static void main(String[] age) {
    int i;
    int j;

    i = 100;
    j = i + 100;
    //100 = 200; unexpected type
    //i = 3.14; possible lossy conversion from double to int

    System.out.print(i);
    System.out.printf("%d", j);
  }
}