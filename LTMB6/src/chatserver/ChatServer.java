package chatserver;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class ChatServer {
    // Lưu trữ client (tên client và socket của client)
    private static Map<String, Socket> clients = new HashMap<>();

    public static void main(String[] args) {
        int port = 12345; // Cổng mặc định
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Chat server đang lắng nghe tại cổng: " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Đã kết nối với client: " + socket.getRemoteSocketAddress());
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi khởi động server: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Lớp xử lý từng client kết nối
    static class ClientHandler extends Thread {
        private Socket socket;
        private String clientId;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

                // Xác thực client_id
                out.println("Nhập client_id (cú pháp: client_id: xxxxxxxx): ");
                while (true) {
                    String message = in.readLine();
                    if (message != null && message.startsWith("client_id:")) {
                        clientId = message.substring(10).trim();
                        if (!clientId.isEmpty() && !clients.containsKey(clientId)) {
                            synchronized (clients) {
                                clients.put(clientId, socket);
                            }
                            out.println("Kết nối thành công! Chào mừng " + clientId);
                            broadcast(clientId + " đã tham gia phòng chat.", null);
                            break;
                        } else {
                            out.println("client_id không hợp lệ hoặc đã tồn tại. Vui lòng thử lại: ");
                        }
                    } else {
                        out.println("Sai cú pháp. Vui lòng nhập lại: ");
                    }
                }

                // Nhận và xử lý tin nhắn
                String message;
                while ((message = in.readLine()) != null) {
                    String timestamp = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss a").format(new Date());
                    String formattedMessage = timestamp + " " + clientId + ": " + message;
                    broadcast(formattedMessage, this.clientId);
                }
            } catch (IOException e) {
                System.out.println("Lỗi kết nối với client: " + clientId + ". " + e.getMessage());
            } finally {
                // Xóa client khi ngắt kết nối
                if (clientId != null) {
                    synchronized (clients) {
                        clients.remove(clientId);
                    }
                    broadcast(clientId + " đã thoát khỏi phòng chat.", null);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Gửi tin nhắn đến tất cả các client khác
        private void broadcast(String message, String senderId) {
            synchronized (clients) {
                for (Map.Entry<String, Socket> entry : clients.entrySet()) {
                    if (senderId == null || !entry.getKey().equals(senderId)) {
                        try {
                            PrintWriter out = new PrintWriter(entry.getValue().getOutputStream(), true);
                            out.println(message);
                        } catch (IOException e) {
                            System.out.println("Lỗi khi gửi tin nhắn đến client: " + entry.getKey());
                        }
                    }
                }
            }
        }
    }
}
