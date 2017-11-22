package bitcamp.java100.ch15.ex4;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) throws Exception {

        ArrayList<SenderStub> senders = new ArrayList<>();
        ArrayList<ReceiverStub> receivers = new ArrayList<>();
        
        ServerSocket ss = new ServerSocket(9999);

        for (int i = 0; i < 46; i++) {
            Socket socket = ss.accept();

            Scanner in = new Scanner(socket.getInputStream());
            String message = in.nextLine();

            if (message.equals("receiver")) {
                receivers.add(new ReceiverStub(socket));
            } else {
                senders.add(new SenderStub(socket));
            }

        }
        for(SenderStub sender : senders) {
            String message = sender.nextMessage();
            for(ReceiverStub receiver : receivers) {
                receiver.receive(message);
                
            }
        }
    }
}
