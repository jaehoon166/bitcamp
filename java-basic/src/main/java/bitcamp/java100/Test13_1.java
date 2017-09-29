package bitcamp.java100;

public class Test13_1{
  
    public static void main(String[] age){
      int kor, eng, math, soc, sci, eth, chi;

      kor = 100;
      eng = 100;
      math = 100;
      soc = 100;
      sci = 100;
      eth = 100;
      chi = 100;

      String[] cname = {"국어","영어","수학","사회","과학"};
      int[] scores = new int[5];
      scores[0] = 100;
      scores[1] = 100;
      scores[2] = 100;
      scores[3] = 100;
      scores[4] = 100;

      for(int i=0;i<5;i++){
        System.out.printf("%s: %d\n", cname[i],scores[i]);
      }
      
    }
  }