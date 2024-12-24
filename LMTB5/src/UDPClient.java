import java.net.*;
import javax.swing.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");

            while (true) {
                // Hiển thị popup để nhập tin nhắn
                String message = JOptionPane.showInputDialog(null, "Nhập tin nhắn gửi đến server:");
                if (message == null) {
                    System.out.println("Client đã thoát.");
                    break;
                }

                // Gửi dữ liệu đến server
                byte[] sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
                clientSocket.send(sendPacket);
                System.out.println("Client gửi: " + message);

                // Nhận dữ liệu từ server
                byte[] receiveData = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);

                // Hiển thị phản hồi từ server
                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server phản hồi: " + response);
                JOptionPane.showMessageDialog(null, "Server: " + response);
            }

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
