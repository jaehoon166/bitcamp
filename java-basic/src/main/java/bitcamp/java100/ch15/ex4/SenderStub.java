package bitcamp.java100.ch15.ex4;

import java.net.Socket;
import java.util.Scanner;

public class SenderStub {
    Socket socket;
    Scanner in;

    public SenderStub(Socket socket) throws Exception {
        this.socket = socket;
        System.out.printf("송신자 %s가 연결 되었습니다.", socket.getInetAddress().getHostAddress());

        in = new Scanner(socket.getInputStream());
    }

    public String nextMessage() {
        return in.nextLine();
    }
}
