package bitcamp.java100.Test20;

public class Test20_1 {

    public static void main(String[] args) {
        int i = 10;

        Integer i2 = new Integer(10);

        int i3 = i2.intValue();

        float f1 = i2.floatValue();

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        int value = Integer.parseInt("2345");
        System.out.println(value + 100);

        System.out.println(Integer.toBinaryString(44032));
        System.out.println(Integer.toOctalString(44032));
        System.out.println(Integer.toHexString(44032));

    }
}