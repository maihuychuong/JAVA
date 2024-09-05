package view;

import entities.User;
import service.UserService;

import java.util.List;
import java.util.Scanner;

public class Menu {
    UserService userService = new UserService();

    public void mainMenu(Scanner scanner) {
        while (true) {
            System.out.println("1 - Đăng nhập");
            System.out.println("2 - Đăng ký");
            System.out.println("3 - Thoát chương trình");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    userService.register(scanner);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private void userMenu(Scanner scanner, User user) {
        while (true) {
            System.out.println("Chào mừng " + user.getUsername() + " Bạn có thể thực hiện các công việc sau:");
            System.out.println("1 - Thay đổi username");
            System.out.println("2 - Thay đổi email");
            System.out.println("3 - Thay đổi password");
            System.out.println("4 - Đăng xuất");
            System.out.println("5 - Thoát chương trình");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    userService.changeUsername(user, scanner);
                    break;
                case 2:
                    userService.changeEmail(user, scanner);
                    break;
                case 3:
                    userService.changePassword(user, scanner);
                    break;
                case 4:
                    System.out.println("Đăng xuất thành công!");
                    mainMenu(scanner);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private void loginMenu(Scanner scanner) {
        while (true) {
            System.out.println("Mời bạn chọn:");
            System.out.println("1 - Đăng nhập lại.");
            System.out.println("2 - Quên mật khẩu");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    login(scanner);
                    break;
                case 2:
                    resetPassword(scanner);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }

    private User login(Scanner scanner) {
        System.out.println("Nhập username: ");
        String username = scanner.nextLine();
        System.out.println("Nhập password: ");
        String password = scanner.nextLine();
        User user = userService.checkUser(username, password);
        if (user != null) {
            System.out.println("Đăng nhập thành công!");
            userMenu(scanner, user);
            return user;
        } else {
            System.out.println("Username hoặc password không chính xác.");
            loginMenu(scanner);
            return null;
        }
    }

    private User resetPassword(Scanner scanner) {
        System.out.println("Nhập email để reset mật khẩu: ");
        String email = scanner.nextLine();
        User user = userService.resetPasswordEmail(email);
        if (user != null) {
            System.out.println("Email hợp lệ. Nhập mật khẩu mới: ");
            String newPassword;
            do {
                newPassword = scanner.nextLine();
                if (!userService.conditionPassword(newPassword)) {
                    System.out.println("Password không hợp lệ. Vui lòng thử lại.");
                }
            } while (!userService.conditionPassword(newPassword));
            user.setPassword(newPassword);
            System.out.println("Mật khẩu đã được đổi thành công. Mời bạn đăng nập lại.");
            login(scanner);
        } else {
            System.out.println("Email không tồn tại. Vui lòng kiểm tra lại.");
        }
        return user;
    }
}
