package store.service;


import store.data.Database;
import store.entities.User;
import store.utils.Utils;

import java.util.Scanner;

public class UserService {
    //    Đăng ký
    public void register(Scanner scanner) {
        System.out.println("Nhập username: ");
        String username = Utils.inputString(scanner);
        System.out.println("Nhập email: ");
        String email = Utils.inputString(scanner);
        while (!Utils.conditionEmail(email)) {
            System.out.println("Email không hợp lệ. Vui lòng nhập email đúng định dạng.");
            email = Utils.inputString(scanner);
        }
        System.out.println("Nhập password: ");
        String password = Utils.inputString(scanner);
        while (!Utils.conditionPassword(password)) {
            System.out.println("Mật khẩu không hợp lệ. Mật khẩu phải chứa ít nhất 1 ký tự viết hoa, 1 ký tự đặc biệt và có độ dài từ 7 đến 15 ký tự.");
            password = Utils.inputString(scanner);
        }
        while (true) {
            System.out.println("Nhập vai trò: (Seller/Customer)");
            String role = Utils.inputString(scanner);
            if (!"Seller".equalsIgnoreCase(role) && !"Customer".equalsIgnoreCase(role)) {
                System.out.println("Role nhập vào không hợp lệ, mời nhập lại");
            } else {
                if (findUserByUsernameAndEmail(username, email) == null) {
                    Database.users.add(new User(username, password, email, role));
                    System.out.println("Đăng lý thành công");
                } else {
                    System.out.println("Username hoặc email đã tồn tại ");
                }
                break;
            }
        }
    }

    //    Đăng nhập
    public User login(Scanner scanner) {
        System.out.println("Nhập username: ");
        String username = Utils.inputString(scanner);
        System.out.println("Nhập password: ");
        String password = Utils.inputString(scanner);
        User user = findUserByUsernameAndPassword(username, password);
        if (user != null) {
            return user;
        } else {
            return null;
        }
    }

    //    Tìm người dùng bằng tên đăng nhập
    private User findUserByUsername(String username) {
        for (User user : Database.users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    //    Tìm người dùng bằng email
    private User findUserByEmail(String email) {
        for (User user : Database.users) {
            if (user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    //    Tìm người dùng bằng tên đăng nhập và mật khẩu
    private User findUserByUsernameAndPassword(String username, String password) {
        for (User user : Database.users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    //    Tìm người dùng bằng tên đăng nhập và email
    private User findUserByUsernameAndEmail(String username, String email) {
        for (User user : Database.users) {
            if (user.getUsername().equals(username) && user.getEmail().equals(email)) {
                return user;
            }
        }
        return null;
    }

    //    Đổi tên đăng nhập
    public void changeUsername(Scanner scanner, User user) {
        System.out.println("Nhập username mới: ");
        String username = Utils.inputString(scanner);
        while (findUserByUsername(username) != null) {
            System.out.println("Username đã tồn tại. Nhập lại username mới: ");
            username = Utils.inputString(scanner);
        }
        user.setUsername(username);
        System.out.println("Username đã được thay đổi thành công.");
    }

    //    Đổi email
    public void changeEmail(Scanner scanner, User user) {
        System.out.println("Nhập email mới: ");
        String email = Utils.inputString(scanner);
        while (!Utils.conditionEmail(email) || findUserByEmail(email) != null) {
            if (!Utils.conditionEmail(email)) {
                System.out.println("Email không hợp lệ. Nhập lại email mới: ");
            } else {
                System.out.println("Email đã tồn tại. Nhập lại email mới: ");
            }
            email = Utils.inputString(scanner);
        }
        user.setEmail(email);
    }

    //    Đổi mật khẩu
    public void changePassword(Scanner scanner, User user) {
        System.out.println("Nhập password mới: ");
        String password = Utils.inputString(scanner);
        while (!Utils.conditionPassword(password)) {
            System.out.println("Password không hợp lệ. Nhập lại password mới: ");
            password = Utils.inputString(scanner);
        }
        user.setPassword(password);
    }

    //    Đặt lại mật khẩu
    public void resetPassword(Scanner scanner) {
        System.out.println("Nhập email của tài khoản cần reset mật khẩu: ");
        String email = Utils.inputString(scanner);
        User user = findUserByEmail(email);
        while (user == null) {
            System.out.println("Email không tồn tại. Nhập lại email: ");
            email = Utils.inputString(scanner);
            user = findUserByEmail(email);
        }
        changePassword(scanner, user);
    }

    //    Thay đổi quyền của người dùng
    public void changeUserRole(Scanner scanner) {
        System.out.println("Nhập tên người dùng cần thay đổi quyền:");
        String username = Utils.inputString(scanner);
        User user = findUserByUsername(username);
        if (user != null) {
            System.out.println("Người dùng hiện tại: " + user);
            System.out.println("Vai trò người dùng hiện tại: " + user.getRole());
            System.out.println("Nhập vai trò mới: (Seller/Customer)");
            String role = Utils.inputString(scanner);
            while (!"seller".equalsIgnoreCase(role) && !"Customer".equalsIgnoreCase(role)) {
                System.out.println("Vai trò không hợp lệ. Vui lòng nhập lại (Seller/Customer):");
                role = Utils.inputString(scanner);
            }
            if (user.getRole().equalsIgnoreCase(role)) {
                System.out.println("Người dùng đã có quyền " + role + ", không thể thay đổi");
            } else {
                user.setRole(role);
                System.out.println("Quyền của người dùng " + user.getUsername() + " đã được thay đổi thành: " + user.getRole());
            }
        } else {
            System.out.println("Không tìm thấy người dùng với tên đã nhập.");
        }
    }

    //    Khóa/Mở khóa tài khoản người dùng
    public void lockUnlockAccount(Scanner scanner) {
        System.out.println("Nhập tên người dùng muốn khóa/mở khóa:");
        String username = Utils.inputString(scanner);
        User user = findUserByUsername(username);
        if (user != null) {
            if (user.isLocked()) {
                System.out.println("Tài khoản này đang bị khóa. Bạn có muốn mở khóa không? (Y/N)");
                String confirm = Utils.inputString(scanner);
                while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N")) {
                    System.out.println("Lựa chọn bạn nhập không hợp lệ. Vui lòng thử lại.");
                    confirm = Utils.inputString(scanner);
                }
                if (confirm.equalsIgnoreCase("Y")) {
                    user.setLocked(false);
                    System.out.println("Tài khoản " + user.getUsername() + " đã được mở khóa");
                } else if (confirm.equalsIgnoreCase("N")) {
                    System.out.println("Tài khoản vẫn đang bị khóa");
                }
            } else {
                System.out.println("Tài khoản đang hoạt động bình thường. Bạn có muốn khóa không? (Y/N)");
                String confirm = Utils.inputString(scanner);
                while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N")) {
                    System.out.println("Lựa chọn bạn nhập không hợp lệ. Vui lòng thử lại.");
                    confirm = Utils.inputString(scanner);
                }
                if (confirm.equalsIgnoreCase("Y")) {
                    user.setLocked(true);
                    System.out.println("Tài khoản " + user.getUsername() + " đã bị khóa");
                } else if (confirm.equalsIgnoreCase("N")) {
                    System.out.println("Tài khoản vẫn đang hoạt động");
                }
            }
        }
    }
}
