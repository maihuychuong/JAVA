package one;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket serverSocket = new DatagramSocket(9876); // Mở socket trên cổng 9876
            byte[] receiveData = new byte[1024];
            byte[] sendData;

            System.out.println("Server is running...");

            while (true) {
                // Nhận dữ liệu từ client
                DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                serverSocket.receive(receivePacket);
                String clientMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());

                System.out.println("Received from client: " + clientMessage);

                // Trả lời tương ứng
                String response;
                switch (clientMessage) {
                    case "1": response = "Thang gieng"; break;
                    case "2": response = "Thang hai"; break;
                    case "3": response = "Thang ba"; break;
                    case "4": response = "Thang tu"; break;
                    case "5": response = "Thang nam"; break;
                    case "6": response = "Thang sau"; break;
                    case "7": response = "Thang bay"; break;
                    case "8": response = "Thang tam"; break;
                    case "9": response = "Thang chin"; break;
                    case "10": response = "Thang muoi"; break;
                    case "11": response = "Thang muoi mot"; break;
                    case "12": response = "Thang chap"; break;
                    default: response = "Ban nhap sai roi"; break;
                }

                // Gửi dữ liệu phản hồi về client
                sendData = response.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendData,
                        sendData.length,
                        receivePacket.getAddress(),
                        receivePacket.getPort()
                );
                serverSocket.send(sendPacket);

                System.out.println("Sent to client: " + response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

