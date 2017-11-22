package bitcamp.java100.ch14.ex3;

import java.io.IOException;
import java.io.OutputStream;

public class MyDataOutputStream {
    OutputStream worker;

    public MyDataOutputStream(OutputStream worker) {
        this.worker = worker;
    }

    public void writeUTF(String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");

        worker.write(bytes.length >> 8);
        worker.write(bytes.length);
        worker.write(bytes);
    }
    public void writeInt(int value) throws IOException{
        worker.write(value >> 24);
        worker.write(value >> 16);
        worker.write(value >> 8);
        worker.write(value);
    }
}
