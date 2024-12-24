package bai2;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import java.io.IOException;

public class MyFTPClient {
    public static void main(String[] args) {
        String server = "localhost";
        int port = 21;
        String user = "username";
        String password = "password";

        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(server, port);
            System.out.println("Kết nối thành công đến máy chủ: " + server);
        } catch (IOException ex) {
            System.out.println("Không thể kết nối đến máy chủ FTP tại " + server + ":" + port);
            System.out.println("Lỗi: " + ex.getMessage());
            ex.printStackTrace();
            return; // Thoát chương trình
        }

        try {
            // Kết nối đến server
            ftpClient.connect(server, port);
            System.out.println("Đã kết nối đến máy chủ: " + server);

            // Đăng nhập
            boolean login = ftpClient.login(user, password);
            if (login) {
                System.out.println("Đăng nhập thành công!");

                // Chuyển sang chế độ Binary
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

                // Hiển thị danh sách thư mục và tệp
                System.out.println("Danh sách thư mục và tệp trên máy chủ:");
                FTPFile[] files = ftpClient.listFiles();
                if (files.length == 0) {
                    System.out.println("Thư mục trống.");
                } else {
                    for (FTPFile file : files) {
                        String type = file.isDirectory() ? "Thư mục" : "Tệp";
                        System.out.printf("Tên: %s, Kích thước: %d bytes, Kiểu: %s, Ngày sửa: %s\n",
                                file.getName(),
                                file.getSize(),
                                type,
                                file.getTimestamp().getTime()
                        );
                    }
                }

                // Tạo thư mục mới
                String newDir = "new_directory";
                boolean exists = false;
                for (FTPFile file : files) {
                    if (file.isDirectory() && file.getName().equals(newDir)) {
                        exists = true;
                        break;
                    }
                }

                if (exists) {
                    System.out.println("Thư mục '" + newDir + "' đã tồn tại.");
                } else {
                    if (ftpClient.makeDirectory(newDir)) {
                        System.out.println("Đã tạo thư mục: " + newDir);
                    } else {
                        System.out.println("Không thể tạo thư mục!");
                    }
                }

                // Đăng xuất
                ftpClient.logout();
                System.out.println("Đã đăng xuất khỏi máy chủ FTP.");
            } else {
                System.out.println("Đăng nhập thất bại! Kiểm tra lại thông tin đăng nhập.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (ftpClient.isConnected()) {
                    ftpClient.disconnect();
                    System.out.println("Đã ngắt kết nối khỏi máy chủ FTP.");
                }
            } catch (IOException ex) {
                System.out.println("Lỗi khi ngắt kết nối.");
                ex.printStackTrace();
            }
        }
    }
}


