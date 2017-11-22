package bitcamp.java100.ch02;

public class Test12_9{
  
    public static void main(String[] age){
      char c1 = 'a';
      
      //System.out.printf("%c", c1);
      int num;
      num = c1 - '0';
      //int num=Integer.parseInt(c1);;

      System.out.printf("%02X%n", num);

      //StringEscapeUtils.escapeJava("윤");
    }
  }