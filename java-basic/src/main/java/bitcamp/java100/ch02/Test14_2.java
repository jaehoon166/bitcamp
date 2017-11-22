package bitcamp.java100.ch02;

public class Test14_2 {

  public static void main(String[] age) {
    class bookstore {
      String bname;
      String author;
      String publisher;
      int page;
      int price;
    }
    bookstore b1 = new bookstore();

    b1.bname = "JAVA의 정석";
    b1.author = "남궁성";
    b1.publisher = "도우출판";
    b1.page = 932;
    b1.price = 27000;

    System.out.printf("%s\n%s\n%s\n%d.P\n%d원", b1.bname, b1.author, b1.publisher, b1.page, b1.price);
  }
}