package bitcamp.java100.ch09.ex6;

public class Test2 {

    public static void main(String[] args) {
        Stack2<Contact> conteacts = new Stack2<>();
        conteacts.push(new Contact("홍길동", "hong@test.com", "111-1111-1111"));
        conteacts.push(new Contact("임꺽정", "leem@test.com", "111-1111-1112"));
        conteacts.push(new Contact("유관순", "yoo@test.com", "111-1111-1113"));

        // conteacts.push(new String("안중근"));
        // conteacts.push(new Boolean(true));


        // BookStack///////////////////////////////////////////////////////////////////////
        Stack2<Book> bookStack = new Stack2<>();
        bookStack.push(new Book());
        bookStack.push(new Book());

        // bookStack.push(new String());
        // bookStack.push(new Integer(20));

        Book b1 = bookStack.pop();
        Book b2 = bookStack.pop();

        // ScoreStack///////////////////////////////////////////////////////////////////////
        Stack2<Score> scoreStack = new Stack2<>();
        scoreStack.push(new Score());
        scoreStack.push(new Score());

        Score s1 = scoreStack.pop();
        Score s2 = scoreStack.pop();

        // ContactStack///////////////////////////////////////////////////////////////////////
        Stack2<Contact> contactStack = new Stack2<>();
        contactStack.push(new Contact());
        contactStack.push(new Contact());

        Contact c1 = contactStack.pop();
        Contact c2 = contactStack.pop();
    }
}
