package bitcamp.java100.ch02;

public class Test12_9T{
  
  public static void main(String[] args) {
    String aa = "윤재훈";
    char[] code = new char[100];
    int[] realCode = new int[100];

    for(int i=0; i<aa.length();i++)
     {
    code[i] = aa.charAt(i);
    realCode[i] = (int)(code[i]);
    System.out.println("The unicode of '" + code[i] + "' is \\" + "u" + Integer.toHexString(realCode[i]).toUpperCase());
    }

    for(int i=0; i<aa.length();i++)
    {
     System.out.print("\\u" + Integer.toHexString(realCode[i]).toUpperCase());
    }
  }
}