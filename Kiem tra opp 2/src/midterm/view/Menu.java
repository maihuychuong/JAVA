package midterm.view;

import midterm.entities.User;
import midterm.service.UserService;

import java.util.Scanner;

public class Menu {
    UserService userService = new UserService();

    public void displayPreLogin(Scanner scanner){
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Thoát chương trình");
        System.out.println("Mời lựa chọn: ");
        selectPreLogin(scanner);
    }
    private void selectPreLogin(Scanner scanner){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                System.out.println("Thực hiện login");
                User user = userService.login(scanner);
                if(user != null){
                    System.out.println("Chào mừng "+user.getUsername()+" , bạn có thể thực hiện các công việc sau: ");
                    displayPostLogin(scanner, user);
                } else {
                    System.out.println("Username hoặc password không đúng");
                    displayForgotPassword(scanner);
                }
                break;
            case 2:
                System.out.println("Thực hiện đăng ký");
                userService.register(scanner);
                displayPreLogin(scanner);
                break;
            case 3:
                System.exit(0);
        }
    }

    private void displayPostLogin(Scanner scanner, User user){
        System.out.println("1 - Thay đổi username");
        System.out.println("2 - Thay đổi email");
        System.out.println("3 - Thay đổi password");
        System.out.println("4 - Đăng xuất");
        System.out.println("5 - Thoát chương trình");
        System.out.println("Mời lựa chọn: ");
        selectPostLogin(scanner, user);
    }

    private void selectPostLogin(Scanner scanner, User user){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                System.out.println("Thực hiện thay đổi username: ");
                userService.changeUsername(scanner, user);
                System.out.println("Username đã được thay đổi thành công.");
                break;
            case 2:
                System.out.println("Thực hiện thay đổi email: ");
                userService.changeEmail(scanner, user);
                System.out.println("Email đã được thay đổi thành công.");
                break;
            case 3:
                System.out.println("Thực hiện thay đổi password: ");
                userService.changePassword(scanner, user);
                System.out.println("Password đã được thay đổi thành công.");
                break;
            case 4:
                System.out.println("Đăng xuất thành công.");
                displayPreLogin(scanner);
                break;
            case 5:
                System.exit(0);
        }
    }
    private void displayForgotPassword(Scanner scanner){
        System.out.println("1 - Đăng nhập lại.");
        System.out.println("2 - Quên mật khẩu");
        System.out.println("Mời lựa chọn: ");
        selectForgotPassword(scanner);
    }
    private void selectForgotPassword(Scanner scanner){
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice){
            case 1:
                System.out.println("Vui lòng đăng nhập lại: ");
                userService.login(scanner);
                break;
            case 2:
                System.out.println("Thực hiện reset password: ");
                userService.resetPassword(scanner);
                System.out.println("Password đã được thay đổi thành công. Vui lòng đăng nhập lại: ");
                userService.login(scanner);
        }
    }
}
