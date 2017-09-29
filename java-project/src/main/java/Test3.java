//여러 명의 성적을 저장하고 다음과 같이 출력하라!
//출력내용:
//홍길동, 100,  90,  80, 270,  90.0
//임꺽정,  80,  80,  80, 240,  80.0
//유관순, 100, 100, 100, 300, 100.0
public class Test3 {

  public static void main(String[] args) {
    String[] name = { "홍길동","임 꺽정","유관순 "};  
    int[] kor = { 100, 80, 100 };
    int[] eng = { 90, 80, 100 };
    int[] math = { 80, 80, 100 };
    int[] sum = new int[3];
    float[] aver = new float[3];
    /*int tks = 0;
    int tes = 0;
    int tms = 0;*/

    for (int i = 0; i < name.length; i++) {
      sum[i] = kor[i] + eng[i] + math[i];
      aver[i] = sum[i] / 3.0f;
      System.out.printf("%s, %3d, %3d, %3d, %3d, %5.1f\n", name[i], kor[i], eng[i], math[i], sum[i], aver[i]);
      /*tks +=kor[i];
      tes +=eng[i];
      tms +=math[i];*/
    }

    /*float tka = tks/3.0f;
    System.out.printf("1반 국어평균: %.1f\n", tka);
    float tea = tes/3.0f;
    System.out.printf("1반 영어평균: %.1f\n", tea);
    float tma = tms/3.0f;
    System.out.printf("1반 수학평균: %.1f\n", tma);*/

  }
}