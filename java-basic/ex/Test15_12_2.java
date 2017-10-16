package bitcamp.java100;

public class Test15_12_2 {

    public static void main(String[] args) {
        int v = 1234567890;

        System.out.println(Integer.toHexString(v));

        System.out.println(Integer.toHexString(v >> 24));
        System.out.println(Integer.toHexString((v >> 16) & 0xFF));//00004996 
        System.out.println(Integer.toHexString((v >> 8) & 0xFF));//00499602
        System.out.println(Integer.toHexString((v >> 4) & 0xFF));//499602s2
        //0xFF            0000/0000 0000/0000 0000/0000 1111/1111
        //4996            0000/0000 0000/0000 0100/1001 1001/0110
        //0xFF & 4996     0000/0000 0000/0000 0000/0000 1001/0110
    }
}