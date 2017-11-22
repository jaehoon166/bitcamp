package java100.app;

public class ArrayList<T> {
    private Object[] list = new Object[10000];
    private int cursor = 0;

    void add(T obj) {
        if (this.cursor == this.list.length) {
            System.err.println("최대 저장 개수를 초과하였습니다.");
            return;
        }
        this.list[this.cursor++] = obj;
    }

    int size() {
        return this.cursor;
    }

    @SuppressWarnings("unchecked")
    T get(int index) {
        if (index < 0 || index >= this.cursor) {
            return null;
        }
        return (T) this.list[index];
    }
}
