package App;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("서버주소? ");
        String serverAddr = keyboard.nextLine();

        while (true) {
            System.out.print("명령>");
            String command = keyboard.nextLine();

            if (command.equals("quit")) {
                break;
            }

            try (Socket socket = new Socket(serverAddr, 9999);
                    PrintStream out = new PrintStream(new BufferedOutputStream(socket.getOutputStream()));
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

                out.println(command);
                out.flush();

                while (true) {
                    String line = in.readLine();
                    if (line.isEmpty())
                        break;
                    System.out.println(line);
                }
            }

            catch (Exception e) {
                e.printStackTrace();
            }

        }
        keyboard.close();
    }
}