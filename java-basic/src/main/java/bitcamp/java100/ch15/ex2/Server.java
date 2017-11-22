package bitcamp.java100.ch15.ex2;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {

        ServerSocket ss = new ServerSocket(9999, 3);
        System.out.println("서버를 실행하였다!");

        Scanner keyScan = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("클라이언트 승인!");
            keyScan.nextLine();

            Socket socket = ss.accept();
            System.out.println("클라이언트와 연결되었다!");
            System.out.printf("%s:%d\n", socket.getInetAddress().getHostAddress(), socket.getPort());

            socket.close();

        }

        ss.close();
        System.out.println("서버를 종료하였다!");
    }

}
