package bitcamp.java100;

public class Test14_3 {

  public static void main(String[] age) {
    class bitcamp {
      String name;//이름
      int age;//나이
      boolean gender;//성별
      int bir;//생년월일
      String address;//주소
      String hp;//핸드폰번호
      String adu;//학력
      String lang;//사용가능 언어
    }
    String gen= "";

    bitcamp stu = new bitcamp();

    stu.name = "윤재훈";
    stu.age = 26;
    stu.gender = true;
    stu.bir = 921202;
    stu.address = "서울특별시 관악구 봉천동 942번지 501호";
    stu.hp = "010-7610-2830";
    stu.adu = "대졸";
    stu.lang = "c언어,java";

    if(stu.gender==true){
      gen = "남";
    }
    else{
      gen = "여";
    }
    System.out.printf("이름:%s\n나이:%d\n성별:%s\n생년월일:%d\n주소:%s\nH.P:%s\n학력:%s\n사용가능언어:%s", stu.name,stu.age,gen,stu.bir,stu.address,stu.hp,stu.adu,stu.lang);
  }
}