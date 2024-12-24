import java.net.*;
import javax.swing.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876);

            System.out.println("Server đang chạy và chờ tin nhắn từ client...");
            while (true) {
                // Nhận dữ liệu từ client
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);

                // Xử lý tin nhắn nhận được
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                InetAddress clientIPAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();

                System.out.println("Nhận từ client: " + message);

                // Hiển thị popup để server nhập phản hồi
                String response = JOptionPane.showInputDialog(null, "Client: " + message + "\nNhập tin nhắn trả lời:");
                if (response == null) {
                    System.out.println("Server đã thoát.");
                    break;
                }

                // Gửi phản hồi lại client
                byte[] sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIPAddress, clientPort);
                serverSocket.send(sendPacket);

                System.out.println("Gửi phản hồi đến client: " + response);
            }

            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
