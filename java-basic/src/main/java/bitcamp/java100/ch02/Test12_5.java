package bitcamp.java100.ch02;

public class Test12_5{
  
    public static void main(String[] age){
      byte b1;
      
      b1 = 100;
      b1 = -128;
      b1 = 127;
      /*b1 = -129;
        b1 = 128;
        incompatible types: possible lossy conversion from int to byte*/
      
      short s1;

      s1 = -32768;
      s1 = 32767;
      /*s1 = -32769;
        s1 = 32768;
        incompatible types: possible lossy conversion from int to short*/

      int i1;

      i1 = -21_4748_3648;
      i1 = 21_4748_3647;
      
      /*i1 = -21_4748_3649;
        i1 = 21_4748_3648;
        integer number too large: -2147483649*/
      /*i1 = -21_4748_3649L;
        i1 = 21_4748_3648L;
        incompatible types: possible lossy conversion from long to int*/

      /*b1 = 100L;
        s1 = 100L;
        i1 = 100L;
        incompatible types: possible lossy conversion from long to short*/

      long l1;
      l1 = -922_3372_0368_5477_5808L;
      l1 = 922_3372_0368_5477_5807L;
      
    }
  }