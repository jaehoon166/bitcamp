package bitcamp.java100.ch05.Test21.Test21_8.ex10;


public class ContactArray {
    static Contact[] contacts = new Contact[100];
    static int cursor = 0;
    
    static void add(Contact contact) {
        if (cursor >= contacts.length) {
            throw new RuntimeException("최대 저장 개수 초과");
        }
        contacts[cursor] = contact;
        cursor++;
    }

    static Contact get(int index) {
        if (index < 0 || index >= cursor) {
            throw new RuntimeException("유효하자 않은 인덱스");
        }
        return contacts[index];
    }

    static int size() {
        return cursor;
    }
}
