package bitcamp.java100;

public class Test12_9T1{
  
  public static void main(String[] age){
    String name = "윤재훈";
    for(int i=0;i<name.length();i++){
      int uni = name.charAt(i);
      System.out.printf("%02X%n",uni);
    }
    //int fnu = name.charAt(0);
    //String fn = fnu;
   // System.out.print(fn);
  }
}