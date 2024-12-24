package bai3;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(12345);
            System.out.println("UDP Server đang chạy...");

            byte[] receiveBuffer = new byte[1024];
            byte[] sendBuffer;

            while (true) {
                // Nhận dữ liệu từ client
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket);

                String clientData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Nhận từ client: " + clientData);

                // Chuyển thành chữ in hoa
                String response = clientData.toUpperCase();
                sendBuffer = response.getBytes();

                // Gửi lại dữ liệu cho client
                DatagramPacket sendPacket = new DatagramPacket(
                        sendBuffer, sendBuffer.length,
                        receivePacket.getAddress(), receivePacket.getPort()
                );
                serverSocket.send(sendPacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

