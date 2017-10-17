package bitcamp.java100.Test17_17.step6;

public class Rect {
    int width;
    int height;
    
    static float area(Rect r) {
        return (r.width * r.height) / 10000f;
    }

    static float pyeong(Rect r) {
        return (r.width * r.height) / 10000f / 3.3f;
    }

}
