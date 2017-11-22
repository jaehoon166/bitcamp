package bitcamp.java100.ch15.ex6;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class HTTPClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("www.etnews.com", 80);
        PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));

        out.println("GET / HTTP/1.1");
        out.println("Host: www.etnews.com");
        out.println();
        out.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line;
        while (true) {
            line = in.readLine();
            System.out.println(line);
            if (line.equals(""))
                break;
        }
        int b;
        while ((b = in.read()) != -1) {
            System.out.print((char) b);
        }
        out.close();
        in.close();
        socket.close();
    }
}
