package bitcamp.java100;

public class Test12_9T{
  
  public static void main(String[] args) {
    String aa = "윤";
    //char[] code = new char[100];
    //int[] realCode = new int[100];
    int code = aa.charAt(0);
    int realCode = (int)(code);

    //for(int i=0; i<aa.length();i++)
     {
    //code[i] = aa.charAt(i);
    //realCode[i] = (int)(code[i]);
    System.out.println("The unicode of '" + code + "' is \\" + "u" + Integer.toHexString(realCode).toUpperCase());
    }

    //for(int i=0; i<aa.length();i++) 
    //{
     System.out.print("\\u" + Integer.toHexString(realCode).toUpperCase());
    //}
  }
}