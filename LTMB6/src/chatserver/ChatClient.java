package chatserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient {
    public static void main(String[] args) {
        String hostname = "127.0.0.1";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            Scanner scanner = new Scanner(System.in);

            // Thread nhận tin nhắn từ server
            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Đã mất kết nối với server.");
                }
            }).start();

            // Gửi tin nhắn đến server
            while (true) {
                String clientMessage = scanner.nextLine();
                out.println(clientMessage);
            }
        } catch (IOException e) {
            System.out.println("Lỗi kết nối tới server: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
