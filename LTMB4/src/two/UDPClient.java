package two;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress serverAddress = InetAddress.getByName("192.168.0.66"); // Địa chỉ server
            byte[] sendData;
            byte[] receiveData = new byte[1024];
            Scanner scanner = new Scanner(System.in);

            while (true) {
                // Nhập câu hỏi từ người dùng
                System.out.print("Nhập số (1-12) hoặc bất kỳ để hỏi: ");
                String message = scanner.nextLine();

                // Gửi câu hỏi đến server
                sendData = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendData,
                        sendData.length,
                        serverAddress,
                        9876
                );
                clientSocket.send(sendPacket);

                // Nhận phản hồi từ server
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(receivePacket);
                String serverResponse = new String(receivePacket.getData(), 0, receivePacket.getLength());

                // Hiển thị phản hồi từ server
                System.out.println("Server trả lời: " + serverResponse);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

