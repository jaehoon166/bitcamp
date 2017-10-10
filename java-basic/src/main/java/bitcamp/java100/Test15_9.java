package bitcamp.java100;

public class Test15_9 {

  public static void main(String[] age) {
    System.out.printf("true && true ? %b\n", true && true);
    System.out.printf("true && false ? %b\n", true && false);
    System.out.printf("false && true ? %b\n", false && true);
    System.out.printf("false && false ? %b\n", false && false);

    System.out.printf("true || true ? %b\n", true || true);
    System.out.printf("true || false ? %b\n", true || false);
    System.out.printf("false || true ? %b\n", false || true);
    System.out.printf("false || false ? %b\n", false || false);

    System.out.printf("true & true ? %b\n", true & true);
    System.out.printf("true & false ? %b\n", true & false);
    System.out.printf("false & true ? %b\n", false & true);
    System.out.printf("false & false ? %b\n", false & false);

    System.out.printf("true | true ? %b\n", true | true);
    System.out.printf("true | false ? %b\n", true | false);
    System.out.printf("false | true ? %b\n", false | true);
    System.out.printf("false | false ? %b\n", false | false);

    boolean b1 = false;
    boolean result = false && (b1 = true);
    System.out.printf("%b,%b", b1, result);

    b1 = false;
    result = false & (b1 = true);
    System.out.printf("%b,%b", b1, result);
  }
}